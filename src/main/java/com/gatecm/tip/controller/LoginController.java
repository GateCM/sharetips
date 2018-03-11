/**
 * 
 */
package com.gatecm.tip.controller;

import org.apache.shiro.SecurityUtils;
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

	/**
	 * 登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/signin")
	public String loginPage() {
		return "member/signin";
	}

	/**
	 * 注册页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/signup")
	public String signupPage() {
		return "member/signup";
	}

	/**
	 * 重置密码页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/reset/pw")
	public String resetPassword() {
		return "member/reset-password";
	}

	/**
	 * 退出并返回登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/a/signout")
	public String signOut() {
		SecurityUtils.getSubject().logout();
		return "member/signin";
	}
}
