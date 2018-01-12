package com.gatecm.tip.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 技巧内容表
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-16
 */
@TableName("tip_content")
public class TipContent extends Model<TipContent> {

	private static final long serialVersionUID = 1L;

	/**
	 * 统一主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 记录创建时间
	 */
	@TableField("gmt_create")
	private Date gmtCreate;
	/**
	 * 记录最近更新时间
	 */
	@TableField("gmt_update")
	private Date gmtUpdate;
	/**
	 * 技巧标题
	 */
	private String title;
	/**
	 * 题图路径
	 */
	@TableField("head_img")
	private String headImg;
	/**
	 * 内容（html格式）
	 */
	private String content;

	/**
	 * 类型(1 原创；2：转载)
	 */
	private Integer type;

	/**
	 * 状态(0：草稿；1 :已发布)
	 */
	private Integer status;
	/**
	 * 所属用户ID
	 */
	@TableField("belong_member_id")
	private Long belongMemberId;
	/**
	 * 0:未删除；1：删除
	 */
	@TableField("del_f")
	private Integer delF;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getBelongMemberId() {
		return belongMemberId;
	}

	public void setBelongMemberId(Long belongMemberId) {
		this.belongMemberId = belongMemberId;
	}

	public Integer getDelF() {
		return delF;
	}

	public void setDelF(Integer delF) {
		this.delF = delF;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TipContent{" + ", id=" + id + ", gmtCreate=" + gmtCreate + ", gmtUpdate=" + gmtUpdate + ", title="
				+ title + ", headImg=" + headImg + ", content=" + content + ", status=" + status + ", belongMemberId="
				+ belongMemberId + ", delF=" + delF + "}";
	}
}
