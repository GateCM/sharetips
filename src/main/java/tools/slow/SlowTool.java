package tools.slow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yaoguang on 2021/2/9 17:09.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
@Slf4j
public class SlowTool {

    public static final String SLOW_HTTP_REQ_URL = "http://paas.cai-inc.com/api/stability/api/rt/uriResult/?secteam=&team=%E8%90%A5%E9%94%80%E5%B9%B3%E5%8F%B0&status=&insert_time_after=&insert_time_before=&expect_time_after=&handler=&id=&appname=&uri=&p=1&page_size=10000";
    public static final String SLOW_DUBBO_REQ_URL = "http://paas.cai-inc.com/api/stability/api/rt/dubboResult/?secteam=&team=%E8%90%A5%E9%94%80%E5%B9%B3%E5%8F%B0&status=&insert_time_after=&insert_time_before=&expect_time_after=&handler=&id=&appname=&uri=&service_name=&method_name=&p=1&page_size=10000";
    public static final String SLOW_SQL_REQ_URL = "http://paas.cai-inc.com/api/stability/api/slow/resultsql/?dbname=&secteam=&team=%E8%90%A5%E9%94%80%E5%B9%B3%E5%8F%B0&entity=&createtime_after=&createtime_before=&status=&plandate_after=&plandate_before=&dealer=&id=&sqltext=&p=1&page_size=10000";

    public static final List<String> STATUS_LIST = Arrays.asList("暂不处理", "待处理", "处理中", "已完成", "待更新");

    public static Map<String, Integer> CURRENT_STATUS_MAP = new TreeMap<>();
    public static Map<String, Integer> OLD_STATUS_MAP = new TreeMap<>();

    public static void main(String[] args) {
        String oldStatusMapJson = "{\"dubbo_已完成\":2,\"sql_待更新\":1,\"http_待更新\":12,\"sql_处理中\":0,\"http_处理中\":3,\"sql_暂不处理\":1,\"dubbo_处理中\":0,\"sql_已完成\":19,\"http_暂不处理\":47,\"dubbo_暂不处理\":2,\"http_待处理\":7,\"sql_待处理\":0,\"dubbo_待处理\":0,\"dubbo_待更新\":0,\"http_已完成\":24}";
        OLD_STATUS_MAP = JSON.parseObject(oldStatusMapJson, TreeMap.class);

        printCount("http", SLOW_HTTP_REQ_URL);
        printCount("dubbo", SLOW_DUBBO_REQ_URL);
        printCount("sql", SLOW_SQL_REQ_URL);

        System.out.println();
        String statusMapJson = JSON.toJSONString(CURRENT_STATUS_MAP);
        System.out.println(statusMapJson);
        System.out.println();
    }


    public static void printCount(String title, String url) {
        System.err.println("=====" + title + "=====");
        List<SlowDTO> allHttp = getSlowDTOS(url, SlowDTO.class);
        Map<String, List<SlowDTO>> statusMap = allHttp.stream().collect(Collectors.groupingBy(SlowDTO::getStatus));
        for (String s : STATUS_LIST) {
            List<SlowDTO> slowDTOList = statusMap.get(s);
            int count = 0;
            if (!CollectionUtils.isEmpty(slowDTOList)) {
                count = slowDTOList.size();
            }


            String key = title + "_" + s;
            Integer oldStatusCount = OLD_STATUS_MAP.get(key);
            if (Objects.isNull(oldStatusCount)) {
                oldStatusCount = 0;
            }
            if (oldStatusCount.equals(count)) {
                System.err.println(s + ": " + count);
                continue;
            }
            int diff = Math.abs(count - oldStatusCount);
            if (count > oldStatusCount) {
                System.err.println(s + ": " + count + "(↑" + diff + ")");
            }
            if (count < oldStatusCount) {
                System.err.println(s + ": " + count + "(↑" + diff + ")");
            }
            CURRENT_STATUS_MAP.put(key, count);
        }
    }

    private static <T extends SlowDTO> List<T> getSlowDTOS(String url, Class<T> clazz) {
        String result = getResult(url);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONObject data = jsonObject.getJSONObject("data");
        //总数
        Integer count = data.getInteger("count");
        System.err.println("总数 " + count);
        JSONArray resultArray = data.getJSONArray("results");
        T slowDTO;
        List<T> allHttp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            slowDTO = resultArray.getObject(i, clazz);
            if (Objects.isNull(slowDTO.getStatus())) {
                slowDTO.setStatus("待更新");
            }
            allHttp.add(slowDTO);
        }
        return allHttp;
    }

    private static String getResult(String url) {
        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            HttpGet get = new HttpGet(url);
            // 通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(get);
            // 判断网络连接状态码是否正常(0--200都数正常)
            return EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
