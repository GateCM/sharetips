/**
 * 
 */
package com.gatecm.tip.dto.vo;

/**
 * @Description: TODO(用户信息视图)
 * @author chenxiaohui
 * @date 2017年12月27日 上午10:28:12
 *
 */
public class MemberVo {

	/**
	 * 统一主键
	 */
	private Long id;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 头像路径
	 */
	private String headUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

}
