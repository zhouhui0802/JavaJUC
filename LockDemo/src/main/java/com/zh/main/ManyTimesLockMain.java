package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ManyTimesLockMain {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        System.out.println("当前加锁次数"+lock.getHoldCount()+", 是否被锁"+lock.isLocked());

        TimeUnit.SECONDS.sleep(1);

        lock.unlock();
        System.out.println("当前加锁次数"+lock.getHoldCount()+", 是否被锁"+lock.isLocked());
        TimeUnit.SECONDS.sleep(1);
        lock.unlock();
        System.out.println("当前加锁次数"+lock.getHoldCount()+", 是否被锁"+lock.isLocked());
    }
}
