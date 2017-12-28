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
import com.gatecm.tip.service.CommentService;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.TipContentService;

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

	@RequestMapping(value = "/draft", method = RequestMethod.POST)
	public Rrs draft(@RequestBody @Valid TipContentDto tip) {
		return tipContentService.saveDraft(tip);
	}

	@RequestMapping(value = "/{tipId}/comment", method = RequestMethod.POST)
	public Rrs comment(@PathVariable Long tipId, @RequestBody @Valid CommentDto comment) {
		comment.setTipId(tipId);
		return commentService.addComment2Tip(comment);
	}

	@RequestMapping(value = "/{tipId}/comment", method = RequestMethod.GET)
	public Rrs comment(@PathVariable Long tipId, PaginationDto pagination) {
		return commentService.tipCommentList(pagination, tipId);
	}

	@RequestMapping(value = "/draft/list", method = RequestMethod.GET)
	public Rrs draftList(PaginationDto pagination) {
		return tipContentService.draftList(pagination);
	}

	@RequestMapping(value = "/release/list", method = RequestMethod.GET)
	public Rrs releaseList(PaginationDto pagination) {
		return tipContentService.releaseList(pagination);
	}
}
