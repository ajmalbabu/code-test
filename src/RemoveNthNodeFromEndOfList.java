// 11.06

import java.util.List;

// https://leetcode.com/problems/simplify-path/
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || n == 0) {
            return head;
        }

        ListNode runner = head;
        int length = 1;
        while (runner.next != null) {
            length++;
            runner = runner.next;
        }

        if (n > length) {
            return head;
        }

        if (n == length) {
            head = head.next;
            return head;
        }

        runner = head;
        for (int i = 1; i < length - n; i++) {
            runner = runner.next;
        }
        ListNode nodeToRemove = runner.next;

        if (nodeToRemove != null) {
            runner.next = nodeToRemove.next;
        }
        return head;
    }


    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
