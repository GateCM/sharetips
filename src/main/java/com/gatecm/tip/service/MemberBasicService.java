package com.gatecm.tip.service;

import com.gatecm.tip.dto.MemberRegisterDto;
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
	Rrs registByVcode(MemberRegisterDto registerDto);

}
