package com.gatecm.tip.plugin.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.exception.ImgException;
import com.taobao.api.internal.toplink.embedded.websocket.util.StringUtil;

/**
 * @Description: TODO(OSS图片处理管理类)
 * @author chenxiaohui
 * @date 2017年5月25日 下午2:58:53
 *
 */
@Component
public class OSSImgManager {

	@Autowired
	private OSSConfig config;

	private final Log log = LogFactory.getLog(OSSImgManager.class);

	/**
	 * 上传并返回图片访问路径
	 * 
	 * @param file
	 * @param filedir
	 * @param imgMSize
	 * @return
	 * @throws ImgException
	 */
	public String uploadImg2OSSWithUrl(MultipartFile file, String filedir, int imgMSize) throws ImgException {
		String key = uploadImg2OSS(file, filedir, imgMSize);
		return splitJointUrl(key, filedir);
	}

	/**
	 * 上传到OSS服务器 如果同名文件会覆盖服务器上的
	 * 
	 * @param file
	 * @param filedir
	 * @return key
	 * @throws ImgException
	 */
	public String uploadImg2OSS(MultipartFile file, String filedir, int imgMSize) throws ImgException {
		if (file == null) {
			throw new ImgException("上传图片不能为NULL");
		}
		Float fileSizef = Float.valueOf(file.getSize());
		if (fileSizef / 1024 / 1024 > imgMSize) {
			throw new ImgException("图片大小不能超过" + imgMSize + "M");
		}
		String originalFilename = file.getOriginalFilename();
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = BaseConstant.BLANK_STRING + random.nextInt(10000) + System.currentTimeMillis() + substring;
		try {
			InputStream inputStream = file.getInputStream();
			this.uploadFile2OSS(inputStream, name, filedir);
		} catch (Exception e) {
			throw new ImgException("图片上传失败");
		}
		return name;
	}

	/**
	 * 上传到OSS服务器 如果同名文件会覆盖服务器上的
	 *
	 * @param instream
	 *            文件流
	 * @param fileName
	 *            文件名称 包括后缀名
	 * @return 出错返回"" ,唯一MD5数字签名
	 */
	public String uploadFile2OSS(InputStream instream, String fileName, String filedir) {
		String ret = "";
		try {
			// 创建上传Object的Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
			objectMetadata.setContentDisposition("inline;filename=" + fileName);
			// 上传文件
			PutObjectResult putResult = config.getOssClient().putObject(config.getBucketName(), filedir + fileName,
					instream, objectMetadata);
			ret = putResult.getETag();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Description: 判断OSS服务文件上传时文件的contentType
	 *
	 * @param filenameExtension
	 *            文件后缀
	 * @return String
	 */
	private String getcontentType(String filenameExtension) {
		if (filenameExtension.equalsIgnoreCase("bmp")) {
			return "image/bmp";
		}
		if (filenameExtension.equalsIgnoreCase("gif")) {
			return "image/gif";
		}
		if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
				|| filenameExtension.equalsIgnoreCase("png")) {
			return "image/jpeg";
		}
		if (filenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		}
		if (filenameExtension.equalsIgnoreCase("txt")) {
			return "text/plain";
		}
		if (filenameExtension.equalsIgnoreCase("vsd")) {
			return "application/vnd.visio";
		}
		if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
			return "application/msword";
		}
		if (filenameExtension.equalsIgnoreCase("xml")) {
			return "text/xml";
		}
		return "image/jpeg";
	}

	/**
	 * 获得url链接
	 *
	 * @param key
	 * @return
	 */
	public String getUrl(String key) {
		// 设置URL过期时间为10年 3600l* 1000*24*365*10
		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
		// 生成URL
		URL url = config.getOssClient().generatePresignedUrl(config.getBucketName(), key, expiration);
		if (url != null) {
			return url.toString();
		}
		return null;
	}

	/**
	 * 拼接url链接
	 * 
	 * @param name
	 * @param fileDir
	 * @return
	 */
	public String splitJointUrl(String key, String fileDir) {
		String url = null;
		if (!StringUtils.isEmpty(key)) {
			url = "http://" + config.getBucketName() + "." + config.getEndpoint() + "/" + fileDir + key;
		}
		return url;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String flilePathName = "C:/Users/xr/Desktop/IMG_8330.JPG";
		File file = new File(flilePathName);
		InputStream is = new FileInputStream(file);
		String diskName = "work/ylyg/app/test/";
		// String md5key = OSSUnit.uploadObject2OSS(ossUnitTest.getClient(),
		// file, ossUnitTest.getBucketName(), diskName);
		// String name = OSSImgManager.getInstance().uploadFile2OSS(is,
		// "IMG_8330.JPG", diskName);
		//
		// System.err.println(OSSImgManager.getInstance().getUrl(name));
		// System.err.println(name);

	}
}