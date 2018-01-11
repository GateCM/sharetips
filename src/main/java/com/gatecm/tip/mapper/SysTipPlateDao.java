package com.gatecm.tip.mapper;

import com.gatecm.tip.dto.vo.PlateVo;
import com.gatecm.tip.entity.SysTipPlate;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 系统技巧板块 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-11
 */
public interface SysTipPlateDao extends BaseMapper<SysTipPlate> {

	/**
	 * @param sysTipPlate
	 * @return
	 */
	List<PlateVo> selectVoByParam(SysTipPlate sysTipPlate);

}