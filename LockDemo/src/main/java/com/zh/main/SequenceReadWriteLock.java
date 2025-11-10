package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SequenceReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.readLock().lock();
        System.out.println("成功加锁");

        new Thread(() -> {
            System.out.println("开始加读锁");
            lock.readLock().unlock();
            System.out.println("读锁添加成功");
        }).start();

        TimeUnit.SECONDS.sleep(1);
        lock.writeLock().unlock();  // 不能降级锁
    }
}
