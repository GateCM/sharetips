/**
 * 
 */
package com.gatecm.tip.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gatecm.tip.entity.MemberBasic;

/**
 * @ClassName: ShiroSessionUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2017年12月16日 下午4:30:22
 *
 */
//@Component
@Service
public class ShiroSessionUtils {

	public Long getMemberId() {
		return getMember().getId();
	}

	public MemberBasic getMember() {
		return (MemberBasic) SecurityUtils.getSubject().getPrincipal();
	}
}
