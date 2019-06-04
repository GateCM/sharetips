package wechat.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by yaoguang on 2019/4/28 21:44.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class ClientRequestHandler extends PrepayIdRequestHandler {

    public ClientRequestHandler(HttpServletRequest request,
                                HttpServletResponse response) {
        super(request, response);
        // TODO Auto-generated constructor stub
    }

    public String getXmlBody() {
        StringBuffer sb = new StringBuffer();
        Set es = super.getAllParameters().entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"appkey".equals(k)) {
                sb.append("<" + k + ">" + v + "<" + k + ">" + "\r\n");
            }
        }
        return sb.toString();
    }
}