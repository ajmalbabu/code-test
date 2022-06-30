package tree;

import tree.HeightBinaryTree.Node;

public class PrintNodeAtKDistance {
    public static void main(String[] args) {
        System.out.println("PrintNodeAtKDistance");
        printNodesAt(null, 0);
        printNodesAt(new Node(5), 0);
        System.out.println("");
        printNodesAt(new Node(10, new Node(20, new Node(30), null), null), 1);
        System.out.println("");
        printNodesAt(new Node(10, new Node(20, new Node(40), new Node(50)), new Node(30, null, new Node(70))), 2);
        System.out.println("");
        printNodesAt(new Node(10, new Node(20, new Node(40), new Node(50)), new Node(30, null, new Node(70))), 8);
        System.out.println("");
        printNodesAt(new Node(10, new Node(6), new Node(8, null, new Node(7, new Node(11), new Node(12)))), 3);
        System.out.println("");

    }

    static void printNodesAt(Node root, int distance) {
        if (root == null) return;
        if (distance == 0) {
            System.out.print(root.data + ",");
        } else {
            printNodesAt(root.left, distance - 1);
            printNodesAt(root.right, distance - 1);
        }

    }
}
