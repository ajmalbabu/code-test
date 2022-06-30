package tree;

import linkedlist.ReverseLinkedList.ListNode;

import static tree.HeightBinaryTree.Node;

public class BinaryTreeToDLL {

    private static final int HEAD = 0;
    private static final int TAIL = 1;

    static class Node1 {
        Node1 left, right;
        int data;

        Node1(int d) {
            data = d;
            left = right = null;
        }

        Node1(int d, Node1 left, Node1 right) {
            data = d;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return data + "->" + right;
        }
    }


    public static void main(String[] args) {
        System.out.println("BinaryTreeToDLL");
        ListNode listNode = bToDLL2(new Node(10, new Node(12, new Node(25), new Node(30)), new Node(15, new Node(36), null)), new Response());
        System.out.println(listNode);
        Node1 node1 = bToDLL(new Node1(10, new Node1(12, new Node1(25), new Node1(30)), new Node1(15, new Node1(36), null)));
        System.out.println(node1);
//        Node1 node1 = bToDLL(new Node1(1, new Node1(3), new Node1(2)));
//        System.out.println(node1);

    }

    public static Node1 bToDLL(Node1 root) {

        Node1[] pair = bToDLL1(root);
        return pair != null ? pair[HEAD] : null;
    }

    public static Node1[] bToDLL1(Node1 root) {

        Node1[] pair = null;

        if (root != null) {
            Node1[] otherPair = bToDLL1(root.left);
            Node1 newNode = new Node1(root.data);
            if (otherPair == null) {
                pair = new Node1[2];
                pair[HEAD] = newNode;
                pair[TAIL] = newNode;
            } else {
                otherPair[TAIL].right = newNode;
                newNode.left = otherPair[TAIL];
                otherPair[TAIL] = newNode;
                pair = otherPair;
            }
            otherPair = bToDLL1(root.right);
            if (otherPair != null) {
                pair[TAIL].right = otherPair[HEAD];
                otherPair[HEAD].left = pair[TAIL];
                pair[TAIL] = otherPair[TAIL];
            }
        }
        return pair;
    }

    public static ListNode bToDLL2(Node node, Response response) {

        if (node != null) {
            bToDLL2(node.left, response);
            ListNode newNode = new ListNode(node.data);
            if (response.tail == null) {
                response.head = newNode;
                response.tail = newNode;
            } else {
                response.tail.next = newNode;
                newNode.prev = response.tail;
                response.tail = newNode;
            }
            bToDLL2(node.right, response);
        }
        return response.tail == null ? null : response.head;
    }

    static class Response {
        ListNode head;
        ListNode tail;
    }
}
