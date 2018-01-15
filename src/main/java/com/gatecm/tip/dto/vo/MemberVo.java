/**
 * 
 */
package com.gatecm.tip.dto.vo;

import java.util.Date;

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

	/**
	 * 签名
	 */
	private String motto;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 职业
	 */
	private String occupation;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 历史总积分
	 */
	private Long totalPoint;
	/**
	 * 当前积分
	 */
	private Long currentPoint;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public Long getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Long totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Long getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Long currentPoint) {
		this.currentPoint = currentPoint;
	}

	public void brief() {
		setAge(null);
		setSex(null);
		setBirthday(null);
		setEmail(null);
		setOccupation(null);
		setTotalPoint(null);
		setCurrentPoint(null);
	}
}
