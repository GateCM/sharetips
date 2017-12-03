/**
 * 
 */
package com.gatecm.tip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO(登录注册控制器)
 * @author chenxiaohui
 * @date 2017年10月16日 下午2:06:50
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String loginPage() {
		return "/member/signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String regPage() {
		return "/member/signup";
	}
}
