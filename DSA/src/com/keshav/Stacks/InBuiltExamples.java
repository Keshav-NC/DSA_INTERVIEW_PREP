package com.keshav.Stacks;

import java.util.*;

public class InBuiltExamples {
    public static void main(String[] args) throws Exception {
//        // InBuilt Stack
//        // LIFO
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//
//        System.out.println(stack.pop() + " deleted");
//        System.out.println(stack.pop() + " deleted");
//        System.out.println(stack.pop() + " deleted");
//        System.out.println(stack.pop() + " deleted");

//        // InBuilt Queue
//        // FIFO
//        // Queue --> Interface
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//
//        // peek() --> gives the top most element, but doesn't remove
//        System.out.println(queue.peek() + " top most element");
//
//        System.out.println(queue.remove());
//
//        // peek() --> gives the top most element, but doesn't remove
//        System.out.println(queue.peek() + " top most element");
//
//        System.out.println(queue.remove());
//
//        // peek() --> gives the top most element, but doesn't remove
//        System.out.println(queue.peek() + " top most element");
//
//        System.out.println(queue.remove());
//
//        // peek() --> gives the top most element, but doesn't remove
//        System.out.println(queue.peek() + " top most element");
//
//        System.out.println(queue.remove());
//
//        // peek() --> gives the top most element, but doesn't remove
//        System.out.println(queue.peek() + " top most element");

//        // Insertion and deletion can be done on both the sides
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(2);
//        deque.addFirst(1);
//        deque.addLast(3);
//        System.out.println(deque.remove());
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeLast());
        // etc etc

//        // Custom Stack
//        STACK s = new STACK(4);
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.push(4);
//
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
////        System.out.println(s.pop());

//        // Dynamic Stack
//        DyanmicStack ds = new DyanmicStack(5);
//        ds.push(1);
//        ds.push(2);
//        ds.push(3);
//        ds.push(4);
//        ds.push(5);
//        ds.push(6);
//        ds.push(7);
//        ds.push(8);
//        ds.push(9);
//        ds.push(10);
//        ds.push(11);
//
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
//        System.out.println(ds.pop());
////        System.out.println(ds.pop());

//        // Custom Queue
//        QUEUE q = new QUEUE();
//        q.insert(1);
//        q.insert(2);
//        q.insert(3);
//        q.insert(4);
//        q.display();
//        System.out.println(q.remove());
//        q.display();

        // CircularQueue
        CIRCULARQUEUE cq = new CIRCULARQUEUE(5);
        cq.insert(1);
        cq.insert(2);
        cq.insert(3);
        cq.insert(4);
        cq.insert(5);
        cq.display();
        System.out.println(cq.remove() + " deleted");
        cq.insert(6);
        cq.display();
    }
}
