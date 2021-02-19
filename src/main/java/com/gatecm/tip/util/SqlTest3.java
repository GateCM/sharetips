package com.gatecm.tip.util;

import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
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
public class SqlTest3 {
    private final static String URL = "jdbc:mysql://localhost:3306/db_marketing?characterEncoding=utf8&useSSL=false";
    private final static String USER = "root";
    private final static String PWD = "root";


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        for (int i = 0; i < 10
                ; i++) {
            ThreadPoolUtils.getInstance().submitTask(() -> insertSql());
        }
    }

    private static void insertSql() {
        Statement stmt = null;
        if (stmt == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //2.获得数据库的连接
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL, USER, PWD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //3.通过数据库的连接操作数据库，实现增删改查
            try {
                stmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        String sql = "INSERT INTO `db_marketing`.`marketing_tag_range_3`(`tag_id`, `tag_type`, `type`, `value`, `start_at`, `end_at`, `gmt_create`, `gmt_modified`) VALUES ";

        String sql2 = "({tag_id}, 1, {type}, '{value}', '{start_at}', '{end_at}', now(), now()),";


        int a = 0;
        for (int i = 0; i < 1000; i++) {
            String insert = sql;
            for (int j = 0; j < 1000; j++) {
                insert += sql2.replace("{tag_id}", RandomUtils.nextInt(1, 100)+"").replace("{type}", RandomUtils.nextInt(1, 4)+"").replace("{value}", RandomUtils.nextInt(1, 2000000)+"").replace("{start_at}", "20"+RandomUtils.nextInt(19, 21)+"-"+String.format("%02d",RandomUtils.nextInt(1, 12))+"-"+RandomUtils.nextInt(1, 29)+" 00:00:00").replace("{end_at}","20"+RandomUtils.nextInt(19, 21)+"-"+String.format("%02d",RandomUtils.nextInt(1, 12))+"-"+RandomUtils.nextInt(1, 29)+" 23:59:59");
            }
            insert = insert.substring(0, insert.length() - 1);
            try {
                executeSql(stmt,insert);
                a++;
            } catch (Exception e) {
                System.out.println("创建失败:" + a + e);
            }
            System.out.println(a);

        }
        System.out.println(a);
    }


    private static void executeSql( Statement stmt,String sql){
        try {
            stmt.execute(sql);
        }catch (Exception e){
            System.out.println("错误 "+e.getMessage()+sql);
        }
    }


}
