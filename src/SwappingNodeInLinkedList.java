// 3:24

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class SwappingNodeInLinkedList {

    public static void main(String[] args) {


        ListNode head = new ListNode(100, new ListNode(90,null));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        System.out.println(new SwappingNodeInLinkedList().swapNodes(head, 2));
    }

    public ListNode swapNodes(ListNode head, int k) {

        if (head == null || k == 0) return head;

        ListNode runner = head;
        int length = 1;
        while (runner.next != null) {
            length++;
            runner = runner.next;
        }

        if (k > length) return head;

        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode second = head;
        for (int i = 0; i < length - k; i++) {
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

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


//    ListNode ans = head, last=head, first;
//        for(int i=1;i<k;i++) head=head.next;
//        first = head;
//        while(head.next!=null){
//        head=head.next;
//        last=last.next;
//        }
//        // swapping
//        int temp = first.val;
//        first.val=last.val;
//        last.val=temp;
//
//        return ans;