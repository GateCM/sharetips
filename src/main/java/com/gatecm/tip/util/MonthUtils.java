package com.gatecm.tip.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yaoguang on 2019/9/17 16:58.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class MonthUtils {
    public static final String ONE_STRING = "1";
    public static final String BLANK_STRING = "";

    public static void main(String[] args) {

        int b = getMonthKey(31);
        System.out.println(b);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b).length());
        int a = residueByKey(b, Arrays.asList(1, 2, 3, 4, 6, 7, 9));
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        List<Integer> availableList = parse(a);
        System.out.println(availableList);

    }

    private static List<Integer> parse(int availableKey) {
        List<Integer> availableList = new ArrayList<>();
        String availableKeyStr = Integer.toBinaryString(availableKey);
        String[] availableKeyArr = availableKeyStr.split(BLANK_STRING);
        for (int i = 1, len = availableKeyArr.length; i < len; i++) {
            if (availableKeyArr[i].equals(ONE_STRING)) {
                availableList.add(len - i);
            }
        }
        return availableList.stream().sorted().collect(Collectors.toList());
    }

    /**
     * 首位置1
     */
    public static int getMonthKey(int dayNum) {
        return (2 << dayNum) - 1;
    }

    public static int getDayKey(int dayNum) {
        if (dayNum == 1) {
            return 1;
        }
        return 2 << (dayNum - 2);
    }


    public static int residue(Integer maxDayNum, List<Integer> usedList) {
        return residueByKey(getMonthKey(maxDayNum), usedList);
    }

    public static int residueByKey(Integer maxDayNumKey, List<Integer> usedList) {
        int temp = 0;
        for (int i = 0, len = usedList.size(); i < len; i++) {
            temp = temp | getDayKey(usedList.get(i));
        }
        return maxDayNumKey ^ temp;
    }
}
