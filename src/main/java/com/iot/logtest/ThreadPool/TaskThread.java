package com.iot.logtest.ThreadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

/**
 * 任务线程
 */
public class TaskThread implements Runnable {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(TaskThread.class);

    private Integer taskThreadNumber;

    private ExecutorService executorService;

    public TaskThread(Integer taskThreadNumber) {
        this.taskThreadNumber = taskThreadNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.info("线程" + taskThreadNumber + "休眠异常" + e);
        }
        logger.info("开始运行线程" + this.taskThreadNumber);
    }
}
