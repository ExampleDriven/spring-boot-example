package org.exampledriven.springboot;

import org.exampledriven.springboot.deadlock.Runnable1;
import org.exampledriven.springboot.deadlock.Runnable2;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is an example to show how the remote shell dashboard feature is useful
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardDemoController {

    protected static final int ONE_HOUR = 1000 * 60 * 60;

    @RequestMapping("/sleep")
    public String makeMemoryLeak() {
        new SimpleAsyncTaskExecutor().execute(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(ONE_HOUR);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        return "thread is sleeping";
    }

    @RequestMapping("/deadlock")
    public String makeDeadlock() {

        Object lock1 = new Object();
        Object lock2 = new Object();

        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setDaemon(true);

        simpleAsyncTaskExecutor.execute(new Runnable1(lock1, lock2));
        simpleAsyncTaskExecutor.execute(new Runnable2(lock1, lock2));

        return "Two threads are blocked now!";

    }


}