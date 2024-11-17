package com.keshav.BinarySearching.BinarySearchOnAnswer;

import java.lang.management.MemoryType;

public class AllocationOfBooks {
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        System.out.println(bookAllocation(books, students));
    }
    static int n;
    private static int bookAllocation(int[] books, int students) {
        n = books.length;
        if (n < students) {
            return -1;
        }
        // range will be max of array and sum of array
        // max pages in a books array
        int start = Integer.MIN_VALUE;
        // sum of books array
        int end = 0;
        int res = -1;

        for (int page : books) {
            start = Math.max(start, page);
            end += page;
        }

        // binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if allocation is possible, then minimize the number of pages (left search space)
            if (isAllocationPossible(books, mid, students)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private static boolean isAllocationPossible(int[] books, int maxPages, int students) {
        int currentStudent = 1;
        int pages = 0;

        for (int page : books) {
            pages += page;
            // if pages exceed than maxPages
            if (pages > maxPages) {
                // allocate to next student
                ++currentStudent;
                pages = page;
            }
            if (currentStudent > students) {
                return false;
            }
        }
        return true;
    }

}
