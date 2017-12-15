/**
 * 
 */
package com.gatecm.tip.plugin.oss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月15日 下午1:23:36
 *
 */
@Component
@ConfigurationProperties(prefix = "ali.oss")
public class OSSConfig implements CommandLineRunner {

	/**
	 * 阿里云API的内或外网域名
	 */
	private String endpoint;

	/**
	 * 阿里云API的密钥Access Key ID
	 */
	private String accessKeyId;

	/**
	 * 阿里云API的密钥Access Key Secret
	 */
	private String accessKeySecret;

	/**
	 * 
	 */
	private String bucketName;

	private OSSClient ossClient;

	public OSSClient getOssClient() {
		return ossClient;
	}

	public void setOssClient(OSSClient ossClient) {
		this.ossClient = ossClient;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	@Override
	public void run(String... args) throws Exception {
		this.ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
}
