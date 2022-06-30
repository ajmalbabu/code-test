package tree;

import static tree.HeightBinaryTree.Node;

// Aux space O(h)
public class SizeOfBinaryTree {
    public static void main(String args[]) {
        System.out.println("SizeOfBinaryTree");
        System.out.println(size(null));
        System.out.println(size(new Node((10))));
        System.out.println(size(new Node(10, new Node(8), new Node(30, new Node(40), new Node(50, new Node(70), null)))));
        System.out.println(size(new Node(30, new Node(40, new Node(70, new Node(80), null), null), new Node(60))));
    }

    public static int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);

    }
}
