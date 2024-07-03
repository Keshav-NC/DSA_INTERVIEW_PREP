package com.keshav.SDE.LeetDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArray_2 {
    public static void main(String[] args) {
        int[] n = {2, 1};
        int[] m = {1, 2};
        System.out.println(Arrays.toString(intersect(n, m)));
    }


    static int[] intersect (int[] n, int[] m) {
        Set<Integer> mSet = new HashSet<>();
        // remove duplicates from nums2
        for (int i=0;i<m.length;i++) {
            if (!mSet.contains(m[i])) {
                mSet.add(m[i]);
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0;i<n.length;i++) {
            for (int ele : mSet) {
                if (n[i] == ele) {
                    temp.add(ele);
                }
            }
        }
        int[] ans = new int[temp.size()];
        int i = 0;
        for (int ele : temp) {
            ans[i++] = ele;
        }
        return ans;
    }
}
