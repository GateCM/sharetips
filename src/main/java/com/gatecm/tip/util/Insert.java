package com.gatecm.tip.util;

/**
 * Created by yaoguang on 2019/12/26 15:02.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class Insert {

    public static void main(String[] args) {
        String a = "INSERT INTO `db_marketing`.`marketing_tag_range`(`tag_id`, `tag_type`, `type`, `value`, `start_at`, `end_at`, `gmt_create`, `gmt_modified`) VALUES ";

        int tag_id = 123459;
        int tag_type = 1;
        int range_type = 1;
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder(a);
            for (int j = 0; j < 100; j++) {
                sb.append("(");
                sb.append(tag_id+","+tag_type+","+range_type+", '"+tag_id+""+i+""+j+"', ");
                sb.append("'2019-12-09 16:41:24', '2050-01-01 00:00:00', now(), now()), ");
            }
            String sbStr = sb.substring(0, sb.length() - 2);
            String insertSql =  sbStr + "; ";
            System.out.println(insertSql);
        }

    }


}
