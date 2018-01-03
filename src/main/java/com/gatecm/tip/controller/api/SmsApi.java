package com.gatecm.tip.controller.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.plugin.sms.VcodeBean;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.SmsService;

/**
 * @ClassName: SMSAPI
 * @Description: TODO(短信控制器)
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:05:56
 *
 */
@RestController
@RequestMapping(value = "/api/sms/")
public class SmsApi {

	@Autowired
	private SmsService smsService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Rrs reg(String phoneNumber) {
		 return smsService.sendRegVcode(phoneNumber);
	}
//		Rrs rrs = new Rrs(true);
//		VcodeBean bean = new VcodeBean();
//		bean.setSendDate(new Date());
//		rrs.setData(bean);
//		return rrs;
//	}
}
