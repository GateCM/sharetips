package com.gatecm.tip.util;

import lombok.Data;

/**
 * @author 一鸣
 * @date 2020/6/3 20:46
 */
public class DemoTest {

    //thread - 5
    // 100000
    // 500000

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Worker().run();
            System.out.println("=="+i);
        }
        System.out.println(A.a + " : " + (System.currentTimeMillis() - start));

//        int j = 0;
//        for (int i = 0; i < 500000000; i++) {
//            j++;
//        }
//        System.out.println(j);
//        System.out.println(System.currentTimeMillis() - start);

    }

    static class A {

        private static int a;

        public static void add() {
            a++;
        }
    }

    @Data
    static class Worker implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 10000000; j++) {
                A.add();
            }
        }
    }

}