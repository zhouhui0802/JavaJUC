package com.zh.main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static int i =0;
    public static void main(String[] args) throws InterruptedException {

        Lock testLock = new ReentrantLock();  //可重入ReentrantLock类是Lock的一个实现类

        Runnable action = () ->{
            for(int j=0;j<10000;j++){  // 依旧以自增长为案例
                testLock.lock(); //加锁， 加锁成功后其他线程想要获取锁，会被阻塞，等待当前线程释放
                i++;
                testLock.unlock(); //解锁 ， 解锁之后，其他线程就可以获取这把锁了
            }
        };

        new Thread(action).start();
        new Thread(action).start();

        Thread.sleep(1000); // 等上面两个线程跑完
        System.out.println(i);
    }
}
