package com.iot.logtest;

import com.iot.logtest.ThreadPool.CustomerThreadPool;
import com.iot.logtest.ThreadPool.TaskThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

/**
 * @author LHT
 */
public class Main {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CustomerThreadPool customerThreadPool = new CustomerThreadPool();
        //初始化线程池
        customerThreadPool.initThreadPool();
        //得到线程池
        ExecutorService executorService = customerThreadPool.getCustomThreadPool();
        for (int i = 0; i < 100; i++) {
            logger.info("开始执行第"+i+"个任务");
            executorService.execute(new TaskThread(i));
        }
    }

}

