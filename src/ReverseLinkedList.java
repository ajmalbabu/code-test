// 3:24

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        System.out.println(new ReverseLinkedList().reverse(head));
    }

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode prev = null, curr = head;

        while (curr.next != null) {
            head = curr.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        curr.next = prev;

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

