/**
 * 
 */
package com.gatecm.tip.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年10月16日 下午2:06:50
 *
 */
@Controller
@RequestMapping(value = "/api/login")
public class LoginAPI {

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String userName, String password) {
		Map<String, Object> map = new HashMap<>();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		// 获取当前的Subject+
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", false);
			return map;
		}
		// 验证是否登录成功
		if (currentUser.isAuthenticated()) {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			map.put("result", true);
			map.put("token", session);
		} else {
			map.put("result", false);
			token.clear();
		}
		return map;
	}
}