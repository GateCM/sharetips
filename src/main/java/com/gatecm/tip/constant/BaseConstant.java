package com.gatecm.tip.constant;

/**
 * @ClassName: BaseConstant
 * @Description: TODO(系统基础常量)
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:37:59
 *
 */
public interface BaseConstant {

	/**
	 * table param
	 */
	Integer UN_DEL = 0;
	Integer IS_DEL = 1;
	/**
	 * plugin
	 */
	String WANG_EDITER_UPLOAD_ERRNO = "errno";
	int WANG_EDITER_UPLOAD_SUCCESS = 0;
	String WANG_EDITER_UPLOAD_RETURN_URL_ARRAY = "data";

	/**
	 * 正则
	 */
	String PHONE_NUMBER_PATTERN = "^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$";

	/**
	 * jackson
	 */
	String TIME_ZONE = "GMT+8";
	String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * controller返回数据参数名称
	 */
	String RESPONSE_DATA = "rd";

	String SEPARATOR_EN_COMMA = ",";
	String BLANK_STRING = "";
	String SPLIT = "-";

}
