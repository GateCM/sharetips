package com.gatecm.tip.plugin.sms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SMSManager
 * @Description: TODO(短信管理)
 * @author chenxiaohui
 * @date 2017年12月3日 下午3:43:42
 *
 */
public class SMSManager {
	private final Logger log = LoggerFactory.getLogger(SMSManager.class);
	private static final int SEND_TIMES_MAX = 4;// 短信发送临界值，超过5次则使用图形验证码
	private static final Long SEND_INTERVAL = 0L;// 发送间隔，单位 min
	private static final Long OVERDUE_TIME = 5L;// 验证码过期时间，单位 min
	private static final String SEPARATOR = ",";

	private Map<String, VCodeBean> phoneNumberVCodeMap = new HashMap<>();

	private static SMSManager vcodeManage = new SMSManager();

	private SMSManager() {
	}

	public static SMSManager getInstance() {
		return vcodeManage;
	}

	/**
	 * 验证码发送
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean sendVode(String phoneNumber) {
		Date current = new Date();
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		// 首次发送
		if (vCodeBean == null) {
			vCodeBean = new VCodeBean();
			vCodeBean.setSendTimes(0);
			phoneNumberVCodeMap.put(phoneNumber, vCodeBean);
		}
		// 再次发送，判断请求间隔
		if (vCodeBean.getInterval(current) < SEND_INTERVAL) {
			// vCodeBean.setErrorCode(ErrorVCodeEnum.VCODE_REQUST_SMS_WAIT);
			return false;
		}

		// 判断请求次数和图形验证码是否正确
		// if (vCodeBean.getSendTimes() > SEND_TIMES_MAX) {
		// if (!isImgCodeRight) {
		// vCodeBean.setErrorCode(ErrorVCodeEnum.VCODE_REQUST_IMG_INCORRECT);
		// return false;
		// } else {
		// vCodeBean.setSendTimes(0);// 重置短信验证码请求次数
		// }
		// }
		// 生成验证码
		String vcode = createRandomVcode();
		// 发送验证码
		if (AliDaYuSmsUtils.sendVcode(phoneNumber, vcode)) {
			vCodeBean.setSendDate(current);
			vCodeBean.setVCode(vcode);
			// 增加短信发送次数
			vCodeBean.addSendTimes();
			log.error("==发送验证码成功," + phoneNumber + SEPARATOR + vcode);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证码生成
	 * 
	 * @return
	 */
	private static String createRandomVcode() {
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

}
