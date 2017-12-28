package com.gatecm.tip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gatecm.tip.plugin.sms.SmsUtils;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.SmsService;

/**
 * @ClassName: SMSServiceImpl
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:09:17
 *
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

	@Autowired
	private SmsUtils smsUtils;

	@Override
	public Rrs sendRegVcode(String phoneNumber) {
		return smsUtils.sendRegVcode(phoneNumber);
	}

}
