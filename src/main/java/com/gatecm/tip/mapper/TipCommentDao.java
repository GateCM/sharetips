package com.gatecm.tip.mapper;

import com.gatecm.tip.dto.vo.CommentVo;
import com.gatecm.tip.entity.TipComment;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

	/**
	 * 获取技巧评论总数
	 * 
	 * @param id
	 */
	@Select("SELECT COUNT(*) AS commentCount FROM tip_comment WHERE del_f = 0 AND tip_id = #{tipId}")
	Integer selectCountByTipId(@Param("tipId") Long tipId);

}