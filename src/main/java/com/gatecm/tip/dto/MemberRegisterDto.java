/**
 * 
 */
package com.gatecm.tip.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.gatecm.tip.constant.BaseConstant;

/**
 * @ClassName: MemberRegisterDto
 * @Description: TODO(用户注册)
 * @author chenxiaohui
 * @date 2017年12月10日 下午8:47:48
 *
 */
public class MemberRegisterDto {

	@Pattern(regexp = BaseConstant.PHONE_NUMBER_PATTERN)
	private String phoneNumber;

	@NotBlank
	private String nickname;

	@NotBlank
	private String password;

	@NotBlank
	private String vcode;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

}
