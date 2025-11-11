package com.zh.main;

import java.util.concurrent.atomic.AtomicReference;

public class AutoReference {
    public static void main(String[] args) {
        String a="Hello";
        String b="World";

        AtomicReference<String> reference = new AtomicReference<>(a);
        reference.compareAndSet(a,b);
        System.out.println(reference.get());
    }
}
