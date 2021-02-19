package com.gatecm.tip.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;


@Slf4j
public class ThreadPoolUtils {

    private static ThreadPoolUtils ME = null;

    private static ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

    private ThreadPoolUtils() {
        initThreadPoolTaskExecutor();
    }

    public static ThreadPoolUtils getInstance() {
        if (ME == null) {
            ME = new ThreadPoolUtils();
        }
        return ME;
    }

    /**
     * 初始化线程池
     */
    private void initThreadPoolTaskExecutor() {
        threadPoolTaskExecutor.initialize();
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("MarketingPlatformThreadFactory-%d").build();
        threadPoolTaskExecutor.setThreadFactory(factory);
        int processorSize = Runtime.getRuntime().availableProcessors();
        threadPoolTaskExecutor.setCorePoolSize(100);
        threadPoolTaskExecutor.setMaxPoolSize(processorSize * 100);
        threadPoolTaskExecutor.setQueueCapacity(1000);
        threadPoolTaskExecutor.setKeepAliveSeconds(60 * 3);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(Boolean.TRUE);
        // gracefully shutdown
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(Boolean.TRUE);
        threadPoolTaskExecutor.setAwaitTerminationSeconds(60);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new NewThreadRunPolicy());
    }

    public ThreadPoolTaskExecutor getThreadPoolExecutor() {
        return threadPoolTaskExecutor;
    }

    public void destroy() {
        threadPoolTaskExecutor.shutdown();
    }

    public <T> Future<T> submitTask(Callable<T> callable) {
        return threadPoolTaskExecutor.submit(callable);
    }

    public Future submitTask(Runnable runnable) {
        return threadPoolTaskExecutor.submit(runnable);
    }

    class NewThreadRunPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            Thread t = new Thread(r, "Temp thread for thread pool exhausted.");
            t.start();
        }
    }

}

