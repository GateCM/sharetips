/**  
* @Title: TipController.java
* @Package com.gatecm.tip.controller
* @Description: TODO()
* @author chenxiaohui
* @date 2017年12月2日 下午7:11:34
* @version V1.0  
*/
package com.gatecm.tip.controller;

import java.io.FileNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: TipController
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月2日 下午7:11:34
 *
 */
@Controller
@RequestMapping(value = "/tip", method = RequestMethod.GET)
public class TipController {

	@RequestMapping(value = "/write")
	public String write() throws FileNotFoundException {
		return "tip/write";
	}
}
