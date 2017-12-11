package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.PasswordEntity;
import com.gatecm.tip.config.shiro.PasswordHelper;
import com.gatecm.tip.constant.ErrorEnum;
import com.gatecm.tip.constant.MemberEnum;
import com.gatecm.tip.dto.MemberRegisterDto;
import com.gatecm.tip.entity.MemberBasic;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.plugin.sms.SmsUtils;
import com.gatecm.tip.plugin.sms.VcodeEnum;
import com.gatecm.tip.service.MemberBasicService;
import com.gatecm.tip.service.Rrs;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Rrs registByVcode(MemberRegisterDto registerDto) {
		// 验证码校验
		Rrs rrs = validationVcode(registerDto.getPhoneNumber(), registerDto.getVcode());
		if (!rrs.getResult()) {
			return rrs;
		}
		MemberBasic entity = new MemberBasic();
		entity.setGmtCreate(new Date());
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
	private Rrs validationVcode(String phoneNumber, String vcode) {
		Rrs rrs = new Rrs(false);
		VcodeEnum vcodeEnum = smsUtils.validation(phoneNumber, vcode);
		switch (vcodeEnum) {
		case VCODE_CORRECT:
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

}
