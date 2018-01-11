package com.gatecm.tip.service;

import com.gatecm.tip.entity.SysTipPlate;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 系统技巧板块 服务类
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-11
 */
public interface SysTipPlateService extends IService<SysTipPlate> {

	/**
	 * 加载所有版块信息
	 * 
	 * @return
	 */
	Rrs loadAllPlates();

}
