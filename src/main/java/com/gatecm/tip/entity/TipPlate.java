package com.gatecm.tip.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 技巧与板块映射表
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-12
 */
@TableName("tip_plate")
public class TipPlate extends Model<TipPlate> {

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
     * 技巧ID
     */
	@TableField("tip_id")
	private Long tipId;
    /**
     * 板块ID
     */
	@TableField("plate_id_1")
	private Long plateId1;
    /**
     * 板块ID
     */
	@TableField("plate_id_2")
	private Long plateId2;
    /**
     * 板块ID
     */
	@TableField("plate_id_3")
	private Long plateId3;
    /**
     * 板块ID
     */
	@TableField("plate_id_4")
	private Long plateId4;
    /**
     * 板块ID
     */
	@TableField("plate_id_5")
	private Long plateId5;
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

	public Long getTipId() {
		return tipId;
	}

	public void setTipId(Long tipId) {
		this.tipId = tipId;
	}

	public Long getPlateId1() {
		return plateId1;
	}

	public void setPlateId1(Long plateId1) {
		this.plateId1 = plateId1;
	}

	public Long getPlateId2() {
		return plateId2;
	}

	public void setPlateId2(Long plateId2) {
		this.plateId2 = plateId2;
	}

	public Long getPlateId3() {
		return plateId3;
	}

	public void setPlateId3(Long plateId3) {
		this.plateId3 = plateId3;
	}

	public Long getPlateId4() {
		return plateId4;
	}

	public void setPlateId4(Long plateId4) {
		this.plateId4 = plateId4;
	}

	public Long getPlateId5() {
		return plateId5;
	}

	public void setPlateId5(Long plateId5) {
		this.plateId5 = plateId5;
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
		return "TipPlate{" +
			", id=" + id +
			", gmtCreate=" + gmtCreate +
			", gmtUpdate=" + gmtUpdate +
			", tipId=" + tipId +
			", plateId1=" + plateId1 +
			", plateId2=" + plateId2 +
			", plateId3=" + plateId3 +
			", plateId4=" + plateId4 +
			", plateId5=" + plateId5 +
			", delF=" + delF +
			"}";
	}
}
