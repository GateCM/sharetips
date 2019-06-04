package demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yaoguang on 2018/12/25 13:42.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class fsa {

    public static void main(String[] args) throws IOException {
        File file = new File("aa.text");
        file.createNewFile();
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(file);
            StringBuilder sourceString = new StringBuilder();    //待写入字符串


            String sql_pre = "INSERT INTO `db_operating`.`ad_action_day_statistic`(`date`, `year`, `month`, `day`, `hour`, `type`, `block_code`, `node_code`, `district_code`, `plan_res_id`, `idea_id`, `material_id`, `project_id`, `unit_id`, `action`, `number`, `time`, `is_deprecated`) VALUES (";
            String sql_suffix = ",0,'0001', '0001', '339900', NULL, 51790, NULL, NULL, NULL, 0, 200, 0, 0);";


            int key = 0;
            for (int iy = 2021; iy < 2023; ++iy) {
                for (int im = 1; im < 12; ++im) {
                    for (int id = 1; id < 30; ++id) {
                        for (int ih = 1; ih < 24; ++ih) {
                            StringBuilder sb = new StringBuilder(sql_pre);
                            sb.append(iy);
                            sb.append(im);
                            sb.append(id);
                            sb.append(ih);
                            sb.append(",");
                            sb.append(iy);
                            sb.append(",");
                            sb.append(im);
                            sb.append(",");
                            sb.append(id);
                            sb.append(",");
                            sb.append(ih);
                            sb.append(sql_suffix);
                            System.out.println(sb.toString());
                            sourceString.append(sb.toString());
                            ++key;
                        }
                    }
                }
            }
            byte[] sourceByte = sourceString.toString().getBytes();
            outStream.write(sourceByte);
            System.out.println(key);
        } finally {
            outStream.close();
        }



    }
}
