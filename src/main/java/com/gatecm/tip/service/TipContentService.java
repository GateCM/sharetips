package com.gatecm.tip.service;

import com.gatecm.tip.dto.TipContentDTO;
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
	 * 保存技巧草稿
	 * 
	 * @param tip
	 * @return
	 */
	Rrs saveDraft(TipContentDTO tip);

}
