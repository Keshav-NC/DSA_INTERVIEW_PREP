package com.keshav.Stacks;

public class DynamicQueue extends CIRCULARQUEUE{
    public DynamicQueue() {
        super(); // call STACK() from STACK
    }

    public DynamicQueue(int size) {
        super(size);
    }

    // remove remains same


    @Override
    public boolean insert(int item) throws Exception {
        // this take care of being full
        if (this.isFull()) {
            // create a new array of twice the length of prev array
            int[] temp = new int[data.length * 2];
            // copy all the values from prev array to new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        // at this point we know that array is not full
        // insert
        return super.insert(item);
    }
}
