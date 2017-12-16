/**
 * 
 */
package com.gatecm.tip.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: TODO(图片上传接口)
 * @author chenxiaohui
 * @date 2017年12月15日 下午2:51:29
 */
public interface ImgService {

	/**
	 * 上传图片
	 * 
	 * @param file
	 * @param fileDir
	 * @return
	 */
	Rrs upload(MultipartFile file, String fileDir, Long userId);
}
