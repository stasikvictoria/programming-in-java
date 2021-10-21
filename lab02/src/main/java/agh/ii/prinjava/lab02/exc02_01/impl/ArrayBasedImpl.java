package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

public class ArrayBasedImpl implements StackOfInts {
    private int[] arr;

    public ArrayBasedImpl(){
        this.arr = new int[]{};
    }

    @Override
    public int pop() {
        if (arr.length > 0){
            int[] temp = new int[arr.length-1];
            for (int i = 0 ; i<arr.length-1 ; i++){
                temp[i] = this.arr[i];
            }
            int val = this.arr[arr.length-1];
            this.arr = temp;
            return val;
        }
        throw new IllegalStateException("To be implemented");
    }

    @Override
    public void push(int x) {
        if (arr.length == 0){
            arr = new int[]{x};
        }
        else{
            int[] temp = new int[arr.length+1];
            for (int i=0 ; i<arr.length ; i++){
                temp[i] = this.arr[i];
            }
            temp[arr.length] = x;
            arr = temp;
        }
        throw new IllegalStateException("To be implemented");
    }

    @Override
    public int numOfElems() {
        int numOfElems = arr.length;
        return numOfElems;
    }

    @Override
    public int peek() {
        if (arr.length > 0){
            int[] temp = new int[arr.length-1];
            for (int i=1 ; i<arr.length ; i++){
                temp[i-1] = arr[i];
            }
            int val = arr[0];
            arr = temp;
            return val;
        }
        throw new IllegalStateException("To be implemented");
    }

    private int numOfElems = 0;
}
