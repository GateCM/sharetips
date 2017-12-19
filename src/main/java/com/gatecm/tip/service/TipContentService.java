package com.gatecm.tip.service;

import com.gatecm.tip.dto.PaginationDto;
import com.gatecm.tip.dto.TipContentDto;
import com.gatecm.tip.entity.TipContent;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 技巧内容表 服务类
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-16
 */
public interface TipContentService extends IService<TipContent> {

	/**
	 * 保存技巧草稿（插入或更新）
	 * 
	 * @param tip
	 * @return
	 */
	Rrs saveDraft(TipContentDto tip);

	/**
	 * 获取技巧草稿列表
	 * 
	 * @param pagination
	 * @return
	 */
	Rrs draftList(PaginationDto pagination);

	/**
	 * 获取技巧草稿数据
	 * 
	 * @param tipId
	 * @return
	 */
	Rrs getDraftTip(Long tipId);

}
