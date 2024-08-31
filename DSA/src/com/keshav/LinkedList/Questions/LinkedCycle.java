package com.keshav.LinkedList.Questions;

import com.keshav.LinkedList.LL;

public class LinkedCycle {
    public static void main(String[] args) {
    }

    // Amazon and Microsoft questions
    public  static boolean cycle (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // move step 2
            slow = slow.next; // move step 1

            if (slow == fast) { // cycle
                return true;
            }
        }
        return false; // no cycle
    }

    public static int cycleLength (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                // calculate the length
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    ++length;
                } while (slow != temp);
            }
        }
        return length;
    }

    public static ListNode detectCycle (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                // find the cycle length --> 1
                length = cycleLength(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        // find the start node --> 2
        while (length > 0) {
            second = second.next;
            length--;
        }
        // keep moving both the pointers, they meet at cycle start --> 3
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first; // first or second
    }


    public static boolean happy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow); // 1 step
            fast = findSquare(findSquare(fast)); // 2 step
        } while (slow != fast);

        return slow == 1;
    }

    private static int findSquare (int num) {
        int ans = 0;

        while (num > 0) {
            int digit = num % 10;
            ans += digit * digit;
            num /= 10;
        }
        return ans;
    }

    // class ListNode
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
