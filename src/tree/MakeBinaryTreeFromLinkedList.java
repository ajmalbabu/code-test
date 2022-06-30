package tree;

import linkedlist.ReverseLinkedList.ListNode;

import java.util.LinkedList;
import java.util.Queue;

import static tree.HeightBinaryTree.Node;

public class MakeBinaryTreeFromLinkedList {


    public static void main(String[] args) {
        System.out.println("MakeBinaryTreeFromLinkedList");
        Node tree = new Node();
        convert(new ListNode(30, new ListNode(92, new ListNode(91, new ListNode(17, new ListNode(95))))), tree);
        System.out.println(tree);

    }

    public static Node convert(ListNode head, Node node) {
        if (head == null || node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        node.data = head.data;
        queue.add(node);
        while (queue.size() > 0) {
            Node curr = queue.remove();
            if (head.next == null)
                break;
            head = head.next;
            curr.left = new Node(head.data);
            queue.add(curr.left);
            if (head.next == null)
                break;
            head = head.next;
            curr.right = new Node(head.data);
            queue.add(curr.right);
        }

        return node;
    }
}
