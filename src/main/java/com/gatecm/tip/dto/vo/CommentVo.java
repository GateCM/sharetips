package com.gatecm.tip.dto.vo;

import java.util.Date;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月28日 下午2:52:55
 *
 */
public class CommentVo {

	/**
	 * 统一主键
	 */
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
	 * 发起用户ID
	 */
	private Long memberId;

	private MemberVo belongUser;
	/**
	 * 技巧ID
	 */
	private Long tipId;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 0:不是回复；1：是回复
	 */
	private Boolean tfReply;
	/**
	 * 被回复评论ID
	 */
	private Long replyCommentId;
	/**
	 * 被回复用户ID
	 */
	private Long replyMemberId;

	/**
	 * 被回复用户
	 */
	private MemberVo replyMember;

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

	public MemberVo getBelongUser() {
		return belongUser;
	}

	public void setBelongUser(MemberVo belongUser) {
		this.belongUser = belongUser;
	}

	public Long getReplyMemberId() {
		return replyMemberId;
	}

	public void setReplyMemberId(Long replyMemberId) {
		this.replyMemberId = replyMemberId;
	}

	public MemberVo getReplyMember() {
		return replyMember;
	}

	public void setReplyMember(MemberVo replyMember) {
		this.replyMember = replyMember;
	}
}
