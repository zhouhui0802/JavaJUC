package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTimeUnitMain {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();

        System.out.println(condition.await(3, TimeUnit.SECONDS));

        lock.unlock();

        System.out.println("60秒"+TimeUnit.SECONDS.toMinutes(60)+"分钟");
        System.out.println("365天"+TimeUnit.DAYS.toSeconds(365)+"秒");
    }
}
