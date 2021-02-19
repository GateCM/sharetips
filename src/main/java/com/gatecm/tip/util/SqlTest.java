//package com.gatecm.tip.util;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
///**
// * Created by yaoguang on 2020/2/24 10:20.
// * Description:
// *
// * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
// */
//public class SqlTest {
//    private final static String URL = "jdbc:mysql://localhost:3306/db_distributors_platform?characterEncoding=utf8&useSSL=false";
//    private final static String USER = "root";
//    private final static String PWD = "root";
//
//
//    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//        String sql_pre = "INSERT INTO `db_distributors_platform`.`user_brand_dealer_item_63`(`uuid`, `task_id`, `brand_owner_id`, `brander_org_id`, `brander_name`, `shop_id`, `item_id`, `item_name`, `category_id`, `category_name`, `brand_id`, `brand_name`, `target_item_id`, `target_shop_id`, `brand_dealer_id`, `brand_dealer_name`, `status`, `reason`, `operator_id`, `operator_name`, `create_at`, `update_at`) VALUES";
//        String sql_suf = " 100013901, '江苏省南京市玄武区零一有限公司', 123, 2212414, '车车测试分销渠道商品1558669203816', 4633, 'U盘', 7, '索尼', 2212426, 97, 6537510765198782574, '王川科技有限公司', 1, '', 10007293205, '凌霄', '2019-05-24 14:06:22', '2019-05-24 14:06:22'),";
//        String taskId = "6538238611235587071";
//        String brand_owner_id = "653751031694890";
//
//        Random random = new Random(1000);
//
//        String taskId = random.nextInt();;
//
//        String sql = "INSERT INTO `db_distributors_platform`.`user_brand_dealer_item_63`(`uuid`, `task_id`, `brand_owner_id`, `brander_org_id`, `brander_name`, `shop_id`, `item_id`, `item_name`, `category_id`, `category_name`, `brand_id`, `brand_name`, `target_item_id`, `target_shop_id`, `brand_dealer_id`, `brand_dealer_name`, `status`, `reason`, `operator_id`, `operator_name`, `create_at`, `update_at`) VALUES ({uuid}, {task_id}, {brand_owner_id}, 100013901, '江苏省南京市玄武区零一有限公司', 123, 2212414, '车车测试分销渠道商品1558669203816', 4633, 'U盘', 7, '索尼', 2212426, 97, 6537510765198782574, '王川科技有限公司', {status}, '', 10007293205, '凌霄', '{create}', '{update}');";
//
//        List<String> sqls = new ArrayList<>();
//        for (int i = 0; i < 80; i++) {
//            String uuid1 = 8 + String.format("%03d", i);
//            StringBuilder sb = new StringBuilder();
//            sb.append(sql_pre);
//            String boi = brand_owner_id + i;
//            for (int j = 0; j < 100; j++) {
//                sb.append("(" + uuid1 + String.format("%03d", j));
//                sb.append(" ," + taskId);
//                sb.append(" ," + boi);
//                sb.append(" ," + sql_suf);
//            }
//            String sql = sb.toString();
//            String insert = sql.substring(0, sql.length() - 1) + ";";
//
//            try {
//                executeSql(insert);
//            }catch (Exception e){
//
//            }
//        }
//
//    }
//
//    private static void executeSql(String sql) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        //2.获得数据库的连接
//        Connection conn = DriverManager.getConnection(URL, USER, PWD);
//        //3.通过数据库的连接操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();
//        stmt.execute(sql);
//    }
//
//
//}
