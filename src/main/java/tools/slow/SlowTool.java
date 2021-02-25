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
import org.springframework.util.StringUtils;

import java.net.URLEncoder;
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

    public static final String SLOW_HTTP_REQ_URL = "http://paas.cai-inc.com/api/stability/api/rt/uriResult/?secteam=&team=${team}&status=&insert_time_after=&insert_time_before=&expect_time_after=&handler=&id=&appname=&uri=&p=${pageNo}&page_size=200";
    public static final String SLOW_DUBBO_REQ_URL = "http://paas.cai-inc.com/api/stability/api/rt/dubboResult/?secteam=&team=${team}&status=&insert_time_after=&insert_time_before=&expect_time_after=&handler=&id=&appname=&uri=&service_name=&method_name=&p=${pageNo}&page_size=200";
    public static final String SLOW_SQL_REQ_URL = "http://paas.cai-inc.com/api/stability/api/slow/resultsql/?dbname=&secteam=&team=${team}&entity=&createtime_after=&createtime_before=&status=&plandate_after=&plandate_before=&dealer=&id=&sqltext=&p=${pageNo}&page_size=200";

    public static final List<String> STATUS_LIST = Arrays.asList("暂不处理", "待处理", "处理中", "已完成", "待更新");

    public static final String HTTP = "http";
    public static final String DUBBO = "dubbo";
    public static final String SQL = "sql";

    public static Map<String, Integer> CURRENT_STATUS_MAP = new TreeMap<>();
    public static Map<String, Integer> OLD_STATUS_MAP = new TreeMap<>();

    public static void main(String[] args){
        String oldStatusMapJson = "{\"dubbo_已完成\":3,\"sql_待更新\":0,\"http_待更新\":0,\"sql_处理中\":0,\"http_处理中\":0,\"sql_暂不处理\":0,\"dubbo_处理中\":0,\"sql_已完成\":19,\"http_暂不处理\":39,\"dubbo_暂不处理\":2,\"http_待处理\":21,\"sql_待处理\":1,\"dubbo_待处理\":0,\"dubbo_待更新\":0,\"http_已完成\":21}";
        OLD_STATUS_MAP = JSON.parseObject(oldStatusMapJson, TreeMap.class);

        String team = "支付金融";
        System.out.println(team);
        printCount(HTTP, team);
        printCount(DUBBO, team);
        printCount(SQL, team);

        System.err.println();
        System.err.println();
        System.err.println(JSON.toJSONString(CURRENT_STATUS_MAP));
        System.err.println();


//        printHttp("营销平台","","");
//        printDubbo("营销平台");
//        printSQL("营销平台");
    }


    public static void printHttp(String team, String appName, String status) {
        String url = encodeUrl(team, HTTP);
        List<SlowHttpDTO> allHttp = getALLSlowHttpDTOS(url, SlowHttpDTO.class);
        allHttp = allHttp.stream().sorted(Comparator.comparing(SlowHttpDTO::getAppname)).collect(Collectors.toList());
        for (SlowHttpDTO slowDTO : allHttp) {
            if (!StringUtils.isEmpty(appName) && !appName.equals(slowDTO.getAppname())) {
                continue;
            }
            if (!StringUtils.isEmpty(status) && !status.equals(slowDTO.getStatus())) {
                continue;
            }
            System.out.println(slowDTO.getAppname() + " " + slowDTO.getStatus() + " " + slowDTO.getUri() + " p95:" + slowDTO.getRt_p95());
        }
    }

    public static void printSQL(String team) {
        List<SlowSqlDTO> allHttp = getALLSlowHttpDTOS(encodeUrl(team, SQL), SlowSqlDTO.class);
        allHttp = allHttp.stream().sorted(Comparator.comparing(SlowSqlDTO::getDbname)).collect(Collectors.toList());
        for (SlowSqlDTO slowSqlDTO : allHttp) {
            System.out.println(slowSqlDTO.getDbname() + " " + slowSqlDTO.getSqltext());
        }
    }

    public static void printDubbo(String team) {
        List<SlowDubboDTO> allHttp = getALLSlowHttpDTOS(encodeUrl(team, DUBBO), SlowDubboDTO.class);
        allHttp = allHttp.stream().sorted(Comparator.comparing(SlowDubboDTO::getAppname)).collect(Collectors.toList());
        for (SlowDubboDTO slowDubboDTO : allHttp) {
            System.out.println(slowDubboDTO.getAppname() + " " + slowDubboDTO.getMethod_name() + " " + slowDubboDTO.getMethod_name());
        }
    }


    public static void printCount(String type, String team) {
        System.err.println();
        printFormat(type);
        String url = encodeUrl(team, type);
        List<SlowDTO> allHttp = getALLSlowHttpDTOS(url, SlowDTO.class);
        int currentTotal = allHttp.size();
        int oldTotal = 0;
        Map<String, List<SlowDTO>> statusMap = allHttp.stream().collect(Collectors.groupingBy(SlowDTO::getStatus));
        for (String s : STATUS_LIST) {
            List<SlowDTO> slowDTOList = statusMap.get(s);
            int count = 0;
            if (!CollectionUtils.isEmpty(slowDTOList)) {
                count = slowDTOList.size();
            }
            String key = type + "_" + s;
            Integer oldStatusCount = OLD_STATUS_MAP.get(key);
            if (Objects.isNull(oldStatusCount)) {
                oldStatusCount = 0;
            }
            oldTotal += oldStatusCount;
            if (oldStatusCount.equals(count)) {
                printFormat(s + " " + count);
                continue;
            }
            printDiff(s, count, oldStatusCount);
            CURRENT_STATUS_MAP.put(key, count);
        }
        printDiff(" 总数", currentTotal, oldTotal);
    }

    private static String encodeUrl(String team, String type) {
        try {
            if (HTTP.equals(type)) {
                return SLOW_HTTP_REQ_URL.replace("${team}", URLEncoder.encode(team, "utf-8"));
            }
            if (DUBBO.equals(type)) {
                return SLOW_DUBBO_REQ_URL.replace("${team}", URLEncoder.encode(team, "utf-8"));
            }
            if (SQL.equals(type)) {
                return SLOW_SQL_REQ_URL.replace("${team}", URLEncoder.encode(team, "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void printDiff(String s, int count, Integer oldStatusCount) {
        int diff = Math.abs(count - oldStatusCount);
        if (count > oldStatusCount) {
            printFormat(s + " " + count + "(↑" + diff + ")");
        }
        if (count < oldStatusCount) {
            printFormat(s + " " + count + "(↓" + diff + ")");
        }
    }

    private static void printFormat(String str) {
        System.err.print(String.format("%1$-14s", str) + " | ");
    }

    private static <T extends SlowDTO> List<T> getALLSlowHttpDTOS(String url, Class<T> clazz) {
        int pageNo = 1;
        List<T> allSlow = new ArrayList<>();
        List<T> slows = getSlowDTOS(pageNo, url, clazz);
        while (!CollectionUtils.isEmpty(slows)) {
            allSlow.addAll(slows);
            pageNo++;
            slows = getSlowDTOS(pageNo, url, clazz);
        }
        return allSlow;
    }

    private static <T extends SlowDTO> List<T> getSlowDTOS(int pageNo, String url, Class<T> clazz) {
        String result = getResult(url.replace("${pageNo}", pageNo + ""));
        JSONObject jsonObject = JSON.parseObject(result);
        if (jsonObject.getBoolean("errors")) {
            return null;
        }
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray resultArray = data.getJSONArray("results");
        Integer count = resultArray.size();
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
