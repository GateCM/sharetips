package tools.slow;

import lombok.Data;

import java.util.Date;

/**
 * Created by yaoguang on 2021/2/9 17:51.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
@Data
public class SlowHttpDTO extends SlowDTO{

    private String uri;
    private String handler;
    private String appname;
    private Date insert_time;
    private Integer rt_p50;
    private Integer rt_p90;
    private Integer rt_p95;
    private Integer rt_p99;
    private Integer repeat_count;
}
