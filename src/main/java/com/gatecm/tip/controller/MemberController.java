package com.gatecm.tip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(value = "/a/tip")
	public String tip() {
		return "member/tip-draft-list";
	}

	/**
	 * 个人空间
	 * 
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/{memberId}/space")
	public String space(@PathVariable Long memberId) {
		return "member/space";
	}
	
	/**
	 * 个人中心
	 * 
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value = "/a/center")
	public String center() {
		return "member/center";
	}
}
