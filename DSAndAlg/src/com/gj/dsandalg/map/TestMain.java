package com.gj.dsandalg.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class TestMain {

    static final int MAXIMUM_CAPACITY = 1 << 30;


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        int result = tableSizeFor(25);

        System.out.println("newSize = " + result);

        Hashtable hsTable = new Hashtable();
        hsTable.put("aa", new Object());

        HashMap hashMap = new HashMap();

        for (int i = 0; i < 20; i++) {
            hashMap.put("bb", new Object());
            System.out.println("i=" + i);
        }

        HashSet hashSet = new HashSet();

    }
}
