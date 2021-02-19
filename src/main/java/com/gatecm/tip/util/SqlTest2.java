package com.gatecm.tip.util;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yaoguang on 2020/2/24 10:20.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class SqlTest2 {
    private final static String URL = "jdbc:mysql://localhost:3306/db_distributors_platform?characterEncoding=utf8&useSSL=false";
    private final static String USER = "root";
    private final static String PWD = "root";
    private static Statement stmt = null;


    public static void main(String[] args) {

        String brandOwnerIdSeed = "564749967007496838";
        ThreadPoolUtils.getInstance().submitTask(() -> insertSql(brandOwnerIdSeed));
    }

    private static void insertSql(String brandOwnerIdSeed) {
        String sql = "INSERT INTO `brand_owner_category_info_id` (`uuid`,`brand_owner_id`,`user_org_id`,`category_id`,`category_name`,`brand_id`,`brand_name`,`key_words`,`status`,`crate_at`,`update_at`) VALUES ";
        String sql2 = "({uuid}, {brandOwnerId},1000627242,5170,'其它油墨',51,'晨光/M&G','',{status},now(),now()),";

        BigDecimal a = BigDecimal.ZERO;
        BigDecimal autoIdSeed = new BigDecimal(brandOwnerIdSeed);
        for (int i = 0; i < 5000; i++) {

            String insert = sql;

            for (int j = 0; j < 100; j++) {

                int rand = RandomUtils.nextInt(0, 25442);

                autoIdSeed = autoIdSeed.add(BigDecimal.ONE);
                String uuid = IdGenerator.get().toLong() + "";
                String brandOwnerId = autoIdSeed.toString();
                if (rand < 1861) {
                    brandOwnerId = "6564749967007496838";
                } else if (rand < 4829) {
                    brandOwnerId = "6560122621610668685";
                }
                insert += sql2.replace("{brandOwnerId}", brandOwnerId).replace("{uuid}", uuid).replace("{status}", (rand > 24416 ? 1 : 0) + "");
            }
            insert = insert.substring(0, insert.length() - 1);
//            System.out.println(insert);
            try {
                executeSql(insert);
            } catch (Exception e) {
                System.out.println("创建失败:" + a + e);
            }

        }
        System.out.println("完成");
    }


    private static void executeSql(String sql) throws ClassNotFoundException, SQLException {
        if (stmt == null) {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            //3.通过数据库的连接操作数据库，实现增删改查
            stmt = conn.createStatement();
        }
        stmt.execute(sql);
    }


}
