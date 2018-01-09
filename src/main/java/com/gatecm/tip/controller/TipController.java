package com.gatecm.tip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月19日 上午10:16:39
 *
 */
@Controller
@RequestMapping(value = "/tip", method = RequestMethod.GET)
public class TipController {

	@Autowired
	private TipContentService tipContentService;

	@RequestMapping(value = "/a/write")
	public String write() {
		return "tip/write";
	}

	@RequestMapping(value = "/a/{tipId}/edit")
	public ModelAndView write(@PathVariable Long tipId) {
		ModelAndView modelAndView = new ModelAndView();
		Rrs rrs = tipContentService.getDraftTip(tipId);
		modelAndView.addObject(BaseConstant.RESPONSE_DATA, rrs);
		modelAndView.setViewName("tip/write");
		return modelAndView;
	}

	@RequestMapping(value = "/{tipId}/detail")
	public ModelAndView detail(@PathVariable Long tipId) {
		ModelAndView modelAndView = new ModelAndView();
		Rrs rrs = tipContentService.getDetail(tipId);
		modelAndView.addObject(BaseConstant.RESPONSE_DATA, rrs);
		modelAndView.setViewName("tip/detail");
		return modelAndView;
	}
}
