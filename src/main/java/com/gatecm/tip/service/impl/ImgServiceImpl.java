/**
 * 
 */
package com.gatecm.tip.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gatecm.tip.plugin.oss.OSSImgManager;
import com.gatecm.tip.service.ImgService;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.util.TimeUtils;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年5月29日 上午10:41:38
 *
 */
@Service("imgService")
public class ImgServiceImpl implements ImgService {

	@Autowired
	private OSSImgManager ossImgManager;

	private static final Logger log = LoggerFactory.getLogger(ImgServiceImpl.class);

	private static final int IMG_BANNER_MAX_SIZE = 15;// 15兆
	private static final int IMG_ENTERPRISE_MAX_SIZE = 10;// 10兆
	private static final int IMG_HEADER_MAX_SIZE = 2;// 2兆

	private static final String SUFFIX = "/";
	private static final String FILE_DIR_ENTERPRISE = "enterprise";
	private static final String FILE_DIR_HEADER = "head";
	private static final String FILE_DIR_BANNER = "banner";
	private static final String FILE_DIR_ARTICLE = "chain-article";

	@Override
	public Rrs upload(MultipartFile file, String fileDir, Long userId) {
		Rrs resultEntity = new Rrs(false);
		String dir;
		int imgMSize;
		String suffix = SUFFIX + userId + SUFFIX + TimeUtils.dateToShortStr(new Date()) + SUFFIX;
		switch (fileDir) {
		case FILE_DIR_ENTERPRISE:
			imgMSize = IMG_ENTERPRISE_MAX_SIZE;
			break;
		case FILE_DIR_HEADER:
			imgMSize = IMG_HEADER_MAX_SIZE;
			break;
		case FILE_DIR_BANNER:
			imgMSize = IMG_BANNER_MAX_SIZE;
			break;
		case FILE_DIR_ARTICLE:
			imgMSize = IMG_BANNER_MAX_SIZE;
			break;
		default:
			return resultEntity;
		}
		dir = fileDir + suffix;
		String imgUrl = ossImgManager.uploadImg2OSSWithUrl(file, dir, imgMSize);
		log.info(imgUrl);
		resultEntity.setData(imgUrl);
		resultEntity.setResult(true);
		return resultEntity;
	}

	@Override
	public Rrs upload(MultipartFile file, String fileDir) {
		Rrs resultEntity = new Rrs(false);
		String dir;
		int imgMSize;
		String suffix = SUFFIX + TimeUtils.dateToShortStr(new Date()) + SUFFIX;
		switch (fileDir) {
		case FILE_DIR_ENTERPRISE:
			imgMSize = IMG_ENTERPRISE_MAX_SIZE;
			break;
		case FILE_DIR_HEADER:
			imgMSize = IMG_HEADER_MAX_SIZE;
			break;
		case FILE_DIR_BANNER:
			imgMSize = IMG_BANNER_MAX_SIZE;
			break;
		case FILE_DIR_ARTICLE:
			imgMSize = IMG_BANNER_MAX_SIZE;
			break;
		default:
			return resultEntity;
		}
		dir = fileDir + suffix;
		String imgUrl = ossImgManager.uploadImg2OSSWithUrl(file, dir, imgMSize);
		log.info(imgUrl);
		return resultEntity;
	}
}
