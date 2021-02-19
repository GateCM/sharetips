package com.gatecm.tip.util;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.*;

/**
 * Created by yaoguang on 2019/12/10 14:19.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class Test {

    public static void main(String[] args) {
        Set<String> noOperSet = getNoOper("staging_no_operatorId.txt");
        Set<String> noOperSet2 = getNoOper("staging_no_operatorId2.txt");

        // 10007000005-10007147047
        // 10011100982-10011618389
        //
        String start = "10011618389";//10007000005-10011618389
        List<String> idList = new ArrayList<>();
        for (long i = 10007000005L; i <= 10007147047L; i++) {
            if(noOperSet.contains(i+"")){
                continue;
            }
            if(noOperSet2.contains(i+"")){
                continue;
            }
            idList.add(i+"");
        }

//        for (long i = 10011100982L; i <= 10011618389L; i++) {
//            idList.add(i+"");
//        }

        System.out.println(idList.size());

        List<List<String>> lists  = Lists.partition(idList,100000);


        try {
            writeSqlFile("/Users/chenxiaohui/Desktop/","staging_operatorId",lists.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Set<String> getNoOper(String fileName) {
        String noOperatorIdStr = "";
        try {
            String str;
            try (BufferedReader in = new BufferedReader(new FileReader("/Users/chenxiaohui/Desktop/"+fileName))) {
                while ((str = in.readLine()) != null) {
                    noOperatorIdStr += str;
                }
            }

        } catch (IOException e) {
        }
        String[] noOper = noOperatorIdStr.split(",");

        return new HashSet<>(Arrays.asList(noOper));
    }

    public static void writeSqlFile(String filePath, String tableName, List<String> id) throws IOException {
        File file = new File(filePath + tableName + "_"  + ".txt");
        file.createNewFile(); // 创建新文件
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            for (String s : id) {
                out.write(s + ",");
            }
            out.flush();
            out.close();
        }
    }
}
