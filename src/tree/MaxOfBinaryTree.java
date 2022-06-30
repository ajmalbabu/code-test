package tree;

import tree.HeightBinaryTree.Node;

public class MaxOfBinaryTree {

    public static void main(String args[]) {
        System.out.println("MaxOfBinaryTree");
        System.out.println(max(null));
        System.out.println(max(new Node((10))));
        System.out.println(max(new Node(10, new Node(8), new Node(30, new Node(40), new Node(50, new Node(70), null)))));
        System.out.println(max(new Node(30, new Node(40, new Node(70, new Node(80), null), null), new Node(60))));
    }

    public static int max(Node node) {
        if (node == null) return 0;
        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }
}
