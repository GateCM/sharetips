package tools.slow;

import lombok.Data;

/**
 * Created by yaoguang on 2021/2/9 17:51.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
@Data
public class SlowSqlDTO extends SlowDTO{

    private String sqldate;
    private String sqltext;
    private String dealer;
    private String dbname;
}
