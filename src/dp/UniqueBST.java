package dp;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class UniqueBST {

    static Map<Integer, Integer> combinations = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(3));
        System.out.println(numTrees(5));
        System.out.println(numTrees(7));
        System.out.println(numTrees(384));
    }

    static int numTrees(int n) {

        combinations.put(0, 1);
        combinations.put(1, 1);
        combinations.put(2, 2);
        for (int i = 3; i <= n; i++) {
            int current = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                current += combinations.get(left) * combinations.get(right);
            }
            combinations.put(i, current);
        }
        return combinations.get(n);

        //  java int range is:
        // -214,748,3648
        //  214,748,3647

        //  my code (1st row) and actual (2nd row)
        // -277,179,108
        //  696,991,831

    }
}
