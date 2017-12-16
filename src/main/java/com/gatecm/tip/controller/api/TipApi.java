/**
 * 
 */
package com.gatecm.tip.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.dto.TipContentDTO;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月15日 下午2:56:43
 *
 */
@RestController
@RequestMapping("/api/tip")
public class TipApi {

	@Autowired
	private TipContentService tipContentService;

	@RequestMapping(value = "/draft", method = RequestMethod.POST)
	public Rrs draft(@RequestBody @Valid TipContentDTO tip) {
		return tipContentService.saveDraft(tip);
	}
}
