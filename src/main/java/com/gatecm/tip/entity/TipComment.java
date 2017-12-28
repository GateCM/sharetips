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
 * 技巧评论表，记录用户对技巧的评论
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-28
 */
@TableName("tip_comment")
public class TipComment extends Model<TipComment> {

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
	 * 发起用户ID
	 */
	@TableField("member_id")
	private Long memberId;
	/**
	 * 技巧ID
	 */
	@TableField("tip_id")
	private Long tipId;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 0:不是回复；1：是回复
	 */
	@TableField("tf_reply")
	private Boolean tfReply;
	/**
	 * 被回复评论ID
	 */
	@TableField("reply_comment_id")
	private Long replyCommentId;
	/**
	 * 被回复用户ID
	 */
	@TableField("reply_member_id")
	private Long replyMemberId;
	/**
	 * 0:未删除；1：删除
	 */
	@TableField("is_del")
	private Integer isDel;

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

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getTipId() {
		return tipId;
	}

	public void setTipId(Long tipId) {
		this.tipId = tipId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getTfReply() {
		return tfReply;
	}

	public void setTfReply(Boolean tfReply) {
		this.tfReply = tfReply;
	}

	public Long getReplyCommentId() {
		return replyCommentId;
	}

	public void setReplyCommentId(Long replyCommentId) {
		this.replyCommentId = replyCommentId;
	}

	public Long getReplyMemberId() {
		return replyMemberId;
	}

	public void setReplyMemberId(Long replyMemberId) {
		this.replyMemberId = replyMemberId;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TipComment{" + ", id=" + id + ", gmtCreate=" + gmtCreate + ", gmtUpdate=" + gmtUpdate + ", memberId="
				+ memberId + ", tipId=" + tipId + ", content=" + content + ", tfReply=" + tfReply + ", replyCommentId="
				+ replyCommentId + ", replyMemberId=" + replyMemberId + ", isDel=" + isDel + "}";
	}
}
