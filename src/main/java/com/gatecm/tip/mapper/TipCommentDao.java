package com.gatecm.tip.mapper;

import com.gatecm.tip.dto.vo.CommentVo;
import com.gatecm.tip.entity.TipComment;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 技巧评论表，记录用户对技巧的评论 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-28
 */
public interface TipCommentDao extends BaseMapper<TipComment> {

	/**
	 * @param selectParam
	 * @return
	 */
	List<CommentVo> selectVoByParam(TipComment selectParam);

}