/**
 * 
 */
package com.gatecm.tip.dto;

/**
 * @Description: TODO(列表分页参数)
 * @author chenxiaohui
 * @date 2017年12月19日 上午11:55:24
 *
 */
public class PaginationDto {

	/**
	 * 当前页
	 */
	private Integer pageNum = 1;
	/**
	 * 每页的数量
	 */
	private Integer pageSize = 5;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
