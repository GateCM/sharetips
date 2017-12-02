package com.gatecm.tip.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gatecm.tip.entity.Member;
import com.gatecm.tip.mapper.MemberDao;
import com.gatecm.tip.service.MemberService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户信息表 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {
	
}
