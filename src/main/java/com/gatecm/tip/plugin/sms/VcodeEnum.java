/**
 * 
 */
package com.gatecm.tip.plugin.sms;

/**
 * @ClassName: VcodeEnum
 * @Description: TODO(验证码常量)
 * @author chenxiaohui
 * @date 2017年12月11日 下午10:21:08
 *
 */
public enum VcodeEnum {

	VCODE_ERROR(0), // 验证码错误

	VCODE_CORRECT(1), // 验证码正确

	VCODE_TIME_OUT(2);// 验证码过期

	private int value;

	private VcodeEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
