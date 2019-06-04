package com.gatecm.obsession.TEMP;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaoguang on 2019/3/26 10:28.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class DistrictUtil {

    public static void main(String[] args) {
        String result = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"message\": \"成功！\",\n" +
                "    \"success\": true,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"954\",\n" +
                "            \"code\": \"330100\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"杭州市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"955\",\n" +
                "                    \"code\": \"330102\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"上城区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"956\",\n" +
                "                    \"code\": \"330103\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"下城区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"957\",\n" +
                "                    \"code\": \"330104\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"江干区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"958\",\n" +
                "                    \"code\": \"330105\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"拱墅区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"959\",\n" +
                "                    \"code\": \"330106\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"西湖区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"960\",\n" +
                "                    \"code\": \"330108\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"滨江区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"961\",\n" +
                "                    \"code\": \"330109\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"萧山区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"962\",\n" +
                "                    \"code\": \"330110\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"余杭区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4021\",\n" +
                "                    \"code\": \"330113\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"临平工业园区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10052\",\n" +
                "                    \"code\": \"330116\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"西湖名胜区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10040\",\n" +
                "                    \"code\": \"330117\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"杭州经济开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10018\",\n" +
                "                    \"code\": \"330118\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"大江东区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"963\",\n" +
                "                    \"code\": \"330122\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"桐庐县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"964\",\n" +
                "                    \"code\": \"330127\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"淳安县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"965\",\n" +
                "                    \"code\": \"330182\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"建德市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10043\",\n" +
                "                    \"code\": \"330183\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"富阳区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10051\",\n" +
                "                    \"code\": \"330185\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"临安区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4001\",\n" +
                "                    \"code\": \"330196\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"钱江开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10057\",\n" +
                "                    \"code\": \"330197\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"西湖风景名胜区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10050\",\n" +
                "                    \"code\": \"330198\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"杭州开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10044\",\n" +
                "                    \"code\": \"330199\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"杭州市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"968\",\n" +
                "            \"code\": \"330200\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"宁波市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"969\",\n" +
                "                    \"code\": \"330203\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"海曙区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"970\",\n" +
                "                    \"code\": \"330204\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"江东区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"971\",\n" +
                "                    \"code\": \"330205\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"江北区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"972\",\n" +
                "                    \"code\": \"330206\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"北仑区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"973\",\n" +
                "                    \"code\": \"330211\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"镇海区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"974\",\n" +
                "                    \"code\": \"330212\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"鄞州区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"975\",\n" +
                "                    \"code\": \"330225\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"象山县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"976\",\n" +
                "                    \"code\": \"330226\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"宁海县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"977\",\n" +
                "                    \"code\": \"330281\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"余姚市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"978\",\n" +
                "                    \"code\": \"330282\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"慈溪市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10061\",\n" +
                "                    \"code\": \"330283\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"奉化区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10030\",\n" +
                "                    \"code\": \"330293\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"国家高新技术产业开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4004\",\n" +
                "                    \"code\": \"330294\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"东钱湖区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4005\",\n" +
                "                    \"code\": \"330295\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"杭州湾新区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10039\",\n" +
                "                    \"code\": \"330296\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"保税区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4007\",\n" +
                "                    \"code\": \"330297\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"大榭开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4008\",\n" +
                "                    \"code\": \"330298\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"宁波开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4009\",\n" +
                "                    \"code\": \"330299\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"宁波市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"10027\",\n" +
                "            \"code\": \"330300\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"温州市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"981\",\n" +
                "                    \"code\": \"330302\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"鹿城区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10020\",\n" +
                "                    \"code\": \"330303\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"龙湾区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"983\",\n" +
                "                    \"code\": \"330304\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"瓯海区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10033\",\n" +
                "                    \"code\": \"330316\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"温州开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10058\",\n" +
                "                    \"code\": \"330317\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"瓯江口产业聚集区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10072\",\n" +
                "                    \"code\": \"330318\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"温州生态园区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10055\",\n" +
                "                    \"code\": \"330319\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"温州浙南科技城\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10002\",\n" +
                "                    \"code\": \"330322\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"洞头区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"985\",\n" +
                "                    \"code\": \"330324\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"永嘉县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"986\",\n" +
                "                    \"code\": \"330326\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"平阳县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"987\",\n" +
                "                    \"code\": \"330327\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"苍南县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"988\",\n" +
                "                    \"code\": \"330328\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"文成县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"989\",\n" +
                "                    \"code\": \"330329\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"泰顺县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"990\",\n" +
                "                    \"code\": \"330381\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"瑞安市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"991\",\n" +
                "                    \"code\": \"330382\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"乐清市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10031\",\n" +
                "                    \"code\": \"330398\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"（老）温州开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4011\",\n" +
                "                    \"code\": \"330399\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"温州市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"992\",\n" +
                "            \"code\": \"330400\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"嘉兴市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"10053\",\n" +
                "                    \"code\": \"330402\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"南湖区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"994\",\n" +
                "                    \"code\": \"330411\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"秀洲区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10019\",\n" +
                "                    \"code\": \"330418\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嘉兴开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10066\",\n" +
                "                    \"code\": \"330419\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嘉兴港区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10078\",\n" +
                "                    \"code\": \"330420\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嘉兴港区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"995\",\n" +
                "                    \"code\": \"330421\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嘉善县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"996\",\n" +
                "                    \"code\": \"330424\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"海盐县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"997\",\n" +
                "                    \"code\": \"330481\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"海宁市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"998\",\n" +
                "                    \"code\": \"330482\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"平湖市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"999\",\n" +
                "                    \"code\": \"330483\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"桐乡市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10004\",\n" +
                "                    \"code\": \"330498\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嘉兴开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4013\",\n" +
                "                    \"code\": \"330499\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嘉兴市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1000\",\n" +
                "            \"code\": \"330500\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"湖州市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1001\",\n" +
                "                    \"code\": \"330502\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"吴兴区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1002\",\n" +
                "                    \"code\": \"330503\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"南浔区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10071\",\n" +
                "                    \"code\": \"330518\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"湖州度假区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1003\",\n" +
                "                    \"code\": \"330521\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"德清县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1004\",\n" +
                "                    \"code\": \"330522\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"长兴县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1005\",\n" +
                "                    \"code\": \"330523\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"安吉县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4014\",\n" +
                "                    \"code\": \"330598\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"湖州开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4025\",\n" +
                "                    \"code\": \"330599\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"湖州市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1006\",\n" +
                "            \"code\": \"330600\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"绍兴市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1007\",\n" +
                "                    \"code\": \"330602\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"越城区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10069\",\n" +
                "                    \"code\": \"330603\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"柯桥区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10074\",\n" +
                "                    \"code\": \"330618\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"滨海区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1009\",\n" +
                "                    \"code\": \"330624\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"新昌县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1010\",\n" +
                "                    \"code\": \"330681\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"诸暨市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10017\",\n" +
                "                    \"code\": \"330682\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"上虞区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1012\",\n" +
                "                    \"code\": \"330683\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嵊州市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4015\",\n" +
                "                    \"code\": \"330699\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"绍兴市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1013\",\n" +
                "            \"code\": \"330700\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"金华市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1014\",\n" +
                "                    \"code\": \"330702\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"婺城区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1015\",\n" +
                "                    \"code\": \"330703\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"金东区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10005\",\n" +
                "                    \"code\": \"330716\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"金义都市新区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10062\",\n" +
                "                    \"code\": \"330717\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"金华山\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1016\",\n" +
                "                    \"code\": \"330723\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"武义县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1017\",\n" +
                "                    \"code\": \"330726\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"浦江县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1018\",\n" +
                "                    \"code\": \"330727\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"磐安县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1019\",\n" +
                "                    \"code\": \"330781\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"兰溪市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1020\",\n" +
                "                    \"code\": \"330782\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"义乌市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1021\",\n" +
                "                    \"code\": \"330783\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"东阳市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1022\",\n" +
                "                    \"code\": \"330784\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"永康市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4016\",\n" +
                "                    \"code\": \"330798\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"金华开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4017\",\n" +
                "                    \"code\": \"330799\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"金华市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1023\",\n" +
                "            \"code\": \"330800\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"衢州市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1024\",\n" +
                "                    \"code\": \"330802\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"柯城区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1025\",\n" +
                "                    \"code\": \"330803\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"衢江区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1026\",\n" +
                "                    \"code\": \"330822\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"常山县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1027\",\n" +
                "                    \"code\": \"330824\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"开化县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1028\",\n" +
                "                    \"code\": \"330825\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"龙游县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1029\",\n" +
                "                    \"code\": \"330881\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"江山市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10025\",\n" +
                "                    \"code\": \"330882\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"衢州绿色产业区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4018\",\n" +
                "                    \"code\": \"330899\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"衢州市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1030\",\n" +
                "            \"code\": \"330900\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"舟山市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1031\",\n" +
                "                    \"code\": \"330902\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"定海区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1032\",\n" +
                "                    \"code\": \"330903\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"普陀区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1033\",\n" +
                "                    \"code\": \"330921\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"岱山县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1034\",\n" +
                "                    \"code\": \"330922\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"嵊泗县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10046\",\n" +
                "                    \"code\": \"330950\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"海洋产业集聚区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10007\",\n" +
                "                    \"code\": \"330951\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"舟山群岛新区普陀山－朱家尖管理委员会\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10073\",\n" +
                "                    \"code\": \"330952\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"舟山群岛新区新城管理委员会\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4019\",\n" +
                "                    \"code\": \"330999\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"舟山市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1035\",\n" +
                "            \"code\": \"331000\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"台州市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1036\",\n" +
                "                    \"code\": \"331002\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"椒江区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1037\",\n" +
                "                    \"code\": \"331003\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"黄岩区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1038\",\n" +
                "                    \"code\": \"331004\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"路桥区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1039\",\n" +
                "                    \"code\": \"331021\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"玉环市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1040\",\n" +
                "                    \"code\": \"331022\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"三门县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1041\",\n" +
                "                    \"code\": \"331023\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"天台县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1042\",\n" +
                "                    \"code\": \"331024\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"仙居县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1043\",\n" +
                "                    \"code\": \"331081\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"温岭市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1044\",\n" +
                "                    \"code\": \"331082\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"临海市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10047\",\n" +
                "                    \"code\": \"331099\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"台州市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1045\",\n" +
                "            \"code\": \"331100\",\n" +
                "            \"isLeaf\": false,\n" +
                "            \"name\": \"丽水市\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": \"1046\",\n" +
                "                    \"code\": \"331102\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"莲都区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"10024\",\n" +
                "                    \"code\": \"331103\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"丽水开发区\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1047\",\n" +
                "                    \"code\": \"331121\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"青田县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1048\",\n" +
                "                    \"code\": \"331122\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"缙云县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1049\",\n" +
                "                    \"code\": \"331123\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"遂昌县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1050\",\n" +
                "                    \"code\": \"331124\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"松阳县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1051\",\n" +
                "                    \"code\": \"331125\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"云和县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1052\",\n" +
                "                    \"code\": \"331126\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"庆元县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1053\",\n" +
                "                    \"code\": \"331127\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"景宁畲族自治县\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"1054\",\n" +
                "                    \"code\": \"331181\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"龙泉市\",\n" +
                "                    \"children\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"4026\",\n" +
                "                    \"code\": \"331199\",\n" +
                "                    \"isLeaf\": true,\n" +
                "                    \"name\": \"丽水市本级\",\n" +
                "                    \"children\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"10065\",\n" +
                "            \"code\": \"339900\",\n" +
                "            \"isLeaf\": true,\n" +
                "            \"name\": \"浙江省本级\",\n" +
                "            \"children\": null\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        List<String> city = new ArrayList<>();
        city.add("绍兴市");
        city.add("台州市");
        city.add("温州市");
        city.add("金华市");
        city.add("丽水市");
        city.add("衢州市");
        List<AdDistrictInfo> adDistrictInfos = JSON.parseArray(JSON.parseObject(result).getString("data"), AdDistrictInfo.class);
        Map<String, String> govAllMap = parse(city, adDistrictInfos);

//        System.out.println(districtAllMap.values());


        String zhengqiqu = "{\"code\":\"0\",\"message\":\"成功！\",\"success\":true,\"data\":[{\"id\":\"10026\",\"code\":\"900099\",\"isLeaf\":true,\"name\":\"政企区本级\",\"children\":null},{\"id\":\"10003\",\"code\":\"900100\",\"isLeaf\":false,\"name\":\"湖州市政企区\",\"children\":[{\"id\":\"11712\",\"code\":\"900101\",\"isLeaf\":true,\"name\":\"吴兴区政企区\",\"children\":null},{\"id\":\"10075\",\"code\":\"900102\",\"isLeaf\":true,\"name\":\"德清县政企区\",\"children\":null},{\"id\":\"11713\",\"code\":\"900103\",\"isLeaf\":true,\"name\":\"南浔区政企区\",\"children\":null},{\"id\":\"11714\",\"code\":\"900104\",\"isLeaf\":true,\"name\":\"安吉县政企区\",\"children\":null},{\"id\":\"11715\",\"code\":\"900105\",\"isLeaf\":true,\"name\":\"长兴县政企区\",\"children\":null},{\"id\":\"11716\",\"code\":\"900106\",\"isLeaf\":true,\"name\":\"湖州开发区政企区\",\"children\":null},{\"id\":\"11717\",\"code\":\"900107\",\"isLeaf\":true,\"name\":\"湖州度假区政企区\",\"children\":null},{\"id\":\"11711\",\"code\":\"900199\",\"isLeaf\":true,\"name\":\"湖州市本级政企区\",\"children\":null}]},{\"id\":\"10077\",\"code\":\"900200\",\"isLeaf\":false,\"name\":\"丽水市政企区\",\"children\":[{\"id\":\"11766\",\"code\":\"900201\",\"isLeaf\":true,\"name\":\"莲都区政企区\",\"children\":null},{\"id\":\"10048\",\"code\":\"900202\",\"isLeaf\":true,\"name\":\"云和县政企区\",\"children\":null},{\"id\":\"11767\",\"code\":\"900203\",\"isLeaf\":true,\"name\":\"龙泉市政企区\",\"children\":null},{\"id\":\"11768\",\"code\":\"900204\",\"isLeaf\":true,\"name\":\"青田县政企区\",\"children\":null},{\"id\":\"11769\",\"code\":\"900205\",\"isLeaf\":true,\"name\":\"庆元县政企区\",\"children\":null},{\"id\":\"11770\",\"code\":\"900206\",\"isLeaf\":true,\"name\":\"缙云县政企区\",\"children\":null},{\"id\":\"11771\",\"code\":\"900207\",\"isLeaf\":true,\"name\":\"遂昌县政企区\",\"children\":null},{\"id\":\"11772\",\"code\":\"900208\",\"isLeaf\":true,\"name\":\"松阳县政企区\",\"children\":null},{\"id\":\"11773\",\"code\":\"900209\",\"isLeaf\":true,\"name\":\"景宁县政企区\",\"children\":null},{\"id\":\"11774\",\"code\":\"900210\",\"isLeaf\":true,\"name\":\"丽水开发区政企区\",\"children\":null},{\"id\":\"11765\",\"code\":\"900299\",\"isLeaf\":true,\"name\":\"丽水市本级政企区\",\"children\":null}]},{\"id\":\"10060\",\"code\":\"900300\",\"isLeaf\":false,\"name\":\"杭州市政企区\",\"children\":[{\"id\":\"11673\",\"code\":\"900301\",\"isLeaf\":true,\"name\":\"江干区政企区\",\"children\":null},{\"id\":\"10016\",\"code\":\"900302\",\"isLeaf\":true,\"name\":\"临安市政企区\",\"children\":null},{\"id\":\"11674\",\"code\":\"900303\",\"isLeaf\":true,\"name\":\"下城区政企区\",\"children\":null},{\"id\":\"11675\",\"code\":\"900304\",\"isLeaf\":true,\"name\":\"上城区政企区\",\"children\":null},{\"id\":\"11676\",\"code\":\"900305\",\"isLeaf\":true,\"name\":\"西湖区政企区\",\"children\":null},{\"id\":\"11677\",\"code\":\"900306\",\"isLeaf\":true,\"name\":\"拱墅区政企区\",\"children\":null},{\"id\":\"11678\",\"code\":\"900307\",\"isLeaf\":true,\"name\":\"滨江区政企区\",\"children\":null},{\"id\":\"11679\",\"code\":\"900308\",\"isLeaf\":true,\"name\":\"萧山区政企区\",\"children\":null},{\"id\":\"11680\",\"code\":\"900309\",\"isLeaf\":true,\"name\":\"余杭区政企区\",\"children\":null},{\"id\":\"11681\",\"code\":\"900310\",\"isLeaf\":true,\"name\":\"富阳区政企区\",\"children\":null},{\"id\":\"11682\",\"code\":\"900311\",\"isLeaf\":true,\"name\":\"桐庐县政企区\",\"children\":null},{\"id\":\"11683\",\"code\":\"900312\",\"isLeaf\":true,\"name\":\"建德市政企区\",\"children\":null},{\"id\":\"11684\",\"code\":\"900313\",\"isLeaf\":true,\"name\":\"淳安县政企区\",\"children\":null},{\"id\":\"11685\",\"code\":\"900314\",\"isLeaf\":true,\"name\":\"西湖名胜区政企区\",\"children\":null},{\"id\":\"11686\",\"code\":\"900315\",\"isLeaf\":true,\"name\":\"杭州开发区政企区\",\"children\":null},{\"id\":\"11687\",\"code\":\"900316\",\"isLeaf\":true,\"name\":\"大江东区政企区\",\"children\":null},{\"id\":\"11672\",\"code\":\"900399\",\"isLeaf\":true,\"name\":\"杭州市本级政企区\",\"children\":null}]},{\"id\":\"10036\",\"code\":\"900400\",\"isLeaf\":false,\"name\":\"温州市政企区\",\"children\":[{\"id\":\"10401\",\"code\":\"900401\",\"isLeaf\":true,\"name\":\"龙湾区政企区\",\"children\":null},{\"id\":\"10402\",\"code\":\"900402\",\"isLeaf\":true,\"name\":\"温州开发区政企区\",\"children\":null},{\"id\":\"11688\",\"code\":\"900403\",\"isLeaf\":true,\"name\":\"鹿城区政企区\",\"children\":null},{\"id\":\"11689\",\"code\":\"900404\",\"isLeaf\":true,\"name\":\"瓯海区政企区\",\"children\":null},{\"id\":\"11690\",\"code\":\"900405\",\"isLeaf\":true,\"name\":\"洞头区政企区\",\"children\":null},{\"id\":\"11691\",\"code\":\"900406\",\"isLeaf\":true,\"name\":\"乐清市政企区\",\"children\":null},{\"id\":\"11692\",\"code\":\"900407\",\"isLeaf\":true,\"name\":\"瑞安市政企区\",\"children\":null},{\"id\":\"11693\",\"code\":\"900408\",\"isLeaf\":true,\"name\":\"永嘉县政企区\",\"children\":null},{\"id\":\"11694\",\"code\":\"900409\",\"isLeaf\":true,\"name\":\"平阳县政企区\",\"children\":null},{\"id\":\"11695\",\"code\":\"900410\",\"isLeaf\":true,\"name\":\"苍南县政企区\",\"children\":null},{\"id\":\"11696\",\"code\":\"900411\",\"isLeaf\":true,\"name\":\"文成县政企区\",\"children\":null},{\"id\":\"11697\",\"code\":\"900412\",\"isLeaf\":true,\"name\":\"泰顺县政企区\",\"children\":null},{\"id\":\"11698\",\"code\":\"900413\",\"isLeaf\":true,\"name\":\"瓯江口产业聚集区政企区\",\"children\":null},{\"id\":\"13201\",\"code\":\"900414\",\"isLeaf\":true,\"name\":\"温州生态园区政企区\",\"children\":null},{\"id\":\"13202\",\"code\":\"900415\",\"isLeaf\":true,\"name\":\"温州浙南科技城政企区\",\"children\":null},{\"id\":\"13203\",\"code\":\"900416\",\"isLeaf\":true,\"name\":\"温州市本级卫计系统\",\"children\":null},{\"id\":\"10068\",\"code\":\"900499\",\"isLeaf\":true,\"name\":\"温州市本级政企区\",\"children\":null}]},{\"id\":\"11241\",\"code\":\"900500\",\"isLeaf\":false,\"name\":\"嘉兴市政企区\",\"children\":[{\"id\":\"11702\",\"code\":\"900501\",\"isLeaf\":true,\"name\":\"南湖区政企区\",\"children\":null},{\"id\":\"11703\",\"code\":\"900502\",\"isLeaf\":true,\"name\":\"秀洲区政企区\",\"children\":null},{\"id\":\"11704\",\"code\":\"900503\",\"isLeaf\":true,\"name\":\"海宁市政企区\",\"children\":null},{\"id\":\"11705\",\"code\":\"900504\",\"isLeaf\":true,\"name\":\"平湖市政企区\",\"children\":null},{\"id\":\"11706\",\"code\":\"900505\",\"isLeaf\":true,\"name\":\"桐乡市政企区\",\"children\":null},{\"id\":\"11707\",\"code\":\"900506\",\"isLeaf\":true,\"name\":\"嘉善县政企区\",\"children\":null},{\"id\":\"11708\",\"code\":\"900507\",\"isLeaf\":true,\"name\":\"海盐县政企区\",\"children\":null},{\"id\":\"11709\",\"code\":\"900508\",\"isLeaf\":true,\"name\":\"嘉兴开发区政企区\",\"children\":null},{\"id\":\"11710\",\"code\":\"900509\",\"isLeaf\":true,\"name\":\"嘉兴港区政企区\",\"children\":null},{\"id\":\"11701\",\"code\":\"900599\",\"isLeaf\":true,\"name\":\"嘉兴市本级政企区\",\"children\":null}]},{\"id\":\"11242\",\"code\":\"900600\",\"isLeaf\":false,\"name\":\"绍兴市政企区\",\"children\":[{\"id\":\"11719\",\"code\":\"900601\",\"isLeaf\":true,\"name\":\"越城区政企区\",\"children\":null},{\"id\":\"11720\",\"code\":\"900602\",\"isLeaf\":true,\"name\":\"柯桥区政企区\",\"children\":null},{\"id\":\"11721\",\"code\":\"900603\",\"isLeaf\":true,\"name\":\"上虞区政企区\",\"children\":null},{\"id\":\"11722\",\"code\":\"900604\",\"isLeaf\":true,\"name\":\"诸暨市政企区\",\"children\":null},{\"id\":\"11723\",\"code\":\"900605\",\"isLeaf\":true,\"name\":\"嵊州市政企区\",\"children\":null},{\"id\":\"11724\",\"code\":\"900606\",\"isLeaf\":true,\"name\":\"新昌县政企区\",\"children\":null},{\"id\":\"11725\",\"code\":\"900607\",\"isLeaf\":true,\"name\":\"滨海区政企区\",\"children\":null},{\"id\":\"11718\",\"code\":\"900699\",\"isLeaf\":true,\"name\":\"绍兴市本级政企区\",\"children\":null}]},{\"id\":\"11243\",\"code\":\"900700\",\"isLeaf\":false,\"name\":\"金华市政企区\",\"children\":[{\"id\":\"11727\",\"code\":\"900701\",\"isLeaf\":true,\"name\":\"婺城区政企区\",\"children\":null},{\"id\":\"11728\",\"code\":\"900702\",\"isLeaf\":true,\"name\":\"金东区政企区\",\"children\":null},{\"id\":\"11729\",\"code\":\"900703\",\"isLeaf\":true,\"name\":\"兰溪市政企区\",\"children\":null},{\"id\":\"11730\",\"code\":\"900704\",\"isLeaf\":true,\"name\":\"东阳市政企区\",\"children\":null},{\"id\":\"11731\",\"code\":\"900705\",\"isLeaf\":true,\"name\":\"义乌市政企区\",\"children\":null},{\"id\":\"11732\",\"code\":\"900706\",\"isLeaf\":true,\"name\":\"永康市政企区\",\"children\":null},{\"id\":\"11733\",\"code\":\"900707\",\"isLeaf\":true,\"name\":\"浦江县政企区\",\"children\":null},{\"id\":\"11734\",\"code\":\"900708\",\"isLeaf\":true,\"name\":\"武义县政企区\",\"children\":null},{\"id\":\"11735\",\"code\":\"900709\",\"isLeaf\":true,\"name\":\"磐安县政企区\",\"children\":null},{\"id\":\"11736\",\"code\":\"900710\",\"isLeaf\":true,\"name\":\"金义都市新区政企区\",\"children\":null},{\"id\":\"11737\",\"code\":\"900711\",\"isLeaf\":true,\"name\":\"金华山政企区\",\"children\":null},{\"id\":\"11738\",\"code\":\"900712\",\"isLeaf\":true,\"name\":\"金华开发区政企区\",\"children\":null},{\"id\":\"11726\",\"code\":\"900799\",\"isLeaf\":true,\"name\":\"金华市本级政企区\",\"children\":null}]},{\"id\":\"11244\",\"code\":\"900800\",\"isLeaf\":false,\"name\":\"舟山市政企区\",\"children\":[{\"id\":\"11740\",\"code\":\"900801\",\"isLeaf\":true,\"name\":\"定海区政企区\",\"children\":null},{\"id\":\"11741\",\"code\":\"900802\",\"isLeaf\":true,\"name\":\"普陀区政企区\",\"children\":null},{\"id\":\"11742\",\"code\":\"900803\",\"isLeaf\":true,\"name\":\"岱山县政企区\",\"children\":null},{\"id\":\"11743\",\"code\":\"900804\",\"isLeaf\":true,\"name\":\"嵊泗县政企区\",\"children\":null},{\"id\":\"11744\",\"code\":\"900805\",\"isLeaf\":true,\"name\":\"海洋产业集聚区政企区\",\"children\":null},{\"id\":\"11745\",\"code\":\"900806\",\"isLeaf\":true,\"name\":\"舟山群岛新区普陀山－朱家尖管理委员会政企区\",\"children\":null},{\"id\":\"11746\",\"code\":\"900807\",\"isLeaf\":true,\"name\":\"舟山群岛新区新城管理委员会政企区\",\"children\":null},{\"id\":\"11739\",\"code\":\"900899\",\"isLeaf\":true,\"name\":\"舟山市本级政企区\",\"children\":null}]},{\"id\":\"11245\",\"code\":\"900900\",\"isLeaf\":false,\"name\":\"台州市政企区\",\"children\":[{\"id\":\"11748\",\"code\":\"900901\",\"isLeaf\":true,\"name\":\"椒江区政企区\",\"children\":null},{\"id\":\"11749\",\"code\":\"900902\",\"isLeaf\":true,\"name\":\"黄岩区政企区\",\"children\":null},{\"id\":\"11750\",\"code\":\"900903\",\"isLeaf\":true,\"name\":\"路桥区政企区\",\"children\":null},{\"id\":\"11751\",\"code\":\"900904\",\"isLeaf\":true,\"name\":\"温岭市政企区\",\"children\":null},{\"id\":\"11752\",\"code\":\"900905\",\"isLeaf\":true,\"name\":\"临海市政企区\",\"children\":null},{\"id\":\"11753\",\"code\":\"900906\",\"isLeaf\":true,\"name\":\"玉环市政企区\",\"children\":null},{\"id\":\"11754\",\"code\":\"900907\",\"isLeaf\":true,\"name\":\"三门县政企区\",\"children\":null},{\"id\":\"11755\",\"code\":\"900908\",\"isLeaf\":true,\"name\":\"天台县政企区\",\"children\":null},{\"id\":\"11756\",\"code\":\"900909\",\"isLeaf\":true,\"name\":\"仙居县政企区\",\"children\":null},{\"id\":\"11747\",\"code\":\"900999\",\"isLeaf\":true,\"name\":\"台州市本级政企区\",\"children\":null}]},{\"id\":\"11246\",\"code\":\"901000\",\"isLeaf\":false,\"name\":\"衢州市政企区\",\"children\":[{\"id\":\"11758\",\"code\":\"901001\",\"isLeaf\":true,\"name\":\"柯城区政企区\",\"children\":null},{\"id\":\"11759\",\"code\":\"901002\",\"isLeaf\":true,\"name\":\"衢江区政企区\",\"children\":null},{\"id\":\"11760\",\"code\":\"901003\",\"isLeaf\":true,\"name\":\"江山市政企区\",\"children\":null},{\"id\":\"11761\",\"code\":\"901004\",\"isLeaf\":true,\"name\":\"龙游县政企区\",\"children\":null},{\"id\":\"11762\",\"code\":\"901005\",\"isLeaf\":true,\"name\":\"常山县政企区\",\"children\":null},{\"id\":\"11763\",\"code\":\"901006\",\"isLeaf\":true,\"name\":\"开化县政企区\",\"children\":null},{\"id\":\"11764\",\"code\":\"901007\",\"isLeaf\":true,\"name\":\"衢州绿色产业区政企区\",\"children\":null},{\"id\":\"11757\",\"code\":\"901099\",\"isLeaf\":true,\"name\":\"衢州市本级政企区\",\"children\":null}]},{\"id\":\"11247\",\"code\":\"901100\",\"isLeaf\":false,\"name\":\"宁波市政企区\",\"children\":[{\"id\":\"11776\",\"code\":\"901101\",\"isLeaf\":true,\"name\":\"慈溪市政企区\",\"children\":null},{\"id\":\"11777\",\"code\":\"901102\",\"isLeaf\":true,\"name\":\"海曙区政企区\",\"children\":null},{\"id\":\"11778\",\"code\":\"901103\",\"isLeaf\":true,\"name\":\"江北区政企区\",\"children\":null},{\"id\":\"11779\",\"code\":\"901104\",\"isLeaf\":true,\"name\":\"镇海区政企区\",\"children\":null},{\"id\":\"11780\",\"code\":\"901105\",\"isLeaf\":true,\"name\":\"北仑区政企区\",\"children\":null},{\"id\":\"11781\",\"code\":\"901106\",\"isLeaf\":true,\"name\":\"鄞州区政企区\",\"children\":null},{\"id\":\"11782\",\"code\":\"901107\",\"isLeaf\":true,\"name\":\"奉化区政企区\",\"children\":null},{\"id\":\"11783\",\"code\":\"901108\",\"isLeaf\":true,\"name\":\"余姚市政企区\",\"children\":null},{\"id\":\"11784\",\"code\":\"901109\",\"isLeaf\":true,\"name\":\"宁海县政企区\",\"children\":null},{\"id\":\"11785\",\"code\":\"901110\",\"isLeaf\":true,\"name\":\"象山县政企区\",\"children\":null},{\"id\":\"11786\",\"code\":\"901111\",\"isLeaf\":true,\"name\":\"保税区政企区\",\"children\":null},{\"id\":\"11787\",\"code\":\"901112\",\"isLeaf\":true,\"name\":\"东钱湖区政企区\",\"children\":null},{\"id\":\"11788\",\"code\":\"901113\",\"isLeaf\":true,\"name\":\"大榭开发区政企区\",\"children\":null},{\"id\":\"11789\",\"code\":\"901114\",\"isLeaf\":true,\"name\":\"国家高新技术产业开发区政企区\",\"children\":null},{\"id\":\"11790\",\"code\":\"901115\",\"isLeaf\":true,\"name\":\"杭州湾新区政企区\",\"children\":null},{\"id\":\"11775\",\"code\":\"901199\",\"isLeaf\":true,\"name\":\"宁波市本级政企区\",\"children\":null}]}]}";
        List<String> cityList = new ArrayList<>();
        cityList.add("绍兴市政企区");
        cityList.add("台州市政企区");
        cityList.add("温州市政企区");
        cityList.add("金华市政企区");
        cityList.add("丽水市政企区");
        cityList.add("衢州市政企区");
        List<AdDistrictInfo> adDistrictInfos2 = JSON.parseArray(JSON.parseObject(zhengqiqu).getString("data"), AdDistrictInfo.class);
        Map<String, String> comAllMap = parse(cityList, adDistrictInfos2);

//        System.out.println(comAllMap.values());


        String tableName = "temp";

//        /**政采网超**/
//        String manangerId = "1";
//        String channel = "0";
//        System.out.println("");
//        for (Map.Entry<String,String> entry : govAllMap.entrySet()) {
//            StringBuilder sb = createSql(tableName, manangerId, channel, entry.getKey());
//            System.out.println(sb.toString());
//        }
//        /**企业网超**/
//        manangerId = "1";
//        channel = "1";
//        for (Map.Entry<String,String> entry : comAllMap.entrySet()) {
////            StringBuilder sb = createSql(tableName, manangerId, channel, entry.getKey());
//            System.out.print("1 -1 "+entry.getKey()+" "+entry.getValue());
//            System.out.println();
//        }
//        /**医疗馆**/

        String manangerName = "云鹤";
        String channel = "政府采购";
        System.out.println("渠道: "+channel);
        System.out.println(" PM 姓名: 云鹤");
        for (Map.Entry<String,String> entry : govAllMap.entrySet()) {
            System.out.println("   "+entry.getKey()+" "+entry.getValue());
        }
        System.out.println(" PM姓名: 昊天");
        System.out.println("   政府采购其他区划");
        /**企业网超**/
        channel = "企业网超";
        System.out.println("渠道: "+channel);
        System.out.println("  PM 姓名: 云鹤");
        for (Map.Entry<String,String> entry : comAllMap.entrySet()) {
             System.out.println("   "+entry.getKey()+" "+entry.getValue());
        }
        System.out.println("  PM 姓名: 昊天");
        System.out.println("   企业网超其他区划");

        /**医疗馆**/
        System.out.println("渠道: "+channel);
        System.out.println("  PM 姓名: 有晨");
        System.out.println("   医疗馆所有区划");




    }

    private static StringBuilder createSql(String tableName, String manangerId, String channel, String districtCode) {
        String insert = "INSERT INTO `temp`.`ad_manager_district`(`manager_id`, `channel`, `district_code`) VALUES (1, 0, '330104');";
        StringBuilder sb = new StringBuilder("INSERT INTO `");
        sb.append(tableName);
        sb.append("`.`ad_manager_district`(`manager_id`, `channel`, `district_code`) VALUES (");
        sb.append(manangerId);
        sb.append(", ");
        sb.append(channel);
        sb.append(", '");
        sb.append(districtCode);
        sb.append("');");
        return sb;
    }

    private static Map<String, String> parse(List<String> cityList, List<AdDistrictInfo> adDistrictInfos) {
        Map<String, String> districtAllMap = new HashMap<>();
        for (AdDistrictInfo adDistrictInfo : adDistrictInfos) {
            if (!adDistrictInfo.getIsLeaf() && cityList.contains(adDistrictInfo.getName())) {
                for (AdDistrictInfo districtInfo : adDistrictInfo.getChildren()) {
                    districtAllMap.put(districtInfo.getCode(), districtInfo.getName());
                }
            }
        }
        return districtAllMap;
    }
}
