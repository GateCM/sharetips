/**
 * 
 */
package com.gatecm.tip.dto.vo;

import java.util.Date;

/**
 * @Description: TODO(技巧视图)
 * @author chenxiaohui
 * @date 2017年12月19日 下午1:08:19
 *
 */
public class TipVo {

	private Long id;

	/**
	 * 记录创建时间
	 */
	private Date gmtCreate;
	/**
	 * 记录最近更新时间
	 */
	private Date gmtUpdate;

	/**
	 * 技巧标题
	 */
	private String title;

	/**
	 * 题图路径
	 */
	private String headImg;

	/**
	 * 所属用户ID
	 */
	private Long belongMemberId;

	private MemberVo belongMember;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtUpdate() {
		return gmtUpdate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Long getBelongMemberId() {
		return belongMemberId;
	}

	public void setBelongMemberId(Long belongMemberId) {
		this.belongMemberId = belongMemberId;
	}

	public MemberVo getBelongMember() {
		return belongMember;
	}

	public void setBelongMember(MemberVo belongMember) {
		this.belongMember = belongMember;
	}
}
