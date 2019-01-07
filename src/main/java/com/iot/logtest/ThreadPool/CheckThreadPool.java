package com.iot.logtest.ThreadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

public class CheckThreadPool {

    /**
     * 日志
     */
    private final static Logger logger= LoggerFactory.getLogger(CheckThreadPool.class);

    /**
     * 线程池
     */
    private ExecutorService executorService;

    public CheckThreadPool(ExecutorService executorService){
        this.executorService=executorService;
    }

    public void resizeThreadPoolSize(){

    }
}
