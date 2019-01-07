package com.iot.logtest.ThreadPool;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class CustomerThreadPool {
    /**
     * 线程池
     */
    private ThreadPoolExecutor threadPool=null;

    private  static Integer corePoolSize=2;
    private  static Integer maximumPoolSize=5;
    private  static Integer keepAliveTime=5;
    private  static Integer queenCapacity=10;

    /**
     * 初始化线程池
     */
    public void initThreadPool(){
        threadPool=new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(queenCapacity),
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


    public void resizeThreadPoolSize(){
        if(threadPool.getQueue().size()+2>queenCapacity){
            threadPool.setCorePoolSize();
        }
    }

}
