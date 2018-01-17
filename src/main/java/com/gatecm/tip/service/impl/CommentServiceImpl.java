/**
 * 
 */
package com.gatecm.tip.service.impl;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gatecm.tip.config.shiro.ShiroSessionUtils;
import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.dto.CommentDto;
import com.gatecm.tip.dto.PaginationDto;
import com.gatecm.tip.dto.vo.CommentVo;
import com.gatecm.tip.dto.vo.MemberVo;
import com.gatecm.tip.entity.TipComment;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.mapper.TipCommentDao;
import com.gatecm.tip.service.CommentService;
import com.gatecm.tip.service.Rrs;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月28日 下午1:56:54
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ShiroSessionUtils shiroSessionUtils;

	@Autowired
	private TipCommentDao tipCommentDao;

	@Autowired
	private MemberBasicDao memberBasicDao;

	@Override
	public Rrs<Object> addComment2Tip(@Valid CommentDto comment) {
		Long memberId = shiroSessionUtils.getMemberId();
		TipComment insertParam = new TipComment();
		insertParam.setGmtCreate(new Date());
		insertParam.setGmtUpdate(insertParam.getGmtCreate());
		insertParam.setTipId(comment.getTipId());
		insertParam.setContent(comment.getContent());
		insertParam.setMemberId(memberId);
		insertParam.setTfReply(comment.getTfReply());
		if (insertParam.getTfReply()) {
			insertParam.setReplyCommentId(comment.getReplyCommentId());
			insertParam.setReplyMemberId(comment.getReplyMemberId());
		}
		return new Rrs<>(tipCommentDao.insert(insertParam).equals(1));
	}

	@Override
	public Rrs<PageInfo<CommentVo>> tipCommentList(PaginationDto pagination, Long tipId) {
		PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize());
		TipComment selectParam = new TipComment();
		selectParam.setTipId(tipId);
		selectParam.setDelF(BaseConstant.UN_DEL);
		List<CommentVo> commentVos = tipCommentDao.selectVoByParam(selectParam);
		for (CommentVo commentVo : commentVos) {
			bindMemberVo(commentVo);
		}
		PageInfo<CommentVo> pageInfo = new PageInfo<>(commentVos, 5);
		return new Rrs<>(true, pageInfo);
	}

	/**
	 * 绑定用户信息
	 * 
	 * @param commentVo
	 */
	private void bindMemberVo(CommentVo commentVo) {
		MemberVo belongMember = memberBasicDao.selectVoById(commentVo.getMemberId());
		if (belongMember == null) {
			belongMember = new MemberVo();
		}
		commentVo.setBelongUser(belongMember);
		if (commentVo.getTfReply()) {
			MemberVo replyMember = memberBasicDao.selectVoById(commentVo.getReplyMemberId());
			if (replyMember == null) {
				replyMember = new MemberVo();
			}
			commentVo.setReplyMember(replyMember);
		}
	}

}
