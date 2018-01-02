/**
 * 
 */
package com.gatecm.tip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gatecm.tip.constant.BaseConstant;

/**
 * @ClassName: IndexController
 * @Description: TODO(首页控制器)
 * @author chenxiaohui
 * @date 2017年12月10日 下午2:42:42
 *
 */
@Controller
@RequestMapping(value = "/index", method = RequestMethod.GET)
public class IndexController {

	@RequestMapping("")
	public String index() {
		return "index";
	}

}
