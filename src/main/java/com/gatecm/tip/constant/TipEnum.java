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
 * @ClassName: TipEnum
 * @Description: TODO(技巧常量)
 * @author chenxiaohui
 * @date 2017年12月16日 下午9:51:49
 *
 */
public enum TipEnum {

	PAG_NAV_PAGES_DRAFT(5, "技巧草稿分页导航显示页码"),

	/**
	 * 技巧类型原创
	 */
	TYPE_ORIGINAL(1, "原创"),

	/**
	 * 技巧类型转载
	 */
	TYPE_REPRINT(2, "转载"),

	/**
	 * 技巧私人状态
	 */
	STATUS_PRIVATE(0, "私人状态"),

	/**
	 * 技巧发布状态
	 */
	STATUS_RELEASE(1, "发布状态"),

	/**
	 * 技巧草稿状态
	 */
	STATUS_DRAFT(2, "草稿状态");

	private Object value;
	private String msg;

	private TipEnum(Object value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public Object getValue() {
		return value;
	}

	public Integer getIntegerValue() {
		return (Integer) value;
	}

	public String getMsg() {
		return msg;
	}

	public static boolean isType(Integer value) {
		if (value.equals(TYPE_ORIGINAL.getIntegerValue())) {
			return true;
		}
		if (value.equals(TYPE_REPRINT.getIntegerValue())) {
			return true;
		}
		return false;
	}

}
