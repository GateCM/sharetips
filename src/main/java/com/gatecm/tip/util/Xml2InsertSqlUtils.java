package com.gatecm.tip.util;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;

/**
 * Created by yaoguang on 2019/6/19 16:16.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class Xml2InsertSqlUtils {

    /**
     * 配置参数
     */
    public static final String INSERT_PRE = "INSERT INTO `db_vaccine`.`vaccine_manufacturer`(`id`, `manufacturer_code`, `manufacturer_name`, `manufacturer_short_name`, `used_name_1`, `used_name_2`, `used_name_3`, `create_at`, `updated_at`) VALUES ";

    public static void main(String[] args) throws IOException {
        String fileName = "疫苗数据.xlsx";
        String streetCode = "生产企业信息";
        //读到第几列
        int columnCount = 3;
        String path = "/Users/chenxiaohui/Desktop/疫苗/" + fileName;

        InputStream in = new FileInputStream(new File(path));
        List<List<String>> lines = ExcelImportUtils.readExcel(fileName, in, columnCount, streetCode);

        List<Entity> entities = new ArrayList<>();
        Long idSeed = 1L;
        int count = 0;
        for (List<String> line : lines) {
            if (StringUtils.isEmpty(line.get(1))) {
                continue;
            }
            count++;
            Entity entity = new Entity();
            entity.setId(idSeed);
            entity.setCol1( line.get(1).trim());
            entity.setCol2(line.get(2).trim());
            entity.setCol3(line.get(3).trim());
            entities.add(entity);
            idSeed++;
        }
        System.out.println("共计：" + count);
        List<String> sql = new ArrayList<>();


        List<List<Entity>> entitiesList = Lists.partition(entities, 50);
        for (List<Entity> entities1 : entitiesList) {
            String insert = batchnsertSql(entities1);
            System.out.println(insert);
            sql.add(insert);
        }

        String increment = " ALTER TABLE `db_vaccine`.`vaccine_administrative_division` AUTO_INCREMENT=" + idSeed;
        sql.add(increment);






        writeSqlFile(path, streetCode, sql);
    }

    private static void writeSqlFile(String path,String streetCode, List<String> sql) throws IOException {
        File file = new File(path + (System.currentTimeMillis()) + ".sql");
        file.createNewFile(); // 创建新文件
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            for (String s : sql) {
                out.write(s + "\r\n");
            }
            out.flush();
            out.close();
        }
    }

    public static String batchnsertSql(List<Entity> entities) {
        StringBuilder sb = new StringBuilder();
        sb.append(INSERT_PRE);
        for (Entity entity : entities) {
            sb.append(" (");
            sb.append(entity.getId() + ", '");
            sb.append(entity.getCol1() + "', '");
            sb.append(entity.getCol2() + "', '");
            sb.append(entity.getCol3() + "'");
            sb.append(", NULL, NULL, NULL, now(), now()),");
        }
        String sbStr = sb.substring(0, sb.length() - 1);
        return sbStr + "; ";
    }


    @Data
    static class Entity {
        private Long id;
        private String col1;
        private String col2;
        private String col3;
        private String col4;
        private String col5;
    }
}
