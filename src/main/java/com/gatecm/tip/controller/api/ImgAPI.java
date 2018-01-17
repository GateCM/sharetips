/**
 * 
 */
package com.gatecm.tip.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.BaseConstant;
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
	private ShiroSessionUtils shiroSessionUtils;

	@Autowired
	private ImgService imgService;

	@RequestMapping(value = "/wang/upload/{fileDir}", method = RequestMethod.POST)
	public Map<String, Object> pluginUploadWithFileDir(@PathVariable String fileDir, MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		Long memberId = shiroSessionUtils.getMemberId();
		Rrs<String> rrs = imgService.upload(file, fileDir, memberId);
		if (rrs.getResult()) {
			map.put(BaseConstant.WANG_EDITER_UPLOAD_ERRNO, BaseConstant.WANG_EDITER_UPLOAD_SUCCESS);
			map.put(BaseConstant.WANG_EDITER_UPLOAD_RETURN_URL_ARRAY, rrs.getData());
		}
		return map;
	}

	@RequestMapping(value = "/upload/{fileDir}", method = RequestMethod.POST)
	public Rrs<String> uploadWithFileDir(@PathVariable String fileDir, MultipartFile file) {
		return imgService.upload(file, fileDir, 23L);
	}
}