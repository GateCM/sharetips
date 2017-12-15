/**
 * 
 */
package com.gatecm.tip.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gatecm.tip.service.ImgService;
import com.gatecm.tip.service.Rrs;

/**
 * @Description: TODO(图片上传接口)
 * @author chenxiaohui
 * @date 2017年10月24日 下午7:47:26
 *
 */
@RestController
@RequestMapping("/api/img")
public class ImgAPI {

	@Autowired
	private ImgService imgService;

	@RequestMapping(value = "/upload/{fileDir}", method = RequestMethod.POST)
	public Map<String, Object> uploadWithFileDir(@PathVariable String fileDir, MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		
		 Rrs rrs = imgService.upload(file, fileDir, 23L);
		map.put("errno", 0);
		map.put("data", new Object[]{rrs.getData()});
		return map;
	}
}