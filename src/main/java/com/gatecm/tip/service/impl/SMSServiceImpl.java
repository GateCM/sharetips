package com.gatecm.tip.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.constant.ErrorEnum;
import com.gatecm.tip.plugin.sms.AliDaYuSmsUtils;
import com.gatecm.tip.plugin.sms.VCodeBean;
import com.gatecm.tip.service.Rrs;
import com.gatecm.tip.service.SMSService;

/**
 * @ClassName: SMSServiceImpl
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:09:17
 *
 */
@Service("smsService")
public class SMSServiceImpl implements SMSService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SMSServiceImpl.class);

	// private static final int SEND_TIMES_MAX = 4;// 短信发送临界值，超过5次则使用图形验证码
	private static final Long SEND_INTERVAL = 1L;// 发送间隔，单位 min
	// private static final Long OVERDUE_TIME = 5L;// 验证码过期时间，单位 min

	private Map<String, VCodeBean> phoneNumberVCodeMap = new HashMap<>();

	@Override
	public Rrs sendRegVcode(String phoneNumber) {
		Rrs rrs = new Rrs(false);
		VCodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		// 首次发送
		if (vCodeBean == null) {
			vCodeBean = new VCodeBean();
			vCodeBean.setSendTimes(0);
			phoneNumberVCodeMap.put(phoneNumber, vCodeBean);
		}
		// 再次发送，判断请求间隔
		if (vCodeBean.getInterval(new Date()) < SEND_INTERVAL) {
			rrs.setError(ErrorEnum.VCODE_REQUEST_WAIT);
			return rrs;
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
		if (!AliDaYuSmsUtils.sendVcode(phoneNumber, vcode)) {
			rrs.setError(ErrorEnum.SYS_SMS_SEND);
			return rrs;
		}
		vCodeBean.setSendDate(new Date());
		vCodeBean.setVCode(vcode);
		// 增加短信发送次数
		vCodeBean.addSendTimes();
		LOGGER.debug("==发送验证码成功," + phoneNumber + BaseConstant.SEPARATOR_EN_COMMA + vcode);
		rrs.setResult(true);
		return rrs;
	}

	/**
	 * 验证码生成
	 * 
	 * @return
	 */
	private static String createRandomVcode() {
		String vcode = BaseConstant.BLANK_STRING;
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

}
