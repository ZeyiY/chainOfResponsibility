package com.zeyi.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yangsen1 on 2017/6/28.
 */
public class CountDownLatchTest {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("开始执行~");
        CountDownLatchTest mCountDownLatchTest = new CountDownLatchTest();
        mCountDownLatchTest.timeTask(6,mCountDownLatchTest.new RunnableTask());
    }

    public void timeTask(int nThreads,final Runnable mRunnableTask) throws InterruptedException {
        final CountDownLatch startCount = new CountDownLatch(1);
        final CountDownLatch endCount   = new CountDownLatch(nThreads);
        for(int i =0;i<nThreads;i++){
            Thread thread =new Thread(){
                @Override
                public void run() {
                    try {
                        startCount.await();
                        try {
                            mRunnableTask.run();
                        }finally {
                            endCount.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }

        long startTime = System.nanoTime();
        System.out.println("打开闭锁");
        startCount.countDown();
        endCount.await();
        long endTime = System.nanoTime();
        System.out.println("闭锁结束");
        System.out.println("一共耗时：" + (endTime - startTime));
    }

    class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程的名称:" + Thread.currentThread().getName());
        }
    }
}
