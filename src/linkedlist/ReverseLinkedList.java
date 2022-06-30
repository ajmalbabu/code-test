package linkedlist;

public class ReverseLinkedList {


    public static class ListNode {
        public int data;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.data = val;
        }

        public ListNode(int val, ListNode next) {
            this.data = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return data + "->" + next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Reverse linked list");
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(head);
        System.out.println(reverse(head));
        System.out.println((ListNode)null);

    }

    // 1->2->3->4->null
    // 4->3->2->1->null;
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}

