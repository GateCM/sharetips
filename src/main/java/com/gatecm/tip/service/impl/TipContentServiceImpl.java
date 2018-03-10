package com.gatecm.tip.service.impl;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.constant.ErrorEnum;
import com.gatecm.tip.constant.TipEnum;
import com.gatecm.tip.dto.PaginationDto;
import com.gatecm.tip.dto.TipContentDto;
import com.gatecm.tip.dto.vo.MemberVo;
import com.gatecm.tip.dto.vo.TipVo;
import com.gatecm.tip.entity.SysTipPlate;
import com.gatecm.tip.entity.TipContent;
import com.gatecm.tip.entity.TipPlate;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.mapper.SysTipPlateDao;
import com.gatecm.tip.mapper.TipCommentDao;
import com.gatecm.tip.mapper.TipContentDao;
import com.gatecm.tip.mapper.TipPlateDao;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;
import com.gatecm.tip.util.RegularUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

	@Autowired
	private TipPlateDao tipPlateDao;

	@Autowired
	private SysTipPlateDao sysTipPlateDao;

	// @CachePut(value = "tip", key = "#tip.tipId")
	@Override
	@Transactional
	public Rrs<Long> saveDraft(TipContentDto tip) {
		tip.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());
		return createOrUpdateTipByDto(tip);
	}

	/**
	 * 更新tip
	 * 
	 * @param tipContent
	 * @return
	 */
	private Rrs<Long> updateTip(TipContent tipContent) {
		tipContent.setGmtUpdate(new Date());
		return new Rrs<>(tipContentDao.updateById(tipContent).equals(1), tipContent.getId());
	}

	/**
	 * 创建新tip
	 * 
	 * @param tipContent
	 * @return
	 */
	private Rrs<Long> createNewTip(TipContent tipContent) {
		Long memberId = shiroSessionUtils.getMemberId();
		tipContent.setId(null);
		tipContent.setBelongMemberId(memberId);
		tipContent.setGmtCreate(new Date());
		tipContent.setGmtUpdate(tipContent.getGmtCreate());
		return new Rrs<>(tipContentDao.insert(tipContent).equals(1), tipContent.getId());
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
	public Rrs<PageInfo<TipVo>> draftList(PaginationDto pagination) {
		Long belongMemberId = shiroSessionUtils.getMemberId();
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setBelongMemberId(belongMemberId);
		selectParam.setStatus((Integer) TipEnum.STATUS_DRAFT.getValue());
		selectParam.setDelF(BaseConstant.UN_DEL);
		List<TipVo> draftVos = tipContentDao.selectVoByParam(selectParam);
		PageInfo<TipVo> pageInfo = new PageInfo<>(draftVos, (Integer) TipEnum.PAG_NAV_PAGES_DRAFT.getValue());
		return new Rrs<>(true, pageInfo);
	}

	@Override
	public Rrs<TipVo> getDraftTip(Long tipId) {
		TipContent param = new TipContent();
		param.setId(tipId);
		param.setStatus(TipEnum.STATUS_DRAFT.getIntegerValue());
		List<TipVo> tipVos = tipContentDao.selectVoByParam(param);
		if (!CollectionUtils.isEmpty(tipVos)) {
			TipVo draftTip = tipVos.get(0);
			draftTip.setPlates(findPalteByTipId(draftTip.getId()));
			return new Rrs<>(true, draftTip);
		}
		return new Rrs<>(false);
	}

	private List<SysTipPlate> findPalteByTipId(Long tipId) {
		TipPlate tipPlate = tipPlateDao.selectByTipId(tipId);
		if (tipPlate != null) {
			List<Long> idList = new ArrayList<>();
			idList.add(tipPlate.getPlateId1());
			idList.add(tipPlate.getPlateId2());
			idList.add(tipPlate.getPlateId3());
			return sysTipPlateDao.selectBatchIds(idList);
		}
		return new ArrayList<>();
	}

	// @Cacheable(value = "index", key = "#pagination.pageSize")
	@Override
	public Rrs<PageInfo<TipVo>> releaseList(PaginationDto pagination) {
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setStatus((Integer) TipEnum.STATUS_RELEASE.getValue());
		List<TipVo> releaseTips = tipContentDao.selectVoByParam(selectParam);
		for (TipVo tv : releaseTips) {
			addBelongMemberBriefVo(tv);
			tv.setCommentCount(tipCommentDao.selectCountByTipId(tv.getId()));
			tv.setContent(RegularUtils.filterHtml(tv.getContent()));
		}
		PageInfo<TipVo> pageInfo = new PageInfo<>(releaseTips);
		return new Rrs<>(true, pageInfo);
	}

	@Override
	public Rrs<TipVo> getDetail(Long tipId) {
		TipVo tv = tipContentDao.selectVoById(tipId);
		addBelongMemberBriefVo(tv);
		tv.setPlates(findPalteByTipId(tipId));
		return new Rrs<>(true, tv);
	}

	private void addBelongMemberBriefVo(TipVo tv) {
		MemberVo memberVo = memberBasicDao.selectVoById(tv.getBelongMemberId());
		memberVo.brief();
		tv.setBelongMember(memberVo);
	}

	@Override
	@Transactional
	public Rrs<Long> releaseDraft(TipContentDto tip) {
		tip.setStatus((Integer) TipEnum.STATUS_RELEASE.getValue());
		return createOrUpdateTipByDto(tip);
	}

	/**
	 * 新增或更新tip
	 * 
	 * @param tip
	 * @return
	 */
	private Rrs<Long> createOrUpdateTipByDto(TipContentDto tip) {
		// 判断type是否合法
		if (!TipEnum.isType(tip.getType())) {
			return new Rrs<>(false);
		}
		// 判断版块数是否合法(1~3)
		Long[] plateIds = tip.getPlateIds();
		if (plateIds == null || plateIds.length == 0 || plateIds.length > 3) {
			return new Rrs<>(false);
		}
		Long tipId = tip.getTipId();
		Rrs<Long> rrs;
		if (tipId != null) {
			// 判断操作用户是否为tip拥有者
			if (!validTipBelongMember(tip.getTipId())) {
				return new Rrs<>(false, ErrorEnum.SYS_EXCEPTION);
			}
			// 更新tip
			rrs = updateTip(tip.convert2TipContent());
			updateTipPlate(tipId, plateIds, false);
		} else {
			// 插入tip
			rrs = createNewTip(tip.convert2TipContent());
			updateTipPlate((Long) rrs.getData(), plateIds, true);
		}

		return rrs;
	}

	/**
	 * 更新(或插入)技巧版块关联记录
	 * 
	 * @param tipId
	 * @param plateIds
	 * @param isFirst
	 */
	private void updateTipPlate(Long tipId, Long[] plateIds, boolean isFirst) {
		Date current = new Date();
		TipPlate entity = new TipPlate();
		entity.setGmtCreate(current);
		entity.setGmtUpdate(current);
		entity.setTipId(tipId);
		parse2PlateId(entity, plateIds);
		if (isFirst) {
			tipPlateDao.insert(entity);
		} else {
			entity.setId(tipPlateDao.selectByTipId(tipId).getId());
			tipPlateDao.updateById(entity);
		}
	}

	/**
	 * 将plate_id数组按顺序解析为plate_id_1,plate_id_2,plate_id_3.
	 * 
	 * @param entity
	 * @param plateIds
	 */
	private void parse2PlateId(TipPlate entity, Long[] plateIds) {
		if (plateIds != null) {
			int length = plateIds.length;
			if (length > 0) {
				entity.setPlateId1(plateIds[0]);
			}
			if (length > 1) {
				entity.setPlateId2(plateIds[1]);
			}
			if (length > 2) {
				entity.setPlateId3(plateIds[2]);
			}
		}
	}

	@Override
	public Rrs<PageInfo<TipVo>> findMemberReleaseTip(PaginationDto pagination) {
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipContent selectParam = new TipContent();
		selectParam.setStatus((Integer) TipEnum.STATUS_RELEASE.getValue());
		selectParam.setBelongMemberId(shiroSessionUtils.getMemberId());
		List<TipVo> releaseTips = tipContentDao.selectVoByParam(selectParam);
		for (TipVo tv : releaseTips) {
			addBelongMemberBriefVo(tv);
		}
		PageInfo<TipVo> pageInfo = new PageInfo<>(releaseTips);
		return new Rrs<>(true, pageInfo);
	}

	@Override
	public Rrs<Object> deleteDraft(Long tipId) {
		if (validTipBelongMember(tipId)) {
			TipContent updateParam = new TipContent();
			updateParam.setId(tipId);
			updateParam.setDelF(BaseConstant.IS_DEL);
			Integer result = tipContentDao.updateById(updateParam);
			return new Rrs<>(result.equals(1));
		}
		return new Rrs<>(false);
	}

}
