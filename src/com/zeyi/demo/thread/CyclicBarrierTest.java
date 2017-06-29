package com.zeyi.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by yangsen1 on 2017/6/28.
 */
public class CyclicBarrierTest {
    private CyclicBarrier   mCyclicBarrier;
    private Worker          worker[];

    public CyclicBarrierTest(){
        int count = Runtime.getRuntime().availableProcessors();
        this.mCyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程均到达栅栏位置，开始下一轮计算");
            }
        });
        this.worker = new Worker[count];
        for (int i =0;i<count;i++){
            worker[i] = new Worker(i);
        }
    }

    class Worker implements Runnable{
        private int i;
        public Worker(int i){
            this.i = i;
        }
        @Override
        public void run() {
            for (int index = 1;index<3;index++){
                System.out.println("线程" + i + "第" + index + "次到达栅栏的位置，等待其他线程到达");
                try {
                    mCyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start(){
        for (int i =0;i<worker.length;i++){
            new Thread(worker[i]).start();
        }
    }

    public static void main(String args[]){
        new CyclicBarrierTest().start();
    }

}
