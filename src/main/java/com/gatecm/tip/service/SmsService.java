package com.gatecm.tip.service;

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
	Rrs sendRegVcode(String phoneNumber);

}
