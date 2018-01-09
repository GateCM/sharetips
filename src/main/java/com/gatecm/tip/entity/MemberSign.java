package com.gatecm.tip.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户签到表，记录用户签到
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-09
 */
@TableName("member_sign")
public class MemberSign extends Model<MemberSign> {

    private static final long serialVersionUID = 1L;

    /**
     * 统一主键
     */
	@TableId(value="id", type= IdType.AUTO)
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
     * 用户ID
     */
	@TableField("member_id")
	private Long memberId;
    /**
     * 签到日期
     */
	@TableField("sign_date")
	private Date signDate;
    /**
     * 签到获得积分
     */
	@TableField("gain_point")
	private Integer gainPoint;
    /**
     * 0:不是补签；1：是补签
     */
	@TableField("is_repaired")
	private Integer isRepaired;
    /**
     * 0:未删除；1：删除
     */
	@TableField("del_f")
	private Integer delF;


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

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public Integer getGainPoint() {
		return gainPoint;
	}

	public void setGainPoint(Integer gainPoint) {
		this.gainPoint = gainPoint;
	}

	public Integer getIsRepaired() {
		return isRepaired;
	}

	public void setIsRepaired(Integer isRepaired) {
		this.isRepaired = isRepaired;
	}

	public Integer getDelF() {
		return delF;
	}

	public void setDelF(Integer delF) {
		this.delF = delF;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MemberSign{" +
			", id=" + id +
			", gmtCreate=" + gmtCreate +
			", gmtUpdate=" + gmtUpdate +
			", memberId=" + memberId +
			", signDate=" + signDate +
			", gainPoint=" + gainPoint +
			", isRepaired=" + isRepaired +
			", delF=" + delF +
			"}";
	}
}
