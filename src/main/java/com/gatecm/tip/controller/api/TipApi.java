/**
 * 
 */
package com.gatecm.tip.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gatecm.tip.dto.CommentDto;
import com.gatecm.tip.dto.PaginationDto;
import com.gatecm.tip.dto.TipContentDto;
import com.gatecm.tip.dto.vo.CommentVo;
import com.gatecm.tip.dto.vo.TipVo;
import com.gatecm.tip.service.CommentService;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;
import com.github.pagehelper.PageInfo;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月15日 下午2:56:43
 *
 */
@RestController
@RequestMapping("/api/tip")
public class TipApi {

	@Autowired
	private TipContentService tipContentService;

	@Autowired
	private CommentService commentService;

	/**
	 * 保存技巧为草稿
	 * 
	 * @param tip
	 * @return
	 */
	@RequestMapping(value = "/a/draft", method = RequestMethod.POST)
	public Rrs<Long> draft(@RequestBody @Valid TipContentDto tip) {
		return tipContentService.saveDraft(tip);
	}

	/**
	 * 保存技巧为草稿
	 * 
	 * @param tip
	 * @return
	 */
	@RequestMapping(value = "/a/draft/{tipId}", method = RequestMethod.DELETE)
	public Rrs<Object> draft(@PathVariable Long tipId) {
		return tipContentService.deleteDraft(tipId);
	}

	/**
	 * 发布技巧
	 * 
	 * @param tip
	 * @return
	 */
	@RequestMapping(value = "/a/release", method = RequestMethod.POST)
	public Rrs<Long> release(@RequestBody @Valid TipContentDto tip) {
		return tipContentService.releaseDraft(tip);
	}

	/**
	 * 添加新评论
	 * 
	 * @param tipId
	 * @param comment
	 * @return
	 */
	@RequestMapping(value = "/a/{tipId}/comment", method = RequestMethod.POST)
	public Rrs<Object> comment(@PathVariable Long tipId, @RequestBody @Valid CommentDto comment) {
		comment.setTipId(tipId);
		return commentService.addComment2Tip(comment);
	}

	/**
	 * 获取技巧评论列表
	 * 
	 * @param tipId
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/{tipId}/comment", method = RequestMethod.GET)
	public Rrs<PageInfo<CommentVo>> comment(@PathVariable Long tipId, PaginationDto pagination) {
		return commentService.tipCommentList(pagination, tipId);
	}

	/**
	 * 获取技巧详情
	 * 
	 * @param tipId
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/{tipId}/detail", method = RequestMethod.GET)
	public Rrs<TipVo> comment(@PathVariable Long tipId) {
		return tipContentService.getDetail(tipId);
	}

	/**
	 * 获取技巧草稿列表
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/a/draft/list", method = RequestMethod.GET)
	public Rrs<PageInfo<TipVo>> draftList(PaginationDto pagination) {
		return tipContentService.draftList(pagination);
	}

	/**
	 * 获取已发布技巧列表（临时）
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/release/list", method = RequestMethod.GET)
	public Rrs<PageInfo<TipVo>> releaseList(PaginationDto pagination) {
		return tipContentService.releaseList(pagination);
	}

	/**
	 * 获取指定用户已发布技巧列表
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value = "/a/member/release/list", method = RequestMethod.GET)
	public Rrs<PageInfo<TipVo>> memberReleaseList(PaginationDto pagination) {
		return tipContentService.findMemberReleaseTip(pagination);
	}
}
