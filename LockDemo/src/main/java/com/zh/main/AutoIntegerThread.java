package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AutoIntegerThread {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            for(int j=0;j<10000;j++){
                atomicInteger.getAndIncrement();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(atomicInteger.get());
    }
}
