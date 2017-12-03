package com.gatecm.tip.constant;

/**
 * @ClassName: ALISMSEnum
 * @Description: TODO(阿里大于短信常量)
 * @author chenxiaohui
 * @date 2017年12月3日 下午3:18:45
 *
 */
public enum ALISMSEnum {

	URL_HTTPS("https://eco.taobao.com/router/rest", "正式环境"),

	SECRET("c5675c2f37edfa87463ada65334b5a2a", "App Secret"),

	APPKEY("23618987", "TOP分配给应用的AppKey"),

	TYPE("normal", "短信类型，传入值请填写normal"),

	FREE_SIGN_NAME("测试签名", "短信签名"), // 短信签名，传入的短信签名必须是在阿里大于“管理中心-验证码/短信通知/推广短信-配置短信签名”中的可用签名。如“阿里大于”已在短信签名管理中通过审核，则可传入”阿里大于“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大于】欢迎使用阿里大于服务。

	PARAM_VCODE("verification_code", "验证码变量"),

	TEMPLATE_CODE_VCODE("SMS_58945170", "验证码短信模板ID"),

	EXTEND_DEFAULT("", "公共回传参数,默认");// 公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用

	private Object value;
	private String msg;

	private ALISMSEnum(Object value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public Object getValue() {
		return value;
	}

	public String getMsg() {
		return msg;
	}

	public String getVcode(Object code) {
		StringBuilder sBuilder = new StringBuilder("{");
		sBuilder.append(PARAM_VCODE.value);
		sBuilder.append(":'");
		sBuilder.append(code);
		sBuilder.append("'}");
		return sBuilder.toString();
	}

}
