package com.gatecm.tip.service;

import java.util.ArrayList;
import java.util.List;

import com.gatecm.tip.constant.ErrorEnum;

/**
 * @ClassName: RRS
 * @Description: TODO(请求结果集 Request result set)
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:13:22
 *
 */
public class Rrs {
	/**
	 * 操作结果，成功|失败，仅表示方法是否顺利执行
	 */
	boolean result;
	/**
	 * 返回数据主体
	 */
	Object data;
	/**
	 * 错误
	 */
	ErrorEnum error;
	/**
	 * 多错误码
	 */
	List<ErrorEnum> errors = null;

	public Rrs() {

	}

	public Rrs(boolean result) {
		this.result = result;
	}

	public Rrs(boolean result, ErrorEnum error) {
		this.result = result;
		this.error = error;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ErrorEnum getError() {
		return error;
	}

	public void setError(ErrorEnum error) {
		this.error = error;
	}

	public void addError(ErrorEnum error) {
		if (errors == null) {
			errors = new ArrayList<>();
		}
		errors.add(error);
	}

}
