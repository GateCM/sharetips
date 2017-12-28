/**
 * 
 */
package com.gatecm.tip.dto;

import javax.validation.constraints.NotBlank;

/**
 * @Description: TODO(评论DTO)
 * @author chenxiaohui
 * @date 2017年12月28日 下午1:58:39
 *
 */
public class CommentDto {

	/**
	 * 技巧ID
	 */
	private Long tipId;

	/**
	 * 评论内容
	 */
	@NotBlank
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

	public Boolean getTfReply() {
		return tfReply;
	}

	public void setTfReply(Boolean tfReply) {
		this.tfReply = tfReply;
	}

}
