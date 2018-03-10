package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.entity.MemberSign;
import com.gatecm.tip.mapper.MemberSignDao;
import com.gatecm.tip.service.MemberSignService;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.util.TimeUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 用户签到表，记录用户签到 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-09
 */
@Service("memberSignService")
public class MemberSignServiceImpl implements MemberSignService {

	@Autowired
	private ShiroSessionUtils shiroSessionUtils;

	@Autowired
	private MemberSignDao memberSignDao;

	@Override
	public Rrs<Object> isSignToday() {
		Long memberId = shiroSessionUtils.getMemberId();
		Map<String, Object> columnMap = new HashMap<>();
		columnMap.put("member_id", memberId);
		columnMap.put("sign_date", TimeUtils.getDateNow());
		columnMap.put("del_f", BaseConstant.UN_DEL);
		List<MemberSign> records = memberSignDao.selectByMap(columnMap);
		return new Rrs<>(!CollectionUtils.isEmpty(records));
	}

	@Override
	public Rrs<Object> signToday() {
		// 判断今日是否签到
		Rrs<Object> rrs = isSignToday();
		if (rrs.getResult()) {
			rrs.setResult(false);
			return rrs;
		}
		Date current = new Date();
		MemberSign insertParam = new MemberSign();
		insertParam.setMemberId(shiroSessionUtils.getMemberId());
		insertParam.setGmtCreate(current);
		insertParam.setGmtUpdate(current);
		insertParam.setSignDate(current);
		insertParam.setGainPoint(0);
		insertParam.setIsRepaired(0);
		insertParam.setDelF(BaseConstant.UN_DEL);
		rrs.setResult(memberSignDao.insert(insertParam).equals(1));
		return rrs;
	}
}
