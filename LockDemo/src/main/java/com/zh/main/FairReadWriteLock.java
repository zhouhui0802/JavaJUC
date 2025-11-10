package com.zh.main;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FairReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

        Runnable action = () -> {
            System.out.println("线程"+Thread.currentThread().getName()+"将在一秒钟后开始获取锁...");
            lock.writeLock().lock();
            System.out.println("线程"+Thread.currentThread().getName()+"成功获取锁");
            lock.writeLock().unlock();
        };

        for(int i=0;i<10;i++){
            new Thread(action,"T"+i).start();
        }
    }
}
