package demo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by yaoguang on 2018/12/28 14:47.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class TreadPool {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("import-pool-%d").build();
    private static ExecutorService pool = new ThreadPoolExecutor(10, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        final Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<100;++i) {
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0;i<100;++i) {
            int j = i;
            pool.execute(()->{
                System.out.println(list.get(j));
                countDownLatch.countDown();
                for (int k = 0;k<100;++k) {
                    list2.add(k);
                }

            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("over========================");

        for (Integer integer : list2) {
            System.out.println(integer);
        }
        System.out.println("size:"+list2.size());

        pool.shutdown();
    }
}
