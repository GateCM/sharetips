package com.gatecm.tip.service.impl;

import com.gatecm.tip.entity.MemberBasic;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.service.IMemberBasicService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息表，用来存储用户最基本的信息。 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-02
 */
@Service
public class MemberBasicServiceImpl extends ServiceImpl<MemberBasicDao, MemberBasic> implements IMemberBasicService {
	
}
