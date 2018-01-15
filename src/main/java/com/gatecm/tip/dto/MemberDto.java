package com.gatecm.tip.dto;

import java.util.Date;

import com.gatecm.tip.entity.MemberBasic;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2018年1月15日 下午2:24:48
 *
 */
public class MemberDto {

	private String nickname;

	private String headUrl;

	private Integer age;

	private Integer sex;

	private String motto;

	private Date birthday;

	private String occupation;

	private String email;

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

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
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

	public MemberBasic returnUpdateBasic() {
		MemberBasic basic = new MemberBasic();
		basic.setAge(getAge());
		basic.setSex(getSex());
		basic.setBirthday(getBirthday());
		basic.setEmail(getEmail());
		basic.setHeadUrl(getHeadUrl());
		basic.setMotto(getMotto());
		basic.setNickname(getNickname());
		basic.setOccupation(getOccupation());
		return basic;
	}

}
