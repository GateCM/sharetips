/**
 * 
 */
package com.gatecm.tip.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.dto.vo.WebStatusVo;
import com.gatecm.tip.service.MonitorService;
import com.gatecm.tip.service.Rrs;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2018年1月9日 下午3:13:44
 *
 */
@RestController
@RequestMapping("/api/m")
public class MonitorAPI {

	@Autowired
	private MonitorService monitorService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public Rrs<WebStatusVo> index() {
		return monitorService.indexStatus();
	}

}
