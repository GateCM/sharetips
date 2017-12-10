package com.gatecm.tip.plugin.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gatecm.tip.constant.ALiSMSEnum;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * @ClassName: AliDaYuSmsUtils
 * @Description: TODO(阿里大于短信发送工具)
 * @author chenxiaohui
 * @date 2017年12月3日 下午3:05:32
 *
 */
public class AliDaYuSmsUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(AliDaYuSmsUtils.class);

	private AliDaYuSmsUtils() {
	}

	/**
	 * 发送验证码
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean sendVcode(String phoneNumber, String vcode) {
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend(ALiSMSEnum.EXTEND_DEFAULT.getValue().toString());
		req.setSmsType(ALiSMSEnum.TYPE.getValue().toString());
		req.setSmsFreeSignName(ALiSMSEnum.FREE_SIGN_NAME.getValue().toString());
		req.setSmsParamString(ALiSMSEnum.PARAM_VCODE.getVcode(vcode));
		req.setRecNum(phoneNumber);
		req.setSmsTemplateCode(ALiSMSEnum.TEMPLATE_CODE_VCODE.getValue().toString());
		return send(req);
	}

	/**
	 * 发送短信
	 * 
	 * @param req
	 * @return
	 */
	private static boolean send(AlibabaAliqinFcSmsNumSendRequest req) {
		TaobaoClient client = new DefaultTaobaoClient(ALiSMSEnum.URL_HTTPS.getValue().toString(),
				ALiSMSEnum.APPKEY.getValue().toString(), ALiSMSEnum.SECRET.getValue().toString());
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
			LOGGER.error(e.getErrMsg());
			return false;
		}
		if (rsp.getResult() == null) {
			return false;
		}
		return rsp.getResult().getSuccess();
	}
}
