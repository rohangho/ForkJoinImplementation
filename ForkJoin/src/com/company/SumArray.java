package com.company;

import java.util.concurrent.RecursiveAction;

public class SumArray extends RecursiveAction {

    static int sequestialThreshold=5;
    int high;
    int low;
    int array[]=new int[9];
    int answer=0;

    SumArray(int a[],int b,int c)
    {

        for(int i=b;i<c;i++) {
            array[i] = a[i];
        }
        low=b;
        high=c;
    }

    @Override
    protected void compute() {
    if(high-low<=sequestialThreshold)
    {
        for (int i=0;i<array.length;i++)
            answer=answer+array[i];
    }
    else
    {
        SumArray left=new SumArray(array,low,(low+high)/2);
        SumArray right=new SumArray(array,(high+low)/2,high);
        left.fork();
        right.compute();
        left.join();
        answer=left.answer+right.answer;
    }
    }
}
