package com.gatecm.tip.service;

import com.gatecm.tip.plugin.sms.VcodeBean;

/**
 * @ClassName: SMSService
 * @Description: TODO(短信)
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:08:49
 *
 */
public interface SmsService {

	/**
	 * 发送注册短信
	 * 
	 * @param phoneNumber
	 * @return
	 */
	Rrs<VcodeBean> sendRegVcode(String phoneNumber);

}
