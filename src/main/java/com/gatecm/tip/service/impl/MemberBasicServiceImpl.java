package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.PasswordEntity;
import com.gatecm.tip.config.shiro.PasswordHelper;
import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.constant.ErrorEnum;
import com.gatecm.tip.constant.MemberEnum;
import com.gatecm.tip.dto.MemberDto;
import com.gatecm.tip.dto.MemberRegisterDto;
import com.gatecm.tip.dto.vo.MemberVo;
import com.gatecm.tip.entity.MemberBasic;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.plugin.sms.SmsUtils;
import com.gatecm.tip.plugin.sms.VcodeEnum;
import com.gatecm.tip.service.MemberBasicService;
import com.gatecm.tip.service.Rrs;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 用户基本信息表，用来存储用户最基本的信息。 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-02
 */
@Service("memberBasicService")
public class MemberBasicServiceImpl extends ServiceImpl<MemberBasicDao, MemberBasic> implements MemberBasicService {

	@Autowired
	private SmsUtils smsUtils;

	@Autowired
	private ShiroSessionUtils shiroSessionUtils;

	@Autowired
	private MemberBasicDao memberBasicDao;

	@Override
	public Rrs<Object> registByVcode(MemberRegisterDto registerDto) {
		// 验证码校验
		Rrs<Object> rrs = validationVcode(registerDto.getPhoneNumber(), registerDto.getVcode());
		if (!rrs.getResult()) {
			return rrs;
		}
		MemberBasic entity = new MemberBasic();
		entity.setGmtCreate(new Date());
		entity.setHeadUrl(BaseConstant.DEFAULT_HEAD_IMG);
		entity.setNickname(registerDto.getNickname());
		entity.setStatus(Integer.valueOf(MemberEnum.STATUS_NORMAL.getValue().toString()));
		entity.setPhoneNumber(registerDto.getPhoneNumber());
		// 盐值加密
		PasswordEntity passwordSalt = PasswordHelper.encryptPassword(registerDto.getPassword());
		entity.setPassword(passwordSalt.getPassword());
		entity.setSalt(passwordSalt.getSalt());
		rrs.setResult(insert(entity));
		return rrs;
	}

	/**
	 * 短信验证码校验
	 */
	private Rrs<Object> validationVcode(String phoneNumber, String vcode) {
		Rrs<Object> rrs = new Rrs<>(false);
		VcodeEnum vcodeEnum = smsUtils.validation(phoneNumber, vcode);
		switch (vcodeEnum) {
		case VCODE_CORRECT:
			// 移除
			smsUtils.removeVcodeByPhoneNumber(phoneNumber);
			rrs.setResult(true);
			break;
		case VCODE_TIME_OUT:
			rrs.setError(ErrorEnum.VCODE_TIME_OUT);
			break;
		case VCODE_ERROR:
			rrs.setError(ErrorEnum.VCODE_ERROR);
			break;
		default:
			rrs.setError(ErrorEnum.VCODE_ERROR);
			break;
		}
		return rrs;
	}

	@Override
	public Rrs<MemberBasic> getCurrentMemberInfo() {
		Rrs<MemberBasic> rrs = new Rrs<>(true);
		MemberBasic memberBasic = shiroSessionUtils.getMember();
		if (memberBasic == null) {
			rrs.setResult(false);
			return rrs;
		}
		rrs.setData(memberBasic);
		return rrs;
	}

	@Override
	public Rrs<Object> resetPassowrd(MemberRegisterDto registerDto) {
		// 验证码校验
		String phoneNumber = registerDto.getPhoneNumber();
		Rrs<Object> rrs = validationVcode(phoneNumber, registerDto.getVcode());
		if (!rrs.getResult()) {
			return rrs;
		}
		MemberVo current = getMemberVoByPhoneNumber(phoneNumber);
		if (current == null) {
			return new Rrs<>(false);
		}
		MemberBasic entity = new MemberBasic();
		entity.setId(current.getId());
		// 盐值加密
		PasswordEntity passwordSalt = PasswordHelper.encryptPassword(registerDto.getPassword());
		entity.setPassword(passwordSalt.getPassword());
		entity.setSalt(passwordSalt.getSalt());
		rrs.setResult(updateById(entity));
		return rrs;
	}

	private MemberVo getMemberVoByPhoneNumber(String phoneNumber) {
		MemberBasic selectParam = new MemberBasic();
		selectParam.setPhoneNumber(phoneNumber);
		selectParam.setDelF(BaseConstant.UN_DEL);
		List<MemberVo> member = memberBasicDao.selectVoByParam(selectParam);
		if (CollectionUtils.isEmpty(member)) {
			return null;
		}
		return member.get(0);
	}

	@Override
	public Rrs<Object> phoneNumberAvailable(String phoneNumber) {
		MemberVo current = getMemberVoByPhoneNumber(phoneNumber);
		return new Rrs<>(current == null);
	}

	@Override
	public Rrs<MemberVo> getBasicInfo() {
		MemberVo memberVo = memberBasicDao.selectVoById(shiroSessionUtils.getMemberId());
		return new Rrs<>(true, memberVo);
	}

	@Override
	public Rrs<Object> resetBasic(MemberDto memberDto) {
		MemberBasic entity = memberDto.returnUpdateBasic();
		entity.setId(shiroSessionUtils.getMemberId());
		return new Rrs<>(updateById(entity));
	}
}
