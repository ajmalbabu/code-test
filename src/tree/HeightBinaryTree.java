package tree;

public class HeightBinaryTree {

    public static class Node implements Comparable<Node> {
        public int data;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int k) {
            data = k;
            left = right = null;
        }

        public Node(int key, Node left, Node right) {
            this.data = key;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return data + ",L" + left + ",R" + right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return data == node.data;
        }

        @Override
        public int hashCode() {
            return data;
        }

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
    }

    public static void main(String[] args) {
        System.out.println("HeightBinaryTree");
        System.out.println(height(null));
        System.out.println(height(new Node((10))));
        System.out.println(height(new Node(10, new Node(8), new Node(30, new Node(40), new Node(50, new Node(70), null)))));
        System.out.println(height(new Node(30, new Node(40, new Node(70, new Node(80), null), null), new Node(60))));
    }

    static int height(Node tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }
}
