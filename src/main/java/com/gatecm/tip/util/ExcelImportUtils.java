package com.gatecm.tip.util;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenxiaohui
 * @Description: TODO()
 * @date 2018年1月17日 上午10:13:22
 */
@Slf4j
public class ExcelImportUtils {

    private static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    private static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";


    public ExcelImportUtils() {
    }

    public static List<List<String>> readExcel(String fileName, InputStream is, int columnCnt, String sheetName) {
        if (StringUtils.isEmpty(fileName)) {
            return null;
        } else {
            String postfix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!StringUtils.isEmpty(postfix)) {
                try {
                    if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                        return readXls(is, columnCnt, Boolean.FALSE, sheetName);
                    }

                    if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                        return readXlsx(is, columnCnt, Boolean.FALSE, sheetName);
                    }
                } catch (Exception var5) {
                    log.error("excel file({}) read error. cause:{}", fileName, Throwables.getStackTraceAsString(var5));
                }
            } else {
                log.info("invalid file name {}.", fileName);
            }

            return null;
        }
    }


    private static List<List<String>> readXlsx(InputStream is, int columnCnt, boolean isSingle, String sheetName) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<List<String>> list = new ArrayList();

        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); ++numSheet) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            //只读取指定名字的sheet页
            if (xssfSheet != null && xssfSheet.getSheetName().equals(sheetName)) {
                for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); ++rowNum) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        List<String> line = new ArrayList();
                        if (isSingle) {
                            line.add(getValue(xssfRow.getCell(columnCnt)));
                        } else {
                            if (columnCnt < 0) {
                                columnCnt = xssfRow.getLastCellNum();
                            }

                            line.add(String.valueOf(rowNum));

                            for (int i = 0; i < columnCnt; ++i) {
                                line.add(getValue(xssfRow.getCell(i)));
                            }
                        }

                        if (!line.isEmpty()) {
                            list.add(line);
                        }
                    }
                }
            }
        }

        return list;
    }

    private static List<List<String>> readXls(InputStream is, int columnCnt, boolean isSingle, String sheetName) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<List<String>> list = new ArrayList();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); ++numSheet) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            //只读取指定名字的sheet页
            if (hssfSheet != null && hssfSheet.getSheetName().equals(sheetName)) {
                for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); ++rowNum) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        List<String> line = new ArrayList();
                        if (!isSingle) {
                            if (columnCnt < 0) {
                                columnCnt = hssfRow.getLastCellNum();
                            }

                            line.add(String.valueOf(rowNum));

                            for (int i = 0; i < columnCnt; ++i) {
                                line.add(getValue(hssfRow.getCell(i)));
                            }
                        } else {
                            line.add(getValue(hssfRow.getCell(columnCnt)));
                        }

                        if (!line.isEmpty()) {
                            list.add(line);
                        }
                    }
                }
            }
        }

        return list;
    }


    private static String getValue(XSSFCell cell) {
        if (cell == null) {
            return "";
        } else {
            String strCell = null;
            switch (cell.getCellType()) {
                case 0:
                    strCell = judgeDateOrNum(cell);
                    break;
                case 4:
                    strCell = String.valueOf(cell.getBooleanCellValue());
                    break;
                default:
                    strCell = String.valueOf(cell.getStringCellValue());
            }

            return strCell.equals("") ? "" : strCell.trim();
        }
    }

    private static String getValue(HSSFCell cell) {
        if (cell == null) {
            return "";
        } else {
            String strCell = "";
            switch (cell.getCellType()) {
                case 0:
                    strCell = judgeDateOrNum(cell);
                    break;
                case 4:
                    strCell = String.valueOf(cell.getBooleanCellValue());
                    break;
                default:
                    strCell = String.valueOf(cell.getStringCellValue());
            }

            return strCell.equals("") ? "" : strCell.trim();
        }
    }


    private static String judgeDateOrNum(Cell cell) {
        DecimalFormat df;
        if (HSSFDateUtil.isCellDateFormatted(cell)) {
            df = null;
            SimpleDateFormat sdf;
            if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                sdf = new SimpleDateFormat("HH:mm");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }

            Date date = cell.getDateCellValue();
            return sdf.format(date);
        } else {
            df = new DecimalFormat("#.######");
            return df.format(cell.getNumericCellValue());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        String path = "/Users/chenxiaohui/Desktop/疫苗/20180123门诊33.xls";

        InputStream in = new FileInputStream(new File(path));
        List<List<String>> lines = ExcelImportUtils.readExcel("20180123门诊33.xls", in, 7, "StreetCode");


        System.out.println(lines);

    }
}
