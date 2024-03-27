package lsp.learn;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;

public class MyThread {

    final static int N = 4;
    public  Object obj = new Object();
    static int i = 1;
    static {
        i = 123;
    }
    MyThread() {

    }
    public static void main(String[] args) throws InterruptedException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        HashMap<Integer, Integer> res = new HashMap<>();
        new MyThread();
    }

    public static void test() {
        System.out.println("test");
    }

}
