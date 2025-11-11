package com.zh.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.LongAdder;

public class AutoArray {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[]{0,1,3,4,6});
        Runnable runnable =()->{
            for(int i=0;i<10000;i++){
                array.getAndAdd(0,1);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(array.get(0));

        LongAdder adder = new LongAdder();

        Runnable runnable1 =()->{
            for(int i=0;i<10000;i++){
                adder.add(1);
            }
        };
        for(int i=0;i<100;i++){
            new Thread(runnable1).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(adder.sum());
    }
}
