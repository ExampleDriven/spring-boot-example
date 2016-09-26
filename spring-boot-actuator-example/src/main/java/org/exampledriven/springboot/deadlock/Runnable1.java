package org.exampledriven.springboot.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runnable1 implements Runnable {

    Logger logger = LoggerFactory.getLogger(Runnable1.class);

    private Object lock2;
    private Object lock1;

    public Runnable1(Object lock2, Object lock1) {
        this.lock2 = lock2;
        this.lock1 = lock1;
    }

    public void run() {

        synchronized (lock1) {
            logger.info("Holding lock 1...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }

            logger.info("Waiting for lock 2...");

            synchronized (lock2) {
                logger.info("Holding lock 1 & 2...");
            }
        }
    }
}
