package com.demo.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by louis on 2014/10/28.
 */
public class SafeTask implements Runnable {
    private static ThreadLocal<Date> startDate=new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }

    };

    @Override
    public void run() {
        System.out.printf("Starting Thread:%s,%s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished:%s:%s\n",Thread.currentThread().getId(),startDate.get());
    }
}
