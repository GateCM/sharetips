package com.gatecm.tip.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.dto.MemberDto;
import com.gatecm.tip.dto.MemberRegisterDto;
import com.gatecm.tip.dto.vo.MemberVo;
import com.gatecm.tip.service.MemberBasicService;
import com.gatecm.tip.service.MemberSignService;
import com.gatecm.tip.service.Rrs;

/**
 * @ClassName: MemberAPI
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月2日 下午6:09:14
 *
 */
@RestController
@RequestMapping(value = "/api/member")
public class MemberApi {

	@Autowired
	private MemberBasicService memberBasicService;

	@Autowired
	private MemberSignService memberSignService;

	/**
	 * 手机号验证码注册
	 * 
	 * @param registerDto
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Rrs<Object> register(@Valid MemberRegisterDto registerDto) {
		return memberBasicService.registByVcode(registerDto);
	}

	/**
	 * 忘记密码重置
	 * 
	 * @param registerDto
	 * @return
	 */
	@RequestMapping(value = "/reset/pw", method = RequestMethod.PATCH)
	public Rrs<Object> resetPassword(@RequestBody MemberRegisterDto registerDto) {
		return memberBasicService.resetPassowrd(registerDto);
	}

	/**
	 * 重置基本信息(密码除外)
	 * 
	 * @param registerDto
	 * @return
	 */
	@RequestMapping(value = "/a/reset/basic", method = RequestMethod.PATCH)
	public Rrs<Object> resetBasic(@RequestBody MemberDto memberDto) {
		return memberBasicService.resetBasic(memberDto);
	}

	/**
	 * 判断当日是否签到
	 * 
	 * @return
	 */
	@RequestMapping(value = "/a/sign", method = RequestMethod.GET)
	public Rrs<Object> signTodayStatus() {
		return memberSignService.isSignToday();
	}

	/**
	 * 获取当前登录用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/a/basic", method = RequestMethod.GET)
	public Rrs<MemberVo> basic() {
		return memberBasicService.getBasicInfo();
	}

	/**
	 * 判断该手机号是否已注册
	 * 
	 * @return
	 */
	@RequestMapping(value = "/phoneNumber/available", method = RequestMethod.GET)
	public Rrs<Object> phoneNumberAvailable(String phoneNumber) {
		return memberBasicService.phoneNumberAvailable(phoneNumber);
	}

	/**
	 * 当前用户签到
	 * 
	 * @return
	 */
	@RequestMapping(value = "/a/sign", method = RequestMethod.POST)
	public Rrs<Object> signToday() {
		return memberSignService.signToday();
	}
}
