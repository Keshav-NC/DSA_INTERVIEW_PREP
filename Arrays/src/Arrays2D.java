import java.util.Arrays;
import java.util.Scanner;


public class Arrays2D {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5},
//                {6, 7, 8, 9}
//        };
//
//        for (int[] ele : arr) {
//            System.out.println(Arrays.toString(ele));
//        }

//        //Swapping using index
//
//        int[] arr = {1, 60, 36, 35};
//        System.out.println(Arrays.toString(arr));
//        swap(arr, 1, 2);
//        System.out.print(Arrays.toString(arr));

        //Maximum  number of array

        int[] arr = {1, 90, 45, 99, 30, 40, 100};
//        int res = mavValue(arr);
//        int res = mavValueRange(arr, 1, 3);
//        System.out.println(res);
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArray (int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end ) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static int mavValueRange(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    static int mavValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }


    static void swap (int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static class ArrayLists {
        public static void main(String[] args) {
    //        ArrayList<Integer> list = new ArrayList<>(10);
            Scanner in = new Scanner(System.in);
    //        list.add(10);
    //        list.add(20);
    //        list.add(30);
    //        list.add(40);
    //        list.add(50);
    //        list.add(60);
    //        list.add(70);
    //        list.add(80);
    //        list.add(90);
    //        list.add(100);
    //        list.add(110);
    //        list.add(120);
    //        System.out.println(list);
            // ArrayList initialization
    //        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    //        for (int i = 0; i < 3; i++) {
    //            list.add(new ArrayList<>()); // Initialization
    //        }
    //
    //      //adding elements into the arrayList
    //        for (int i = 0; i < 3; i++) {
    //            for (int j = 0; j < 3; j++) {
    //            list.get(i).add(in.nextInt());
    //            }
    //        }
    //
    //        System.out.println(list);





        }
    }
}
