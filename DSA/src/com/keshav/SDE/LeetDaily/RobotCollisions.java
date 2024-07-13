package com.keshav.SDE.LeetDaily;

import java.util.*;

public class RobotCollisions {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indexes = new Integer[n];

        for (int i = 0; i < n; i++) {
            // for relative sorting
            indexes[i] = i; // [0, 1, 2, .....]
        }

        // sort index on the basis of positions array
        Arrays.sort (indexes, new Comparator<Integer>() {
            public int compare (Integer a, Integer b) {
                // increasing order of postions sort..
                // neg or 0, no swaping
                // pos, swap
                // a = 0
                // b = 1
                // positions[0] - positions[1] --> eg. 18 - 2 = 14 --> positive, swap --> 2, 18
                return positions[a] - positions[b];
            }
        });

        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index : indexes) {
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else { // incoming --> L
                boolean isSurvived = true;
                while (!stack.isEmpty()) {
                    int topIndex = stack.peek();
                    // case 1: if dir of top is "Left", then insert
                    if (directions.charAt(topIndex) == 'L') {
                        isSurvived = true;
                        break;
                    }
                    // case 2: 'topIndex' is 'R' & health is more than 'index'
                    else if (healths[topIndex] > healths[index]) {
                        isSurvived = false;
                        healths[index] = 0; // explode
                        healths[topIndex] -= 1; // reduced by 1
                        break;
                    }
                    // case 3: 'topIndex' is 'R' & health is less than 'index'
                    else if (healths[topIndex] < healths[index]) {
                        isSurvived = true;
                        healths[index] -= 1; // reduced by 1
                        healths[topIndex] = 0; // explode
                        stack.pop(); // remove topIndex from stack
                    }
                    // case 4: 'topIndex' is 'R' & health == to 'index'
                    else {
                        isSurvived = false;
                        healths[index] = 0; // explode
                        healths[topIndex] = 0; // explode
                        stack.pop(); // remove topIndex from stack
                        break;
                    }
                }
                if (isSurvived) {
                    stack.push (index); // left dir Robot
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add (healths[i]);
            }
        }
        return res;
    }
}
