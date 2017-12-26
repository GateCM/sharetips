package com.gatecm.tip.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 用户基本信息表，用来存储用户最基本的信息。
 * </p>
 *
 * @author chenxiaohui
 * @since 2017-12-02
 */
@TableName("member_basic")
public class MemberBasic extends Model<MemberBasic> implements Serializable {

	// private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8611394950130495601L;
	/**
	 * 统一主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	 * 记录创建时间
	 */
	@TableField("gmt_create")
	private Date gmtCreate;
	/**
	 * 记录最近更新时间
	 */
	@TableField("gmt_update")
	private Date gmtUpdate;
	/**
	 * 0:冻结；1：正常
	 */
	private Integer status;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像路径
	 */
	@TableField("head_url")
	private String headUrl;
	/**
	 * 手机号
	 */
	@TableField("phone_number")
	private String phoneNumber;
	/**
	 * QQ号
	 */
	private String qq;
	/**
	 * 微信号
	 */
	@TableField("we_chat")
	private String weChat;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 性别，2种以上性别
	 */
	private Integer sex;
	/**
	 * 加密后的密码
	 */
	private String password;
	/**
	 * 盐值
	 */
	private String salt;
	/**
	 * 座右铭
	 */
	private String motto;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 职业
	 */
	private String occupation;
	/**
	 * 历史总积分
	 */
	@TableField("total_point")
	private Long totalPoint;
	/**
	 * 当前积分
	 */
	@TableField("current_point")
	private Long currentPoint;
	/**
	 * 0:未删除；1：删除
	 */
	@TableField("is_del")
	private Boolean isDel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtUpdate() {
		return gmtUpdate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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

	public Boolean getDel() {
		return isDel;
	}

	public void setDel(Boolean isDel) {
		this.isDel = isDel;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "MemberBasic{" + ", id=" + id + ", gmtCreate=" + gmtCreate + ", gmtUpdate=" + gmtUpdate + ", status="
				+ status + ", nickname=" + nickname + ", headUrl=" + headUrl + ", phoneNumber=" + phoneNumber + ", qq="
				+ qq + ", weChat=" + weChat + ", email=" + email + ", sex=" + sex + ", password=" + password + ", salt="
				+ salt + ", motto=" + motto + ", birthday=" + birthday + ", age=" + age + ", occupation=" + occupation
				+ ", totalPoint=" + totalPoint + ", currentPoint=" + currentPoint + ", isDel=" + isDel + "}";
	}
}
