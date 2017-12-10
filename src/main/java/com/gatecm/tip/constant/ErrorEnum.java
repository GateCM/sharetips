package com.gatecm.tip.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @ClassName: ErrorEnum
 * @Description: TODO(全局错误)
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:24:29
 *
 */
public enum ErrorEnum {
	/**
	 * 全局异常
	 */
	SYS_EXCEPTION(0, "0", "系统错误"),

	/**
	 * 短信发送失败
	 */
	SYS_SMS_SEND(0, "0000", "短信发送失败"),

	SYS(0, "0000", "会员状态，正常，默认状态"),

	VCODE_ERROR(1, "1001", "验证码错误, 请重新输入"),

	VCODE_TIME_OUT(1, "1002", "该验证码已过期, 请重新获取"),

	VCODE_REQUEST_WAIT(1, "1003", "验证码请求过于频繁"),

	D(-1, "134243233", "meiyouyiyi");

	private Integer type;
	private String code;
	private String msg;

	private ErrorEnum(Integer type, String code, String msg) {
		this.type = type;
		this.code = code;
		this.msg = msg;
	}

	@JsonValue
	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getType() {
		return type;
	}

}
