package com.gatecm.tip.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gatecm.tip.entity.MemberIdentity;
import com.gatecm.tip.mapper.MemberIdentityDao;
import com.gatecm.tip.service.MemberIdentityService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 商户身份映射表 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-10-17
 */
@Service
public class MemberIdentityServiceImpl extends ServiceImpl<MemberIdentityDao, MemberIdentity> implements MemberIdentityService {
	
}
