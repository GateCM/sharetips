/**
 * 
 */
package com.gatecm.tip.service;

import javax.validation.Valid;

import com.gatecm.tip.dto.CommentDto;
import com.gatecm.tip.dto.PaginationDto;

/**
 * @Description: TODO(评论接口)
 * @author chenxiaohui
 * @date 2017年12月28日 下午1:56:21
 *
 */
public interface CommentService {

	/**
	 * 添加技巧评论
	 * 
	 * @param comment
	 * @return
	 */
	Rrs addComment2Tip(@Valid CommentDto comment);

	/**
	 * 获取指定技巧评论列表
	 * 
	 * @param pagination
	 * @param tipId
	 * @return
	 */
	Rrs tipCommentList(PaginationDto pagination, Long tipId);

}
