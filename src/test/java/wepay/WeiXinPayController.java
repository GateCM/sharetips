package wepay;

/**
 * Created by yaoguang on 2019/4/28 22:02.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jdom.JDOMException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.UUID;

@Controller
@RequestMapping(value = "/api")
public class WeiXinPayController {
    private static String wxnotify = "/api/json/money/wxpay/succ";

    /**
     * 调用统一支付API，并将结果返回给app
     * https://www.cnblogs.com/007sx/p/5811137.html
     *
     * @param totalAmount    支付金额
     * @param description    描述
     * @param request -
     * @return -
     */
    @RequestMapping(value = "/weixin/weixinPay/{totalAmount}/{description}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SortedMap<String, Object> ToPay(@PathVariable BigDecimal totalAmount, @PathVariable String description, HttpServletRequest request) {
        String sym = request.getRequestURL().toString().split("/api/")[0];
        // 订单号
        String tradeNo = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase().substring(0,32);
        // 回调地址
        String notifyUrl = sym + wxnotify;
        // 自定义参数
        Long userId = 100L; //对应用户id自己修改
        JSONObject jsAtt = new JSONObject();
        jsAtt.put("uid", userId);
        String attach = jsAtt.toJSONString();
        // 返回预支付参数
        return PayCommonUtil.WxPublicPay(tradeNo, totalAmount, description, attach, notifyUrl, request);
    }

    /**
     * 支付回调地址
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/json/money/wxpay/succ",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String wxpaySucc(HttpServletRequest request) throws IOException {
        System.out.println("微信支付回调");
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        String resultxml = new String(outSteam.toByteArray(), "utf-8");
        Map<String, String> params = null;
        try {
            params = PayCommonUtil.doXMLParse(resultxml);
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        outSteam.close();
        inStream.close();
        if (!PayCommonUtil.isTenpaySign(params)) {
            // 支付失败
            return "fail";
        } else {
            System.out.println("===============付款成功==============");
            // ------------------------------
            // 处理业务开始
            // ------------------------------
            // 此处处理订单状态，结合自己的订单数据完成订单状态的更新
            // ------------------------------

            String total_fee = params.get("total_fee");
            double v = Double.valueOf(total_fee) / 100;
            // 取出用户id
            String attach = params.get("attach");
            JSONObject jsonObject = JSON.parseObject(attach);
            Long userId = Long.parseLong(jsonObject.get("uid").toString());

            //更新
            //updateUserPay(userId, String.valueOf(v));

            // 处理业务完毕
            // ------------------------------
            return "success";
        }
    }

}
