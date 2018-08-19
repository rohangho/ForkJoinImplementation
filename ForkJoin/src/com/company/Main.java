package com.company;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int arr[]={9,8,7,6,5,4,3,2,1,};
        SumArray t=new SumArray(arr,0,arr.length);
        ForkJoinPool.commonPool().invoke(t);
        System.out.println(t.answer);
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
    }
}
