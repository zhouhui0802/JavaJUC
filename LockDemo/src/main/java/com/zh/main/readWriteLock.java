package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class readWriteLock {
    public static void main(String[] args) throws InterruptedException {

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        lock.writeLock().lock();
        lock.writeLock().lock();

        new Thread(()->{
            lock.writeLock().lock();

            System.out.println("成功获取到写锁");
        }).start();

        System.out.println("释放第一层锁");
        lock.writeLock().unlock();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("释放第二层锁");
        lock.writeLock().unlock();
    }
}
