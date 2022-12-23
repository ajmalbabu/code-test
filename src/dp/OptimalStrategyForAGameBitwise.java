package dp;

import java.util.HashMap;
import java.util.Map;
//import java.util.stream.IntStream;

public class OptimalStrategyForAGameBitwise {

    static Map<String, Long> cache = new HashMap<>();
    final static int PLAYER1 = 0;
    final static int PLAYER2 = 1;

    public static void main(String[] args) {
        System.out.println(optimalStrategyForAGame(java.util.stream.IntStream.of(20, 5, 4, 6).toArray())); //  25
        System.out.println(optimalStrategyForAGame(java.util.stream.IntStream.of(2, 3, 15, 7).toArray())); //  17

        int a = 32;
        int b = 64;
        long l = (((long) a) << 32) | (b & 0xffffffffL);
        int x = (int) (l >> 32);
        int y = (int) l;

        System.out.println(x + "  " + y);
    }

    private static int optimalStrategyForAGame(int[] arr) {
        cache.clear();
        return (int) (optimalStrategyForAGame(arr, 0, arr.length) >> 32);
    }

    private static long optimalStrategyForAGame(int[] arr, int start, int end) {

        long result = 0;
        if (cache.get(start + "-" + end) != null) return cache.get(start + "-" + end);
        if (end - start == 2) {
            if (arr[start] > arr[start + 1]) {
                result = (((long) arr[start]) << 32) | (arr[end - 1] & 0xffffffffL);
            } else {
                result = (((long) arr[end - 1]) << 32) | (arr[start] & 0xffffffffL);
            }
        } else {
            long right = optimalStrategyForAGame(arr, start + 1, end);
            long left = optimalStrategyForAGame(arr, start, end - 1);
            if (arr[start] + (int) right > arr[end - 1] + (int) left) {
                result = (((long) arr[start] + (int) right) << 32) | ((int) (right >> 32) & 0xffffffffL);
            } else {
                result = (((long) arr[end - 1] + (int) left) << 32) | ((int) (left >> 32) & 0xffffffffL);
            }
        }
        cache.put(start + "-" + end, result);
        return result;

    }

}
