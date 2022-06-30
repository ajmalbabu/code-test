package dp;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class MinCoinToMakeValue {

    static Map<Integer, Integer> cutHist = new TreeMap<>();
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(minCoin(30, IntStream.of(25, 10, 5).toArray()));
        System.out.println(minCoin(11, IntStream.of(9, 6, 5, 1).toArray()));
        System.out.println(minCoin(11, IntStream.of(9, 6, 6, 1).toArray()));
        System.out.println(minCoin(11, IntStream.of(1,2).toArray()));
        System.out.println(minCoin(11, IntStream.of(1).toArray()));
        System.out.println(minCoin(11, IntStream.of(9, 6, 8, 4).toArray()));

    }

    // IMP - A great solution exists with dynamic array based solution, consider all value less than the array,
    // take each value subtract and go to the index and add one to it
    // consider minimum of all such operation

    static int minCoin(int n, int[] sizes) {

        int res = Integer.MAX_VALUE;
        for (int size : sizes) {
            if (n - size >= 0) {

                int curr = 0;
                if (n - size > 0)
                    curr = minCoin(n - size, sizes);
                if (curr != Integer.MAX_VALUE)
                    res = Math.min(res, 1 + curr);
            }
        }

        return res;
    }
}
