/**  
* @Title: MemberAPI.java
* @Package com.gatecm.tip.api
* @Description: TODO()
* @author chenxiaohui
* @date 2017年12月2日 下午6:09:14
* @version V1.0  
*/ 
package com.gatecm.tip.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
* @ClassName: MemberAPI
* @Description: TODO()
* @author chenxiaohui
* @date 2017年12月2日 下午6:09:14
*
*/
@RestController
@RequestMapping(value="/api/member")
public class MemberAPI {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(String userName, String password) {
		Map<String, Object> map = new HashMap<>();
		return map;
	}

}
