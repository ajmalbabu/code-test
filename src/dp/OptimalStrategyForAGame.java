package dp;

import java.util.HashMap;
import java.util.Map;
//import java.util.stream.IntStream;

public class OptimalStrategyForAGame {

    static Map<String, int[]> cache = new HashMap<>();
    final static int PLAYER1 = 0;
    final static int PLAYER2 = 1;

    public static void main(String[] args) {
        System.out.println(optimalStrategyForAGame(java.util.stream.IntStream.of(20, 5, 4, 6).toArray())); //  25
        System.out.println(optimalStrategyForAGame(java.util.stream.IntStream.of(2, 3, 15, 7).toArray())); //  17
    }

    private static int optimalStrategyForAGame(int[] arr) {
        cache.clear();
        return optimalStrategyForAGame(arr, 0, arr.length)[PLAYER1];
    }

    private static int[] optimalStrategyForAGame(int[] arr, int start, int end) {

        int[] result = null;
        if (end - start == 2) {
            if (arr[start] > arr[start + 1]) {
                result = java.util.stream.IntStream.of(arr[start], arr[end - 1]).toArray();
            } else {
                result = java.util.stream.IntStream.of(arr[end - 1], arr[start]).toArray();
            }
        } else {
            int[] right = optimalStrategyForAGame(arr, start + 1, end);
            int[] left = optimalStrategyForAGame(arr, start, end - 1);
            if (arr[start] + right[PLAYER2] > arr[end - 1] + left[PLAYER2]) {
                result = java.util.stream.IntStream.of(arr[start] + right[PLAYER2], right[PLAYER1]).toArray();
            } else {
                result = java.util.stream.IntStream.of(arr[end - 1] + left[PLAYER2], left[PLAYER1]).toArray();
            }
        }
        cache.put(start + "-" + end, result);
        return result;

    }

}
