package com.demo.thread.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by louis on 2014/10/29.
 */
public class Server {
    private ThreadPoolExecutor executor;
    public Server(){
//        executor=(ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor= (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }
    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n",executor.
                getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.
                getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.
                getCompletedTaskCount());
    }
    public void endServer() {
        executor.shutdown();
    }
}
