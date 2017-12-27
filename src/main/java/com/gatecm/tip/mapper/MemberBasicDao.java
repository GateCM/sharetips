package com.gatecm.tip.mapper;

import com.gatecm.tip.dto.vo.MemberVo;
import com.gatecm.tip.entity.MemberBasic;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户基本信息表，用来存储用户最基本的信息。 Mapper 接口
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-02
 */
public interface MemberBasicDao extends BaseMapper<MemberBasic> {

	/**
	 * @param selectParam
	 * @return
	 */
	List<MemberVo> selectVoByParam(MemberBasic selectParam);

	/**
	 * @param id
	 * @return
	 */
	MemberVo selectVoById(@Param("id") Long id);

}