package com.gatecm.tip.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.dto.MemberRegisterDto;
import com.gatecm.tip.service.MemberBasicService;
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

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Rrs reg(@Valid MemberRegisterDto registerDto) {
		return memberBasicService.registByVcode(registerDto);
	}
}
