package dp;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CountWaysToReachNStair {

    static Map<Integer, Integer> memo = new TreeMap<>();

    static int loopCount = 0;

    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWaysStack(4));
        memo.clear();
        loopCount = 0;
        System.out.println(countWays(20));
        System.out.println("Loop Count: " + loopCount);
        memo.clear();
        System.out.println(countWaysStack(20));

    }

    static int countWays(int n) {
        loopCount++;
        if (memo.get(n) != null) return memo.get(n);
        if (n < 0) return 0;
        if (n == 0) return 1;
        int res = countWays(n - 2);
        res += countWays(n - 1);
        memo.put(n, res);
        return res;
    }

    static Map<Integer, Integer> stackLength = new TreeMap<>();

    static int countWaysStack(int n) {

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        // 4, 2,    3,      1,      2,      1

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (v - 2 == 0 || v - 1 == 0)
                count++;

            if (v - 2 > 0)
                stack.push(v - 2);

            if (v - 1 > 0)
                stack.push(v - 1);

        }

        return count;

    }
}
