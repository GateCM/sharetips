package com.gatecm.tip.mapper;

import com.gatecm.tip.entity.TipPlate;

import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 技巧与板块映射表 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-12
 */
public interface TipPlateDao extends BaseMapper<TipPlate> {

	/**
	 * @param selectParam
	 * @return
	 */
	TipPlate selectByTipId(@Param("tipId") Long tipId);

}