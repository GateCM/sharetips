package com.gatecm.tip.mapper;

import com.gatecm.tip.dto.vo.TipVo;
import com.gatecm.tip.entity.TipContent;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 技巧内容表 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-16
 */
public interface TipContentDao extends BaseMapper<TipContent> {

	/**
	 * @param selectParam
	 * @return
	 */
	List<TipVo> selectVoByParam(TipContent selectParam);

}