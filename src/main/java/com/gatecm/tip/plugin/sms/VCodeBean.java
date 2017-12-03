/**  
* @Title: VCodeBean.java
* @Package com.gatecm.tip.plugin.sms
* @Description: TODO()
* @author chenxiaohui
* @date 2017年12月3日 下午3:52:37
* @version V1.0  
*/
package com.gatecm.tip.plugin.sms;

import java.util.Date;

import com.gatecm.tip.util.TimeUtils;

/**
 * @ClassName: VCodeBean
 * @Description: TODO(短信和图片验证码实体)
 * @author chenxiaohui
 * @date 2017年12月3日 下午3:52:54
 *
 */
public class VCodeBean {

	private String vCode;// 验证码
	private int sendTimes;// 发送次数
	private Date sendDate;// 发送时间

	public VCodeBean() {
	}

	public VCodeBean(String code, Date sendDate) {
		this.vCode = code;
		this.sendDate = sendDate;
	}

	public VCodeBean(String code, Date sendDate, int sendTimes) {
		this.vCode = code;
		this.sendDate = sendDate;
		this.sendTimes = sendTimes;
	}

	public int getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(int sendTimes) {
		this.sendTimes = sendTimes;
	}

	public void addSendTimes() {
		this.sendTimes = this.sendTimes + 1;
	}

	public String getVCode() {
		return vCode;
	}

	public void setVCode(String code) {
		this.vCode = code;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	// 获取发送间隔，单位：min
	public Long getInterval(Date customDate) {
		if (sendDate != null) {
			return TimeUtils.minuteDiff(customDate, sendDate);
		}
		return Long.MAX_VALUE;
	}

}
