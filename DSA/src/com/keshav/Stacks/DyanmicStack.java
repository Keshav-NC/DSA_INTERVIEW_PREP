package com.keshav.Stacks;

public class DyanmicStack extends STACK{
    public DyanmicStack() {
        super(); // call STACK() from STACK
    }

    public DyanmicStack(int size) {
        super(size);
    }

    // pop, peek, isFull, isEmpty remains same
    // only push implementation changes


    @Override
    public boolean push(int item) throws Exception{
        // this take care of being full
        if (this.isFull()) {
            // create a new array of twice the length of prev array
            int[] temp = new int[data.length * 2];
            // copy all the values from prev array to new array
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        // at this point we know that array is not full
        // insert
        return super.push(item);
    }
}
