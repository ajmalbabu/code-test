package dp;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.naturalOrder;

public class CoinChange {

    //    static Map<Integer, Integer> sums = new HashMap<>();
    static Map<String, Integer> sums = new HashMap<>();

    static int[][] combination = new int[4][11];

    static Map<String, Integer> combinationMap = new HashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            Arrays.fill(combination[i], -1);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(combination[i]));
        }

//        System.out.println(coinChange(IntStream.of(2, 5, 3, 6).toArray(), 10, new ArrayList<>()));
//        System.out.println(sums.keySet());

        System.out.println(coinChange(IntStream.of(2, 5, 3, 6).toArray(), 3, 10));

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(combination[i]));
        }

        int[] coins = IntStream.of(2, 5, 3, 6).toArray();


        System.out.println("Count: " + count);

    }

    static int count = 0;

    static int coinChange(int[] coins, int coinIdx, int sum) {

        count++;

        if (coinIdx < 0) return 0;
//        if (combinationMap.get(index + "" + sum) != null) return combinationMap.get(index + "" + sum);
        if (combination[coinIdx][sum] != -1) return combination[coinIdx][sum];
        if (sum == 0) return 1;

        int res = coinChange(coins, coinIdx - 1, sum);

        if (sum - coins[coinIdx] >= 0)
            res += coinChange(coins, coinIdx, sum - coins[coinIdx]);
        combination[coinIdx][sum] = res;
//        combinationMap.put(index + "" + sum, res);
        return res;
    }


    // Set also would work instead of List, that will avoid the sort on List
    // below, but downside is that it will only have one element e.g.
    // instead of 2,2,2,2,2 it will only have 2 since it is unique.
    static int coinChange(int[] coins, int sum, List<Integer> combination) {

        combination.sort(naturalOrder());
        if (sums.get(combination.toString()) != null) {
            return sums.get(combination.toString());
        }
        if (sum == 0) {
            sums.put(combination.toString(), 1);
            return 1;
        }
        if (sum < 0)
            return -1;
        for (int coin : coins) {
            List<Integer> v = new ArrayList<>(combination); // Imp, else prev
            // residue carry
            v.add(coin);
            coinChange(coins, sum - coin, v);
        }
        return sums.size();
    }

//    static int coinChange(int[] coins, int sum) {
//
//        if (sums.get(sum) != null) return sums.get(sum);
//        if (sum == 0)
//            return 1;
//        if (sum < 0)
//            return -1;
//        int result = 0;
//        for (int coin : coins) {
//            int temp = coinChange(coins, sum - coin);
//            if (temp != -1)
//                result += temp;
//        }
//        sums.put(sum, result);
//        return result;
//    }
}
