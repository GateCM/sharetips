package test;

import java.util.concurrent.*;

/**
 * Created by yaoguang on 2019/3/25 20:27.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long a = System.currentTimeMillis();


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());



        Future<Long> futureTask1 = threadPoolExecutor.submit(() -> {
                SlowQuery query1 = new SlowQuery();
                Long re = query1.query(3L);
                return re;
        });

        Future<Long> futureTask2 = threadPoolExecutor.submit(() -> {
                SlowQuery query2 = new SlowQuery();
                Long re = query2.query(4L);
                return re;
        });

        //todo



        System.out.println("get 前：" + (System.currentTimeMillis() - a) / 1000);

        System.out.println("get 后：" + (System.currentTimeMillis() - a) / 1000);
        System.out.println(futureTask2.get());
        System.out.println("结束：" + (System.currentTimeMillis() - a) / 1000);

    }
}
