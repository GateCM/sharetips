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
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class LoginController {

	@RequestMapping(value = "/signin")
	public String loginPage() {
		return "/member/signin";
	}

	@RequestMapping(value = "/signup")
	public String signupPage() {
		return "/member/signup";
	}
}
