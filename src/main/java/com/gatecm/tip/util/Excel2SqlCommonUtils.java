package com.gatecm.tip.util;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yaoguang on 2019/6/19 16:16.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class Excel2SqlCommonUtils {

    /**
     * 有"#"后缀的列名表示该列为字符类型 需要加"'"
     */
    public static final String STRING_FLAG = "#";



    public static void main(String[] args) throws IOException {

        //类目
//        String filePath = "/Users/chenxiaohui/Desktop/疫苗/疫苗初始化/数据源完善.xlsx";
//        String streetCode = "三级类目";
//        String tableName = "db_vaccine.vaccine_category_attach_attributes";
//        exportSql(filePath, fileName, streetCode, tableName, 5,1L);

        //生产企业
        String filePath = "/Users/chenxiaohui/Desktop/疫苗/疫苗初始化/数据源完善.xlsx";
        String streetCode = "生产企业";
        String tableName = "db_vaccine.vaccine_manufacturer";
        exportSql(filePath, streetCode, tableName, 3,1L);
    }

    /**
     * 导出sql
     *
     * @param filePath      文件位置
     * @param streetCode    street名称
     * @param tableName     数据库表名
     * @param readColumnNum 读取列长度
     * @return
     * @date 2019/6/24 14:36
     * @author yaoguang
     * @version 1.0
     * @update: [1][2019/6/24] [yaoguang][创建]
     */
    public static void exportSql(String filePath, String streetCode, String tableName, int readColumnNum,long idSeedStart) throws IOException {
        String[] fileArray = filePath.split("/");
        String fileName = fileArray[fileArray.length - 1];
        filePath = filePath.replace(fileName, "");
        Tuple2<List<ExcelRecord>, List<String>> tuple2 = getExcelRecords(filePath, fileName, readColumnNum, streetCode);
        List<String> sql = buildSql(tuple2.getT1(),tuple2.getT2(), tableName,idSeedStart);
        //打印测试
        printSql(sql);
        writeSqlFile(filePath, tableName, sql);
    }

    public static void printSql(List<String> sql) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for (String insert : sql) {
            System.err.println(insert);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static List<String> buildSql(List<ExcelRecord> recordList, List<String> columnNames,String tableName, long idSeedStart) {
        String insertPre = buildInsertPreString(columnNames,tableName);
        List<String> sql = new ArrayList<>();
        List<List<ExcelRecord>> recordListList = Lists.partition(recordList, 50);
        if (idSeedStart == 1L) {
            String delTable = "DELETE FROM " + tableName + ";";
            sql.add(delTable);
        }
        Long currentId = idSeedStart;
        for (List<ExcelRecord> records : recordListList) {
            Tuple2<String, Long> tuple2 = batchInsertSql(insertPre, records,currentId);
            sql.add(tuple2.getT1());
            currentId = tuple2.getT2();
        }
        String increment = "ALTER TABLE " + tableName + " AUTO_INCREMENT=" + currentId + ";";
        sql.add(increment);
        return sql;
    }

    private static String buildInsertPreString(List<String> columnNames, String tableName) {
        StringBuilder sb = new StringBuilder("INSERT INTO ");
        sb.append(tableName);
        sb.append("(id,");
        sb.append(org.apache.commons.lang3.StringUtils.join(columnNames, ","));
        sb.append(") VALUES ");
        return sb.toString();
    }


    public static Tuple2<String,Long> batchInsertSql(String insertPre, List<ExcelRecord> records,Long currentId) {
        StringBuilder sb = new StringBuilder(insertPre);

        for (ExcelRecord record : records) {
            sb.append("(");
            sb.append(currentId + ", ");
            sb.append(org.apache.commons.lang3.StringUtils.join(record.getValues(), ","));
            sb.append("),");
            currentId++;
        }
        String sbStr = sb.substring(0, sb.length() - 1);
        String insertSql =  sbStr + "; ";
        return new Tuple2<>(insertSql,currentId);
    }

    private static Tuple2<List<ExcelRecord>, List<String>> getExcelRecords(String filePath, String fileName, int readColumnNum, String streetCode) throws FileNotFoundException {
        InputStream in = new FileInputStream(new File(filePath + fileName));
        List<List<String>> lines = ExcelImportUtils.readExcel(fileName, in, readColumnNum, streetCode);
        if (CollectionUtils.isEmpty(lines)) {
            throw new RuntimeException("excel无数据");
        }
        //第一条记录为列定义
        List<String> columnList = lines.get(0);
        int columnSize = columnList.size();
        Set<Integer> columnString = new HashSet<>();
        List<String> columnNames = new ArrayList<>(columnSize - 1);
        //第一列为excel序号，跳过
        for (int i = 1; i < columnSize; i++) {
            String col = columnList.get(i);
            if (StringUtils.isEmpty(col)) {
                throw new RuntimeException("excel第一列对应数据库列，不能为空");
            }
            col = col.trim();
            //字符串列以 # 结尾
            if (col.endsWith(STRING_FLAG)) {
                columnString.add(i);
                columnNames.add(col.replace(STRING_FLAG, ""));
                continue;
            }
            columnNames.add(col);
        }
        List<ExcelRecord> recordList = new ArrayList<>();
        for (int i = 1, len = lines.size(); i < len; i++) {
            ExcelRecord record = new ExcelRecord();
            for (int j = 1; j < columnSize; j++) {
                if (columnString.contains(j)) {
                    record.addStr(lines.get(i).get(j));
                    continue;
                }
                record.add(lines.get(i).get(j));
            }
            recordList.add(record);
        }

        int allNum = recordList.size();
        recordList = distinctRecord(recordList);
//        recordList.sort(ExcelRecord::compareTo);
        System.err.println("Excel记录数：" + (lines.size() - 1) + ", 转换记录数：" + allNum + ", 去重后记录数：" + recordList.size());
        return new Tuple2(recordList, columnNames);
    }

    /**
     * 记录去重，需要根据业务具体实现
     *
     * @param recordList
     * @return
     * @date 2019/6/24 12:01
     * @author yaoguang
     * @version 1.0
     * @update: [1][2019/6/24] [yaoguang][创建]
     */
    private static List<ExcelRecord> distinctRecord(List<ExcelRecord> recordList) {
        recordList = recordList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(x -> x.getValues().get(0)))), ArrayList::new));
        return recordList;
    }

    public static void writeSqlFile(String filePath, String tableName, List<String> sql) throws IOException {
        File file = new File(filePath + tableName + "_" + (System.currentTimeMillis()) + ".sql");
        file.createNewFile(); // 创建新文件
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            for (String s : sql) {
                out.write(s + "\r\n");
            }
            out.flush();
            out.close();
        }
    }


    @Data
    static class ExcelRecord implements Comparable<ExcelRecord> {
        public static final int INDEX = 0;
        private List<String> values = new ArrayList<>();

        public void add(String value) {
            values.add(value);
        }

        public void addStr(String value) {
            values.add("'" + value + "'");
        }

        @Override
        public int compareTo(ExcelRecord o) {
            Long num1 = Long.valueOf(values.get(INDEX).replace("'", ""));
            Long num2 = Long.valueOf(o.getValues().get(INDEX).replace("'", ""));
            return num1.compareTo(num2);
        }
    }


    @Data
    @AllArgsConstructor
    static class Tuple2<T1, T2>{
        final T1 t1;
        final T2 t2;
    }

}
