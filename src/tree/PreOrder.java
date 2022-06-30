package tree;

import static tree.HeightBinaryTree.Node;

//        10
//   20         30
//          40      50

// 10 20 30 40 50
public class PreOrder {
    public static void main(String args[]) {
        preOrder(new Node(10, new Node(20), new Node(30, new Node(40), new Node(50))));
        System.out.println();

    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
