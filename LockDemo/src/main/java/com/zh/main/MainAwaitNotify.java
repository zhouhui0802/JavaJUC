package com.zh.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainAwaitNotify {
    public static void main(String[] args) throws InterruptedException {

        Lock testLock = new ReentrantLock();
        Condition condition = testLock.newCondition();

        new Thread(()->{
            testLock.lock();   //和synchronized的，必须持有锁的情况下才能await
            System.out.println("线程1进入等待状态");
            try{
                condition.await(); // 进入等待状态
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程1等待结束");
            testLock.unlock();
        }).start();

        Thread.sleep(100); //放置线程2先跑

        new Thread(()->{
            testLock.lock();
            System.out.println("线程2开始唤起其他等待线程");
            condition.signal();  // 唤醒线程1 但此时线程1还必须拿到锁才能继续运行
            System.out.println("线程2结束");
            testLock.unlock();  //这里释放锁之后，线程1就可以继续运行了
        }).start();
    }
}
