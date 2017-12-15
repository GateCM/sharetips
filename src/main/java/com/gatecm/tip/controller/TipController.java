/**  
* @Title: TipController.java
* @Package com.gatecm.tip.controller
* @Description: TODO()
* @author chenxiaohui
* @date 2017年12月2日 下午7:11:34
* @version V1.0  
*/
package com.gatecm.tip.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aliyun.oss.OSS;
import com.gatecm.tip.plugin.oss.OSSConfig;
import com.gatecm.tip.plugin.oss.OSSImgManager;

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
	
	@Autowired
	private OSSConfig config;

	@Autowired
	private OSSImgManager imgManager;

	@RequestMapping(value = "/write")
	public String write() throws FileNotFoundException {
		
		String flilePathName = "E:/flag.gif";
		File file = new File(flilePathName);
		InputStream is = new FileInputStream(file);
		String diskName = "work/ylyg/app/test/";
		imgManager.uploadFile2OSS(is, "sdfsf.gif", diskName);
		
		System.err.println(imgManager);
		return "tip/write";
	}
}
