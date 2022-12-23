package hash;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class LongestSubArrayWithGivenSumGood {

    public static void main(String[] args) {
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(0, 3, 2, 1, 1, 1, 1, 1, 0).toArray(), 4));
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(0, 3, 2, 1, 1, 1, 1, 1, 8).toArray(), 4));
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(1, -1, 1, 1, 1, -1, -1, -1).toArray(), 0));
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(1, -1, 1, -1).toArray(), 0));
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(3, 1, 2, 1, 1, 1, 0, 0, -1, 1, 3, 1, 2, 1, 2, -3, 0).toArray(), 3));


        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(1, 0, 1, 1, 0).toArray())); // 4
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 0).toArray())); // 2
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0).toArray())); // 2
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0, 0, 0).toArray())); // 8
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 0, 0, 1, 1, 0, 0, 1, 1, 1).toArray())); // 10
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 0, 1).toArray())); // 4
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 0, 1, 1).toArray())); // 4
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(1, 0, 1, 1, 1, 0, 0).toArray())); // 6


    }

    private static int longestSubArrayWithGivenSum(int[] arr, int sum) {
        int length = 0, cum = 0, index = 0;
        Map<Integer, Integer> indexes = new TreeMap<>();
        indexes.put(0, 0);
        for (int e : arr) {
            cum += e;
            index++;
            if (indexes.get(cum - sum) != null) {
                int curr = index - indexes.get(cum - sum);
                if (curr > length)
                    length = curr;
            } else {
                indexes.put(cum, index);
            }

        }
        return length;
    }

    private static int longestSubArrayWithEqualZerosAndOnes(int[] arr) {
        int length = 0, cum = 0, index = 0;
        Map<Integer, Integer> indexes = new TreeMap<>();
        indexes.put(0, 0);
        for (int e : arr) {
            if (e == 0)
                cum += -1;
            else
                cum += +1;
            index++;
            if (indexes.get(cum) != null) {
                int curr = index - indexes.get(cum);
                if (curr > length)
                    length = curr;
            } else {
                indexes.put(cum, index);
            }

        }
        return length;
    }


}
