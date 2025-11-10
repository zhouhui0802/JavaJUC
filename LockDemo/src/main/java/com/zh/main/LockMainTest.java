package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockMainTest {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            lock.lock();
            try{
                condition.await();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("查看是否执行这一行");
            lock.unlock();
        }).start();

        TimeUnit.SECONDS.sleep(1);
        lock.lock();
        System.out.println("当前conditon的等待线程"+lock.getWaitQueueLength(condition));
        condition.signal();
        System.out.println("当前conditon的等待线程"+lock.getWaitQueueLength(condition));
        lock.unlock();
    }
}
