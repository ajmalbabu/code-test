package tree;

import tree.HeightBinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {

        System.out.println("LevelOrder");
        levelOrder(null);
        System.out.println("");
        levelOrder(new Node(10, new Node(20, new Node(8), new Node(7, new Node(9), new Node(15))), new Node(30, null, new Node(6))));
        System.out.println("");

    }

    static void levelOrder(Node node) {
        if (node == null) return;
//        Queue<Node> queue = new ConcurrentLinkedDeque<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while ((node = queue.poll()) != null) {
            System.out.print(node.data + ",");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

}
