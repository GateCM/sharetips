package thread;

import javafx.scene.media.SubtitleTrack;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaoguang on 2019/4/4 17:25.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class ertetr {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime=System.currentTimeMillis();
        long endTime=System.currentTimeMillis();
        System.out.println("初始时："+(endTime-startTime)+"ms");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("future1 start");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "future1";
        });


        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("future2 start");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "future2";
        });


//        future1.get();
//
//
//        endTime=System.currentTimeMillis();
//        System.out.println("future1.get()："+(endTime-startTime)+"ms");



        System.out.println(future2.get());


        endTime=System.currentTimeMillis();
        System.out.println("future2.get()："+(endTime-startTime)+"ms");

    }
}
