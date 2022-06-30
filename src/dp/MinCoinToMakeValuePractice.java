package dp;

import java.util.stream.IntStream;

public class MinCoinToMakeValuePractice {

    public static void main(String[] args) {
        System.out.println(minCoin(IntStream.of(25, 10, 5).toArray(), 30));
        System.out.println(minCoin(IntStream.of(25).toArray(), 26));
        System.out.println(minCoin(IntStream.of(9, 6, 5, 1).toArray(), 11));
    }

    private static int minCoin(int[] coins, int val) {

        // Integer.MAX_VALUE - 1 is needed else returning Integer.MAX_VALUE and adding 1 will make it an Integer.min_val
        // and Integer.min_val will always be returned for all scenarios because there is a Math.min operation.
        if (val < 0) return Integer.MAX_VALUE - 1;
        if (val == 0) return 0;

        int result = Integer.MAX_VALUE - 1;
        for (int coin : coins) {
            result = Math.min(result, minCoin(coins, val - coin) + 1);
        }

        return result;

    }
}
