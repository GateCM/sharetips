/**  
* @Title: MemberEnum.java
* @Package com.gatecm.tip.constant
* @Description: TODO()
* @author chenxiaohui
* @date 2017年12月3日 下午2:29:30
* @version V1.0  
*/
package com.gatecm.tip.constant;

/**
 * @ClassName: MemberEnum
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月3日 下午2:29:30
 *
 */
public enum MemberEnum {

	STATUS_NORMAL("1", "会员状态，正常，默认状态");

	private Object value;
	private String msg;

	private MemberEnum(Object value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public Object getValue() {
		return value;
	}

	public String getMsg() {
		return msg;
	}

}
