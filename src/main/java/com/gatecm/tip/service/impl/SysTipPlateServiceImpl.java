package com.gatecm.tip.service.impl;

import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.dto.vo.PlateVo;
import com.gatecm.tip.entity.SysTipPlate;
import com.gatecm.tip.mapper.SysTipPlateDao;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.SysTipPlateService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统技巧板块 服务实现类
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-11
 */
@Service("sysTipPlateService")
public class SysTipPlateServiceImpl extends ServiceImpl<SysTipPlateDao, SysTipPlate> implements SysTipPlateService {

	@Autowired
	private SysTipPlateDao sysTipPlateDao;

	@Override
	public Rrs<List<PlateVo>> loadAllPlates() {
		SysTipPlate param = new SysTipPlate();
		param.setDelF(BaseConstant.UN_DEL);
		List<PlateVo> plates = sysTipPlateDao.selectVoByParam(param);
		return new Rrs<>(true, plates);
	}

}
