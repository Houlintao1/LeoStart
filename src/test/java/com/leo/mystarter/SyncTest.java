package com.leo.mystarter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author hou
 * @date 2020-01-04 9:43 下午
 */
public class SyncTest {

    private static CyclicBarrier cyclicBarrier;

    static class MyThread extends Thread{
        @Override
        public void run(){
            try {
                System.out.println(Thread.currentThread().getName()+",enter!");
                cyclicBarrier.await();
                sleep(500);
                System.out.println(Thread.currentThread().getName()+",end!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("gogogo");
        });

        for (int i = 0; i < 5; i++) {
            new MyThread().start();

        }

    }


}
