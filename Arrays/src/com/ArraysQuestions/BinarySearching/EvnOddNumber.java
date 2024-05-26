package com.ArraysQuestions.BinarySearching;

public class EvnOddNumber {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896, 44, 88};
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            int rem = 0;
            while (nums[i] > 0) {
                rem = nums[i] % 10;
                nums[i] /= 10;
            }
            if (nums[i] % 2 == 0) count++;
        }
        System.out.println(count);

//        int ans = findNumbers(nums);
//        System.out.println(ans);


    }
    static int findNumbers(int[] nums){
        int counter = 0;
        for(int i = 0 ; i < nums.length; i++){
            int res = Integer.toString(nums[i]).length();
            if(res % 2 == 0){
                counter++;
            }
            if (Integer.toString(nums[i]).length() == 0) counter++;
        }
        return counter;
    }
}
