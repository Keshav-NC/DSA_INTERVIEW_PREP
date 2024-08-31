package com.keshav.LinkedList.Questions;

import com.keshav.LinkedList.LL;

import java.awt.dnd.DropTarget;

public class SortLL {
    public static void main(String[] args) {
        ListNode list = new ListNode();

    }


    public static ListNode mergeSort (ListNode head) {
        if (head == null || head.next != null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left, right);
    }

    // merge sorted lists
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
            while (l1 != null) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            while (l2 != null) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        temp.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }

    // bubble sort
    public void bubble (int row, int col, ListNode head) {
        if (row == 0) {
            return;
        }
        LL list = new LL();
        if (col < row) {
            ListNode first = get(col, head);
            ListNode second = get(col + 1, head);
            ListNode tail = getTail(head);

            if (first.val > second.val) {
                // case 1: head
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }

                // case 2: tail or last
                else if (second == tail) {
                    ListNode prevNode = get(col - 1, head);
                    prevNode.next = second;
                    second.next = first;
                    first.next = null;
                    tail = first;
                }

                // case 3 : middle
                else {
                    ListNode prevNode = get(col - 1, head);
                    prevNode.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubble(row, col + 1, head);
        } else {
            bubble(row - 1, 0, head);
        }

    }

    // get the reference of a particular node
    private static ListNode get (int index, ListNode head) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // get tail
    private static ListNode getTail (ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
        }
        return temp;
    }

    // get the middle node
    private static ListNode getMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        // when this breaks, slow will be the mid, return slow
        while (fast != null && fast.next != null) {
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        // Note: temp keeps track just before mid(slow), so the first half --> head to temp and second half slow to fast
        temp.next = null; // breaking the list into half, i.e., the list breaks just before the mid
        return slow;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
