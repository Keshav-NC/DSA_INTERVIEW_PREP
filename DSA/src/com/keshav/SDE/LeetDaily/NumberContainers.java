package com.keshav.SDE.LeetDaily;

import java.util.*;

public class NumberContainers {
    Map<Integer, Integer> indexToNum;
    Map<Integer, TreeSet<Integer>> numberToIndex;
    public NumberContainers() {
        numberToIndex = new HashMap<>();
        indexToNum = new HashMap<>();
    }

    public void change(int index, int number) {
        // delete old
        if (indexToNum.containsKey(index)) {
            int prev = indexToNum.get(index);
            numberToIndex.get(prev).remove(index);
            if (numberToIndex.get(prev).isEmpty()) {
                numberToIndex.remove(prev);
            }
        }
        // insert new
        indexToNum.put(index, number);
        if (!numberToIndex.containsKey(number)) {
            numberToIndex.put(number, new TreeSet<>());
        }
        numberToIndex.get(number).add(index);
    }

    public int find(int number) {
        if (!numberToIndex.containsKey(number)) {
            return -1;
        }
        return numberToIndex.get(number).first();
    }

    // ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
// [[],[75,40],[14],[41],[40],[27,40],[22,14],[85,14],[22,40],[18,34],[92,41],
// [22,40],[75,40],[59,34],[40],[27,14],[34],[14],[13,34],[40],[18,41]]
// [null,null,-1,-1,75,null,null,null,null,null,null,null,null,null,22,null,18,27,null,22,null]
    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        obj.change(75, 40);
        System.out.println(obj.find(14));
        System.out.println(obj.find(41));
        System.out.println(obj.find(40));
        obj.change(27, 40);
        obj.change(22, 14);
        obj.change(85, 14);
        obj.change(22, 40);
        obj.change(18, 34);
        obj.change(92, 41);
        obj.change(22, 40);
        obj.change(75, 40);
        obj.change(59, 34);
        System.out.println(obj.find(40));
        obj.change(27, 14);
        System.out.println(obj.find(34));
        System.out.println(obj.find(14));
        obj.change(13, 34);
        System.out.println(obj.find(40));
        obj.change(18, 41);
        System.out.println(obj.indexToNum);
        System.out.println(obj.numberToIndex);
    }
}
