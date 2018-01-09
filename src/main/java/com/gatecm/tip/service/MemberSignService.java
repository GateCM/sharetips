package com.gatecm.tip.service;

/**
 * @Description: TODO(用户签到)
 * @author chenxiaohui
 * @date 2018年1月9日 下午2:17:24
 *
 */
public interface MemberSignService {

	/**
	 * 判断今日是否签到
	 * 
	 * @return
	 */
	Rrs isSignToday();

	/**
	 * 今日签到
	 * 
	 * @return
	 */
	Rrs signToday();
}
