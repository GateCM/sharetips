/**
 * 
 */
package com.gatecm.tip.dto;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: TipContentDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2017年12月16日 下午10:01:08
 *
 */
public class TipContentDto {

	/**
	 * 技巧ID
	 */
	private Long tipId;

	/**
	 * 题目
	 */
	@NotBlank
	private String title;

	/**
	 * 题图
	 */
	private String headImg;

	/**
	 * 技巧内容
	 */
	@NotBlank
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTipId() {
		return tipId;
	}

	public void setTipId(Long tipId) {
		this.tipId = tipId;
	}

}
