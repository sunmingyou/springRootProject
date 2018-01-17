package com.icolor.StudySpringBoot.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 这是一个继承Runnable的例子
 */
public class TestRunnable implements Runnable {

    public static void main(String[] args) {

        ExecutorService runnableService = Executors.newFixedThreadPool(3);

        Runnable r1 = new TestRunnable();
        runnableService.submit(r1);
        runnableService.submit(new TestRunnable());
        runnableService.submit(new TestRunnable());
        runnableService.submit(new TestRunnable());
        runnableService.shutdown();

        System.out.println("go on");
        System.out.println("end");
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ";random:" + (int) (Math.random() * 10 * 1000));
            try {
                Thread.sleep((int) (Math.random() * 10 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}