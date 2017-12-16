package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.TipEnum;
import com.gatecm.tip.dto.TipContentDTO;
import com.gatecm.tip.entity.TipContent;
import com.gatecm.tip.mapper.TipContentDao;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 技巧内容表 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-16
 */
@Service
public class TipContentServiceImpl extends ServiceImpl<TipContentDao, TipContent> implements TipContentService {

	@Autowired
	private TipContentDao tipContentDao;

	@Override
	public Rrs saveDraft(TipContentDTO tip) {
		Rrs rrs = new Rrs(true);
		Long belongMemberId = ShiroSessionUtils.getMemberId();
		TipContent insertParam = new TipContent();
		insertParam.setGmtCreate(new Date());
		insertParam.setHeadImg(tip.getHeadImg());
		insertParam.setTitle(tip.getTitle());
		insertParam.setContent(tip.getContent());
		insertParam.setBelongMemberId(belongMemberId);
		insertParam.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());
		tipContentDao.insert(insertParam);
		return rrs;
	}

}
