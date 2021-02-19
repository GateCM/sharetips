package com.gatecm.tip.util;

import java.io.*;
import java.util.*;

/**
 * Created by yaoguang on 2019/12/10 14:19.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class Test2 {

    public static void main(String[] args) {
        Set<String> operSet = getNoOper("full-operatorId.txt");
        Set<String> noOperSet = getNoOper2("full_unOper.txt");
        List<String> idList = new ArrayList<>();
        for (String s : operSet) {
            if(noOperSet.contains(s)){
                continue;
            }
            idList.add(s);
        }

        try {
            writeSqlFile("/Users/chenxiaohui/Desktop/", "full_operatorId", idList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static Set<String> getNoOper2(String fileName) {
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

    private static Set<String> getNoOper(String fileName) {
        Set<String> a = new HashSet<>();
        try {
            String str;
            try (BufferedReader in = new BufferedReader(new FileReader("/Users/chenxiaohui/Desktop/" + fileName))) {
                while ((str = in.readLine()) != null) {
                    a.add(str);
                }
            }

        } catch (IOException e) {
        }

        return a;
    }

    public static void writeSqlFile(String filePath, String tableName, List<String> id) throws IOException {
        File file = new File(filePath + tableName + "_" + ".txt");
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
