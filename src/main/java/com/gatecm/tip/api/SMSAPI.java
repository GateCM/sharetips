package com.gatecm.tip.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.SMSService;

/**
 * @ClassName: SMSAPI
 * @Description: TODO(短信控制器)
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:05:56
 *
 */
@Controller
@RequestMapping(value = "/api/sms/")
public class SMSAPI {

	@Autowired
	private SMSService smsService;

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public Rrs reg(String phoneNumber) {
		return smsService.sendRegVcode(phoneNumber);
	}
}
