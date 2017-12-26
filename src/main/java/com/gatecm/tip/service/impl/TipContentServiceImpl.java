package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.TipEnum;
import com.gatecm.tip.dto.PaginationDto;
import com.gatecm.tip.dto.TipContentDto;
import com.gatecm.tip.dto.vo.TipVo;
import com.gatecm.tip.entity.TipContent;
import com.gatecm.tip.mapper.TipContentDao;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	private ShiroSessionUtils shiroSessionUtils;

	@Autowired
	private TipContentDao tipContentDao;

	@CachePut(value = "tip", key = "#tip.tipId")
	@Override
	public Rrs saveDraft(TipContentDto tip) {
		boolean isUpdate = tip.getTipId() != null;
		TipContent iuParam = new TipContent();
		Date current = new Date();
		if (isUpdate) {
			iuParam.setId(tip.getTipId());
			iuParam.setGmtUpdate(current);
			iuParam.setHeadImg(tip.getHeadImg());
			iuParam.setTitle(tip.getTitle());
			iuParam.setContent(tip.getContent());
			return new Rrs(tipContentDao.updateById(iuParam) == 1);
		}
		Long belongMemberId = shiroSessionUtils.getMemberId();
		iuParam.setGmtCreate(current);
		iuParam.setHeadImg(tip.getHeadImg());
		iuParam.setTitle(tip.getTitle());
		iuParam.setContent(tip.getContent());
		iuParam.setBelongMemberId(belongMemberId);
		iuParam.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());

		System.out.println("为id、key为:" + tip.getTipId() + " 数据做了缓存");
		Rrs rrs = new Rrs(tipContentDao.insert(iuParam) == 1);
		rrs.setData(tipContentDao.selectById(iuParam.getId()));
		return rrs;
	}

	@Override
	public Rrs draftList(PaginationDto pagination) {
		Long belongMemberId = shiroSessionUtils.getMemberId();
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setBelongMemberId(belongMemberId);
		selectParam.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());
		List<TipVo> draftVos = tipContentDao.selectVoByParam(selectParam);
		PageInfo<TipVo> pageInfo = new PageInfo<>(draftVos, (Integer) TipEnum.PAG_NAV_PAGES_DRAFT.getValue());
		return new Rrs(true, pageInfo);
	}

	@Cacheable(value = "tip", key = "#tipId")
	@Override
	public Rrs getDraftTip(Long tipId) {
		TipContent draftTip = tipContentDao.selectById(tipId);
		return new Rrs(true, draftTip);
	}

}
