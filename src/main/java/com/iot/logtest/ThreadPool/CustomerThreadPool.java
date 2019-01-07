package com.iot.logtest.ThreadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class CustomerThreadPool {

    /**
     * 日志
     */
    private final static Logger logger= LoggerFactory.getLogger(CustomerThreadPool.class);

    /**
     * 线程池
     */
    private ThreadPoolExecutor threadPool=null;

    private  static Integer defaultCorePoolSize=10;
    private  static Integer defaultMaximumPoolSize=20;
    private  static Integer defaultKeepAliveTime=30;
    private  static Integer defaultQueenCapacity=10000;

    /**
     * 初始化线程池
     */
    public void initThreadPool(){
        threadPool=new ThreadPoolExecutor(
                defaultCorePoolSize,
                defaultMaximumPoolSize,
                defaultKeepAliveTime,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(defaultQueenCapacity),
                new CustomRejectedExecutionHandler()
        );
    }

    /**
     * 销毁线程池
     */
    public void destoryThreadPool(){
        if(null!=threadPool){
            threadPool.shutdown();
        }
    }


    /**
     * 获取线程池
     * @return
     */
    public ExecutorService getCustomThreadPool(){
        return threadPool;
    }


    public ThreadPoolExecutor getThreadPool(){
        return threadPool;
    }

    public void resizeThreadPoolSize(){
        while (true){
            logger.info("active:"+String.valueOf(threadPool.getActiveCount()));
        }
    }

}
