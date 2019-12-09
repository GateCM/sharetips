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
public class Excel2SqlUtils {
    public static final String insertPre = "INSERT INTO `db_vaccine`.`vaccine_administrative_division`(`id`, `code`, `name`, `parent_id`, `parent_code`, `status`, `org_id`, `create_at`, `updated_at`) VALUES ";
    public static final String insertEnd = ", now(), now());";


    public static void main(String[] args) throws IOException {

        String path = "/Users/chenxiaohui/Desktop/疫苗/疫苗初始化/20190603门诊33.xls";

        InputStream in = new FileInputStream(new File(path));
        List<List<String>> lines = ExcelImportUtils.readExcel("20190603门诊33.xls", in, 9, "StreetCode");
        lines.remove(0);
        Map<String, Long> codeIdMap = new HashMap<>();
        List<ad> adList = new ArrayList<>();
        Long idSeed = 1L;
        int count = 0;
        for (List<String> line : lines) {
            if (StringUtils.isEmpty(line.get(1))) {
                continue;
            }
            count++;
            ad ad = new ad();
            ad.setId(idSeed);
            ad.setCode(line.get(1));
            ad.setName(line.get(5));
            ad.setParentCode(line.get(4));
            if(codeIdMap.containsKey(ad.getCode())){
                System.err.println("error");
            }
            ad.setOrgId(line.get(9));
            adList.add(ad);
            codeIdMap.put(ad.getCode(),ad.getId());
            idSeed++;
        }
        System.out.println("共计：" + count);
        //设置parentId
        for (ad ad : adList) {
            Long parentId = codeIdMap.get(ad.getParentCode());
            if(Objects.isNull(parentId)){
                continue;
            }
            ad.setParentId(parentId);
        }
        List<String> sql = new ArrayList<>();
        List<List<ad>> adLists  = Lists.partition(adList,50);
        for (List<ad> ads : adLists) {
           String insert =  batchnsertSql(ads);
            sql.add(insert);
        }

        String increment = " ALTER TABLE `db_vaccine`.`vaccine_administrative_division` AUTO_INCREMENT="+idSeed+";";
        sql.add(increment);


        Excel2SqlCommonUtils.printSql(sql);
        Excel2SqlCommonUtils.writeSqlFile("/Users/chenxiaohui/Desktop/疫苗/疫苗初始化/","db_vaccine.vaccine_administrative_division",sql);
    }

    public static String batchnsertSql(List<ad> adList) {
        StringBuilder sb = new StringBuilder();
        sb.append(insertPre);
        for (ad ad : adList) {
            sb.append(" (");
            sb.append(ad.getId() + ", '");
            sb.append(ad.getCode() + "', '");
            sb.append(ad.getName() + "', ");
            if (!Objects.isNull(ad.getParentId())) {
                sb.append(ad.getParentId() + ", '");
            }else{
                sb.append("null, '");
            }
            sb.append(ad.getParentCode() + "', 1, ");
            if(!StringUtils.isEmpty(ad.getOrgId())) {
                sb.append(ad.getOrgId());
            }else{
                sb.append("NULL");
            }
            sb.append(", now(), now()),");
        }
        String sbStr = sb.substring(0,sb.length()-1);
        return sbStr+"; ";
    }


    public static String insertSql(ad ad) {
        StringBuilder sb = new StringBuilder();
        sb.append(insertPre);
        sb.append(" (");
        sb.append(ad.getId() + ", '");
        sb.append(ad.getCode() + "', '");
        sb.append(ad.getName() + "', ");
        if (!Objects.isNull(ad.getParentId())) {
            sb.append(ad.getParentId() + ", '");
        }else{
            sb.append("null, '");
        }
        sb.append(ad.getParentCode() + "', 1, null");
        sb.append(insertEnd);
        return sb.toString();
    }


    @Data
    static class ad {
        private Long id;
        private String code;
        private String name;
        private String parentCode;
        private Long parentId;
        private String orgId;
    }
}
