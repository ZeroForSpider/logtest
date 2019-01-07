package com.iot.logtest.ThreadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 动态变化线程池
 */
public class CheckThreadPool implements Runnable {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(CheckThreadPool.class);

    /**
     * 线程池
     */
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 最大核心数
     */
    private static Integer maxCorePoolSize = 20;

    /**
     * 最大线程池大小
     */
    private static Integer maxMaximumPoolSize = 30;

    /**
     * 最小核心数
     */
    private static Integer minCorePoolSize = 1;

    public CheckThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public void run() {
        Boolean flag = true;
        while (true) {
            try {
                Thread.sleep(3000);
                // 总任务大小
                logger.info("activeCount:" + threadPoolExecutor.getActiveCount());
                logger.info("taskCount:" + threadPoolExecutor.getTaskCount());
                logger.info("corePoolSize:" + threadPoolExecutor.getCorePoolSize());
                long taskCount = threadPoolExecutor.getTaskCount();
                if (flag && taskCount > maxCorePoolSize) {
                    logger.info("开始扩大线程池");
                    threadPoolExecutor.setCorePoolSize(maxCorePoolSize);
                    threadPoolExecutor.setMaximumPoolSize(maxMaximumPoolSize);
                    logger.info("扩大后的线程池大小为:" + threadPoolExecutor.getCorePoolSize());
                    flag = false;
                } else {
                    threadPoolExecutor.setCorePoolSize((int) taskCount);
                }
                long activeTask = threadPoolExecutor.getActiveCount();
                if (activeTask == minCorePoolSize) {
                    logger.info("开始缩小线程池");
                    threadPoolExecutor.setCorePoolSize(minCorePoolSize);
                    logger.info("缩小后的线程池大小为:" + threadPoolExecutor.getCorePoolSize());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
