/**
 * 
 */
package com.gatecm.tip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月25日 下午3:16:10
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/{pageUrl}")
	public String test(@PathVariable String pageUrl) {
		return pageUrl;
	}
	
	@RequestMapping("/test")
	public String test2(@PathVariable String pageUrl) {
		return pageUrl;
	}

}
