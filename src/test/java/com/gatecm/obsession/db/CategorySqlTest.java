package com.gatecm.obsession.db;

import com.gatecm.tip.util.ThreadPoolUtils;
import com.google.common.base.Throwables;

import java.sql.*;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by yaoguang on 2020/2/24 10:20.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class CategorySqlTest {
    private final static String URL = "jdbc:mysql://localhost:3306/db_distributors_platform?characterEncoding=utf8&useSSL=false";
    private final static String USER = "root";
    private final static String PWD = "root";
    private static Statement stmt = null;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql = "SELECT uuid, brand_owner_id, user_org_id, category_id, category_name\n" +
                "\t, brand_id, brand_name, key_words, status, crate_at\n" +
                "\t, update_at\n" +
                "FROM brand_owner_category_info\n" +
                "WHERE brand_owner_id IN (6564749967007496838, 6686118107777152268, 6560122621610668685)\n" +
                "\tAND status = 0";


        CyclicBarrier cyclicBarrier  = new CyclicBarrier(100);

        for (int i = 0; i < 1000; i++) {

            ThreadPoolUtils.getInstance().submitTask(()->{
                Long start;
                Statement stmt2;
                Connection conn;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    //2.获得数据库的连接
                    conn = DriverManager.getConnection(URL, USER, PWD);
                    //3.通过数据库的连接操作数据库，实现增删改查
                    stmt2 = conn.createStatement();
                    cyclicBarrier.await();
                    start = System.currentTimeMillis();
                    ResultSet resultSet  = stmt2.executeQuery(sql);

                } catch (Exception e) {
                    System.out.println("异常"+ Throwables.getStackTraceAsString(e));
                    return;
                }
                Long spend = System.currentTimeMillis()-start;
                System.out.println("spend:"+spend);
                try {
                    stmt2.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
//                if(spend > 100L){
//                    System.out.println("spend:"+spend);
//                }
            });

        }



    }



    private static ResultSet querySql(String sql) throws ClassNotFoundException, SQLException {
        if (stmt == null) {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            //3.通过数据库的连接操作数据库，实现增删改查
            stmt = conn.createStatement();
        }
        return stmt.executeQuery(sql);
    }


}
