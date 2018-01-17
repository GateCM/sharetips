package com.gatecm.tip.service;

import com.gatecm.tip.dto.MemberDto;
import com.gatecm.tip.dto.MemberRegisterDto;
import com.gatecm.tip.dto.vo.MemberVo;
import com.gatecm.tip.entity.MemberBasic;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 用户基本信息表，用来存储用户最基本的信息。 服务类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-02
 */
public interface MemberBasicService extends IService<MemberBasic> {

	/**
	 * 根据短信注册用户
	 * 
	 * @param registerDto
	 * @return Rrs
	 */
	Rrs<Object> registByVcode(MemberRegisterDto registerDto);

	/**
	 * 获取当前登录用户信息
	 * 
	 * @return
	 */
	Rrs<MemberBasic> getCurrentMemberInfo();

	/**
	 * 重置用户密码
	 * 
	 * @param registerDto
	 * @return
	 */
	Rrs<Object> resetPassowrd(MemberRegisterDto registerDto);

	/**
	 * @param phoneNumber
	 * @return
	 */
	Rrs<Object> phoneNumberAvailable(String phoneNumber);

	/**
	 * 获取当前用户基本信息
	 * 
	 * @return
	 */
	Rrs<MemberVo> getBasicInfo();

	/**
	 * 更新用户基本信息（密码除外）
	 * 
	 * @param memberDto
	 * @return
	 */
	Rrs<Object> resetBasic(MemberDto memberDto);
}
