package com.gatecm.tip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月19日 上午10:16:29
 *
 */
@Controller
@RequestMapping(value = "/member", method = RequestMethod.GET)
public class MemberController {

	/**
	 * 我的技巧列表
	 * 
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/tip")
	public String tip() {
		return "member/tip-draft-list";
	}
}
