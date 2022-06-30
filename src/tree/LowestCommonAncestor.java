package tree;

import static tree.HeightBinaryTree.*;

public class LowestCommonAncestor {


    public static void main(String[] args) {
        System.out.println("LowestCommonAncestor");
        System.out.println(lca(null, 1, 2));
        System.out.println(lca(new Node(10), 1, 2));
        System.out.println(lca(new Node(1, new Node(2), new Node(3)), 2, 3));
        System.out.println(lca(new Node(5, new Node(2, new Node(3), new Node(4)), null), 2, 4));
        System.out.println(lca(new Node(5, new Node(2, new Node(3), new Node(4)), null), 2, 7));

        System.out.println(lca(new Node(5, new Node(2, new Node(3), new Node(4)), null), 2, 4));


    }

    static Node lca(Node node, int n1, int n2) {
        return lca1(node, new NodeSearch(), n1, n2);
    }

    private static Node lca1(Node node, NodeSearch nodeSearch, int n1, int n2) {

        if (node == null) return null;

        boolean prevNoneFound = nodeSearch.foundNone();

        if (node.data == n1)
            nodeSearch.foundN1 = true;
        if (node.data == n2)
            nodeSearch.foundN2 = true;

        if (!nodeSearch.foundBoth()) { // optimization block
            Node curr = lca1(node.left, nodeSearch, n1, n2);
            if (curr != null)
                return curr;

            if (!nodeSearch.foundBoth()) { // optimization block
                curr = lca1(node.right, nodeSearch, n1, n2);
                if (curr != null)
                    return curr;
            }
        }

        if (prevNoneFound && nodeSearch.foundBoth())
            return node;

        return null;

    }


    static class NodeSearch {

        boolean foundN1;
        boolean foundN2;


        private boolean foundBoth() {
            return foundN1 && foundN2;
        }

        private boolean foundNone() {
            return !foundN1 && !foundN2;
        }

    }
}
