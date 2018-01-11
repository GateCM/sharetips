/**
 * 
 */
package com.gatecm.tip.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.SysTipPlateService;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2018年1月11日 上午11:28:03
 *
 */
@RestController
@RequestMapping(value = "/api/base", method = RequestMethod.GET)
public class BaseAPI {

	@Autowired
	private SysTipPlateService sysTipPlateService;

	@Cacheable(value="base")
	@RequestMapping("/plate")
	public Rrs plate() {
		return sysTipPlateService.loadAllPlates();
	}

}
