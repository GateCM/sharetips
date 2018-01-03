package com.gatecm.tip.plugin.sms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gatecm.tip.constant.BaseConstant;
import com.gatecm.tip.constant.ErrorEnum;
import com.gatecm.tip.plugin.sms.AliDaYuSmsUtils;
import com.gatecm.tip.plugin.sms.VcodeBean;
import com.gatecm.tip.service.Rrs;

/**
 * @ClassName: SMSServiceImpl
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月3日 下午4:09:17
 *
 */
@Component("smsUtils")
public class SmsUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(SmsUtils.class);

	private Map<String, VcodeBean> phoneNumberVCodeMap = new HashMap<>();

	/**
	 * 发送间隔，单位 min
	 */
	private static final long SEND_INTERVAL = 1L;
	/**
	 * 验证码长度
	 */
	private static final int VCODE_LENGTH = 6;
	/**
	 * 验证码过期时间(min)
	 */
	private static final Long OVERDUE_TIME = 5L;

	/**
	 * 发送验证码
	 * 
	 * @param phoneNumber
	 * @return Rrs
	 */
	public Rrs sendRegVcode(String phoneNumber) {
		Rrs rrs = new Rrs(false);
		VcodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		// 首次发送
		if (vCodeBean == null) {
			vCodeBean = new VcodeBean();
			vCodeBean.setSendTimes(0);
			phoneNumberVCodeMap.put(phoneNumber, vCodeBean);
		}
		// 再次发送，判断请求间隔
		if (vCodeBean.getInterval(new Date()) < SEND_INTERVAL) {
			rrs.setError(ErrorEnum.VCODE_REQUEST_WAIT);
			return rrs;
		}
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
		LOGGER.info("==发送验证码成功," + phoneNumber + BaseConstant.SEPARATOR_EN_COMMA + vcode);
		rrs.setResult(true);
		rrs.setData(vCodeBean);
		return rrs;
	}

	/**
	 * 短信验证码验证
	 * 
	 * @param phoneNumber
	 * @param vcode
	 * @return
	 */
	public VcodeEnum validation(String phoneNumber, String vcode) {
		if (StringUtils.isEmpty(vcode)) {
			return VcodeEnum.VCODE_ERROR;
		}
		VcodeBean vCodeBean = phoneNumberVCodeMap.get(phoneNumber);
		if (vCodeBean != null && vcode.equals(vCodeBean.getVCode())) {
			if (vCodeBean.getInterval(new Date()) < OVERDUE_TIME) {
				return VcodeEnum.VCODE_CORRECT;
			} else {
				return VcodeEnum.VCODE_TIME_OUT;
			}
		} else {
			return VcodeEnum.VCODE_ERROR;
		}
	}

	/**
	 * 根据手机号移除验证码
	 * 
	 * @param phoneNumber
	 */
	public void removeVcodeByPhoneNumber(String phoneNumber) {
		phoneNumberVCodeMap.remove(phoneNumber);
	}

	/**
	 * 获取短信发送实体
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public VcodeBean getVCodeBean(String phoneNumber) {
		return phoneNumberVCodeMap.get(phoneNumber);
	}

	/**
	 * 验证码生成
	 * 
	 * @return
	 */
	private static String createRandomVcode() {
		StringBuilder vcode = new StringBuilder(BaseConstant.BLANK_STRING);
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < VCODE_LENGTH; i++) {
			vcode.append(random.nextInt(10));
		}
		return vcode.toString();
	}

}
