package com.zh.main;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoIntegerCAS {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);

        System.out.println(atomicInteger.compareAndSet(30, 20));
        System.out.println(atomicInteger.compareAndSet(10, 20));
        System.out.println(atomicInteger);
    }
}
