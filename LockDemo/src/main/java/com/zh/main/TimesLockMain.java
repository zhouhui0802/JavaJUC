package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimesLockMain {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();

        new Thread(()->{
            System.out.println("线程2想要获取锁");
            lock.lock();
            System.out.println("线程2成功获取锁");
        }).start();

        lock.unlock();
        System.out.println("线程1释放了一次锁");
        TimeUnit.SECONDS.sleep(1);
        lock.unlock();
        System.out.println("线程1再次释放一次锁");
    }
}
