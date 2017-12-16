/**
 * 
 */
package com.gatecm.tip.config.shiro;

import org.apache.shiro.SecurityUtils;

import com.gatecm.tip.entity.MemberBasic;

/**
 * @ClassName: ShiroSessionUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2017年12月16日 下午4:30:22
 *
 */
public class ShiroSessionUtils {

	private ShiroSessionUtils() {
	}

	public static Long getMemberId() {
		return getMember().getId();
	}

	public static MemberBasic getMember() {
		MemberBasic member = (MemberBasic) SecurityUtils.getSubject().getPrincipal();
		return member;
	}
}
