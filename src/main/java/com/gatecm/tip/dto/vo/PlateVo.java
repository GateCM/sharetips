package com.gatecm.tip.dto.vo;

/**
 * @Description: TODO(版块)
 * @author chenxiaohui
 * @date 2018年1月11日 上午11:30:23
 *
 */
public class PlateVo {

	private Long id;

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
	private Long parentPlateId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
