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
 * 系统技巧板块
 * </p>
 *
 * @author chenxiaohui
 * @since 2018-01-11
 */
@TableName("sys_tip_plate")
public class SysTipPlate extends Model<SysTipPlate> {

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
     * 板块名称
     */
	private String name;
    /**
     * 板块码
     */
	private Integer code;
    /**
     * 所属父板块ID
     */
	@TableField("parent_plate_id")
	private Long parentPlateId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Long getParentPlateId() {
		return parentPlateId;
	}

	public void setParentPlateId(Long parentPlateId) {
		this.parentPlateId = parentPlateId;
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
		return "SysTipPlate{" +
			", id=" + id +
			", gmtCreate=" + gmtCreate +
			", gmtUpdate=" + gmtUpdate +
			", name=" + name +
			", code=" + code +
			", parentPlateId=" + parentPlateId +
			", delF=" + delF +
			"}";
	}
}
