package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

// https://practice.geeksforgeeks.org/batch/cip-1/track/P100-DP/problem/max-sum-subarray-by-removing-at-most-one-element
public class MaxSumSubarray {

    // 8,-2,3,-4,-2,3,4,4
    // 8,-2,3,-4,-2,-3,1,5,4
    // 8,-2,-6,-7,1
    // -8,-9,-10
    // -8,-5,-7
    // 4,-7,-2,7,2,1,-3,2,3

    // -3,-2,1,3,4,-8,100
    // 1,-2,1,1,2,-1,3

    public static void main(String[] args) {
        System.out.println(maxSumSubarray(IntStream.of(-39, -69, -18, -45).toArray(), 5) == -18); // -18
        System.out.println(maxSumSubarray(IntStream.of(-2, -3, 4, -1, -2, 1, 5, -3).toArray(), 8) == 9); // 9
        System.out.println(maxSumSubarray(IntStream.of(-2, -3, 4, -1, -2, 1, 5, -3, -8, -1, -12).toArray(), 8) == 9); // 9
        System.out.println(maxSumSubarray(IntStream.of(5, -2, 5, 5, -1, 5).toArray(), 5) == 19); // 19
        System.out.println(maxSumSubarray(IntStream.of(5, -8, 5, 5, -1, 5).toArray(), 5) == 19); // 19
        System.out.println(maxSumSubarray(IntStream.of(4, -7, -2, 7, 2, 1, -3, 2, 3).toArray(), 5) == 15); // 15
        System.out.println(maxSumSubarray(IntStream.of(511, -824, 584, 568, -309, 526).toArray(), 5) == 1880); // 1880
        System.out.println(maxSumSubarray(IntStream.of(1, 2, 3, -4, 5).toArray(), 5) == 11); // 11
        System.out.println(maxSumSubarray(IntStream.of(437, -757, -57, 711, 236, 127, -397, 168, 722).toArray(), 8) == 1964); // 1964
        System.out.println(maxSumSubarray(IntStream.of(3, 4, -4, 7, -6, -8, 11, 25, 9, 5).toArray(), 5) == 54);
        System.out.println(maxSumSubarray1(IntStream.of(-100, -20 ,18, -42, -50, 55 ,61, -36 ,3 ,-24 ,-57 ,9, 2, 61, -11 ,48 ,-18 ,-47 ,-26, -80, -98, 23, -69, 69, -22, -41, -92, -81 ,71).toArray(), 5) == 168); // 168

    }

    public static int maxSumSubarray(int[] arr, int n) {
        Sum[] sums = new Sum[arr.length];
        int right = -1, maxSum = Integer.MIN_VALUE;

        for (int e : arr) {
            if (e > 0)
                right++;

            for (int i = right; i >= 0; i--) {
                if (sums[i] == null) sums[i] = new Sum();
                if (e < 0) {
                    if (sums[i].currLow == 0) {
                        sums[i].currLow = e;
                    } else if (e < sums[i].currLow) {
                        sums[i].currSum += sums[i].currLow;
                        sums[i].currLow = e;
                    } else {
                        sums[i].currSum += e;
                    }
                } else {
                    sums[i].currSum += e;
                }
                if (sums[i].currSum > maxSum) maxSum = sums[i].currSum;
            }

            if (e > maxSum) maxSum = e;
        }
        return maxSum;
    }

    // optimized ver, but failing for some reason.
    // -100 -20 18 -42 -50 55 61 -36 3 -24 -57 9 2 61 -11 48 -18 -47 -26 -80 -98 23 -69 69 -22 -41 -92 -81 71
    // expected result 168 output from below code is 190
    // A better optimization could be to store Sums in an ArrayList<Sum>, then while looping through each time to add a new value
    //  look for any of the Sum.currSum < 0 objects, track all such Sum objects and perform  arrayList.removeAll(toDelete) after the loop.
    public static int maxSumSubarray1(int[] arr, int n) {
        Sum[] sums = new Sum[arr.length];
        int right = -1, maxSum = Integer.MIN_VALUE;

        for (int e : arr) {
            if (e > 0)
                right++;

            for (int i = right; i >= 0; i--) {
                if (sums[i] == null) sums[i] = new Sum();
                if (e < 0) {
                    if (sums[i].currLow == 0) {
                        sums[i].currLow = e;
                    } else if (e < sums[i].currLow) {
                        sums[i].currSum += sums[i].currLow;
                        sums[i].currLow = e;
                    } else {
                        sums[i].currSum += e;
                    }
                } else {
                    sums[i].currSum += e;
                }
                if (sums[i].currSum > maxSum) maxSum = sums[i].currSum;
            }

            // If current right > prev slot, move current right to left slot
            // Optimized ver, this process allow to ignore all lower slots
            for (int i = right; i >= 0; i--) {
                if (i != 0 && sums[i].currSum >= sums[i - 1].currSum) {
                    sums[i - 1] = sums[i];
                    sums[i] = null;
                    right--;
                }
            }
            if (e > maxSum) maxSum = e;
        }
        return maxSum;
    }


    static class Sum {
        int currSum;
        int currLow;
    }


}
