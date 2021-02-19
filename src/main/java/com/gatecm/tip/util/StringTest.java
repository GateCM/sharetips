package com.gatecm.tip.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoguang on 2020/2/24 10:20.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class StringTest {


    public static void main(String[] args) {


        String key = "1731";

        List<String> keys = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            keys.add(key + i);
        }

        String a  = String.join(",",keys);
        System.out.println(a);

    }

}
