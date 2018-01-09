package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.constant.ErrorEnum;
import com.gatecm.tip.constant.TipEnum;
import com.gatecm.tip.dto.PaginationDto;
import com.gatecm.tip.dto.TipContentDto;
import com.gatecm.tip.dto.vo.TipVo;
import com.gatecm.tip.entity.TipContent;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.mapper.TipCommentDao;
import com.gatecm.tip.mapper.TipContentDao;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.Date;
import java.util.List;

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
	private ShiroSessionUtils shiroSessionUtils;

	@Autowired
	private TipContentDao tipContentDao;

	@Autowired
	private MemberBasicDao memberBasicDao;
	
	@Autowired
	private TipCommentDao tipCommentDao;

	// @CachePut(value = "tip", key = "#tip.tipId")
	@Override
	public Rrs saveDraft(TipContentDto tip) {
		tip.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());
		return createOrUpdateTipByDto(tip);
	}

	/**
	 * 更新tip
	 * 
	 * @param tipContent
	 * @return
	 */
	private Rrs updateTip(TipContent tipContent) {
		tipContent.setGmtUpdate(new Date());
		return new Rrs(tipContentDao.updateById(tipContent).equals(1), tipContent.getId());
	}

	/**
	 * 创建新tip
	 * 
	 * @param tipContent
	 * @return
	 */
	private Rrs createNewTip(TipContent tipContent) {
		Long memberId = shiroSessionUtils.getMemberId();
		tipContent.setId(null);
		tipContent.setBelongMemberId(memberId);
		tipContent.setGmtCreate(new Date());
		tipContent.setGmtUpdate(tipContent.getGmtCreate());
		return new Rrs(tipContentDao.insert(tipContent).equals(1), tipContent.getId());
	}

	/**
	 * 判断用户是否为tip拥有者
	 * 
	 * @param tipId
	 * @return
	 */
	private boolean validTipBelongMember(Long tipId) {
		Long memberId = shiroSessionUtils.getMemberId();
		TipContent currentTip = tipContentDao.selectById(tipId);
		if (currentTip == null) {
			return false;
		}
		return currentTip.getBelongMemberId().equals(memberId);
	}

	@Override
	public Rrs draftList(PaginationDto pagination) {
		Long belongMemberId = shiroSessionUtils.getMemberId();
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setBelongMemberId(belongMemberId);
		selectParam.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());
		selectParam.setDelF(BaseConstant.UN_DEL);
		List<TipVo> draftVos = tipContentDao.selectVoByParam(selectParam);
		PageInfo<TipVo> pageInfo = new PageInfo<>(draftVos, (Integer) TipEnum.PAG_NAV_PAGES_DRAFT.getValue());
		return new Rrs(true, pageInfo);
	}

	// @Cacheable(value = "tip", key = "#tipId")
	@Override
	public Rrs getDraftTip(Long tipId) {
		TipContent draftTip = tipContentDao.selectById(tipId);
		return new Rrs(true, draftTip);
	}

	// @Cacheable(value = "index", key = "#pagination.pageSize")
	@Override
	public Rrs releaseList(PaginationDto pagination) {
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setStatus((Integer) TipEnum.STATUS_RELEASE.getValue());
		List<TipVo> releaseTips = tipContentDao.selectVoByParam(selectParam);
		for (TipVo tv : releaseTips) {
			addBelongMemberVo(tv);
			tv.setCommentCount(tipCommentDao.selectCountByTipId(tv.getId()));
		}
		PageInfo<TipVo> pageInfo = new PageInfo<>(releaseTips);
		return new Rrs(true, pageInfo);
	}

	@Override
	public Rrs getDetail(Long tipId) {
		TipVo tv = tipContentDao.selectVoById(tipId);
		addBelongMemberVo(tv);
		return new Rrs(true, tv);
	}

	private void addBelongMemberVo(TipVo tv) {
		tv.setBelongMember(memberBasicDao.selectVoById(tv.getBelongMemberId()));
	}

	@Override
	public Rrs releaseDraft(TipContentDto tip) {
		tip.setStatus((Integer) TipEnum.STATUS_RELEASE.getValue());
		return createOrUpdateTipByDto(tip);
	}

	/**
	 * 新增或更新tip
	 * 
	 * @param tip
	 * @return
	 */
	private Rrs createOrUpdateTipByDto(TipContentDto tip) {
		if (tip.getTipId() != null) {
			// 判断操作用户是否为tip拥有者
			if (!validTipBelongMember(tip.getTipId())) {
				return new Rrs(false, ErrorEnum.SYS_EXCEPTION);
			}
			// 更新tip
			return updateTip(tip.convert2TipContent());
		}
		// 插入tip
		return createNewTip(tip.convert2TipContent());
	}

	@Override
	public Rrs findMemberReleaseTip(PaginationDto pagination) {
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setStatus((Integer) TipEnum.STATUS_RELEASE.getValue());
		selectParam.setBelongMemberId(shiroSessionUtils.getMemberId());
		List<TipVo> releaseTips = tipContentDao.selectVoByParam(selectParam);
		for (TipVo tv : releaseTips) {
			addBelongMemberVo(tv);
		}
		PageInfo<TipVo> pageInfo = new PageInfo<>(releaseTips);
		return new Rrs(true, pageInfo);
	}

	@Override
	public Rrs deleteDraft(Long tipId) {
		if (validTipBelongMember(tipId)) {
			TipContent updateParam = new TipContent();
			updateParam.setId(tipId);
			updateParam.setDelF(BaseConstant.IS_DEL);
			Integer result = tipContentDao.updateById(updateParam);
			return new Rrs(result.equals(1));
		}
		return new Rrs(false);
	}

}
