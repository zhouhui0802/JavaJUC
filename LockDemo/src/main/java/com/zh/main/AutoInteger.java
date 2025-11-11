package com.zh.main;

import java.util.concurrent.atomic.AtomicInteger;

public class AutoInteger {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.incrementAndGet());
    }
}
