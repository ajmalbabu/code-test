package hash;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(0, 3, 2, 1, 1, 1, 1, 1, 8).toArray(), 4));
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(1, -1, 1, 1, 1, -1, -1, -1).toArray(), 0));
        System.out.println(longestSubArrayWithGivenSum(IntStream.of(1, -1, 1, -1).toArray(), 0));

    }

    private static int longestSubArrayWithGivenSum(int[] arr, int sum) {
        Set<Integer> cumulatives = new HashSet<>();
        int arrLength = 0, currArrLength = 0, cumSum = 0, currCumSum = 0;
        cumulatives.add(0);
        for (int e : arr) {
            cumSum += e;
            currCumSum += e;
            if (currCumSum > sum) {
                currCumSum = e;
                currArrLength = 0;
            }
            currArrLength++;
            if (cumulatives.contains(cumSum - sum)) {
                if (currArrLength > arrLength)
                    arrLength = currArrLength;
                currArrLength = 0;
                currCumSum = 0;
            }
            cumulatives.add(cumSum);
        }
        return arrLength;
    }


}
