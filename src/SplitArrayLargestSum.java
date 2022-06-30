// https://leetcode.com/problems/split-array-largest-sum/

// 3:58

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SplitArrayLargestSum {

    public static void main(String[] args) {

//        int[] nums = {7, 2, 5, 10, 8};
        int[] nums = {9, 8, 10, 1};
//        int[] nums = {1, 2, 3};
        System.out.println(new SplitArrayLargestSum().splitArrayBest(nums, 2));
    }


    public int splitArray(int[] nums, int m) {
        return splitArray1(nums, m, new TreeMap<>());
    }

    private int splitArray1(int[] nums, int m, Map<Integer, Integer> memo) {

        Integer memoKey = memoKey(nums, m);
        Integer v = memo.get(memoKey);
        if (v != null) return v;

        if (m == 1)
            return Arrays.stream(nums).sum();

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            int r1 = splitArray1(Arrays.copyOfRange(nums, 0, i + 1), 1, memo);
            int r2 = splitArray1(Arrays.copyOfRange(nums, i + 1, nums.length), m - 1, memo);
            max = Math.min(Math.max(r1, r2), max);
            if (r1 > r2) break;
        }

        memo.put(memoKey, max);
        return max;
    }

    private Integer memoKey(int[] nums, Integer m) {
        int memoKey = 0;
        for (int i = 0; i < nums.length; i++) {
            memoKey += 31 * nums[i];
        }
        memoKey += m;
        return memoKey;
    }

    // Leet code best solution

    public int splitArrayBest(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int i : nums) {
            left = Math.max(left, i);
            right += i;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, mid, m)) right = mid;
            else left = mid + 1;
        }
        return left;

    }

    public boolean canSplit(int[] nums, int sum, int m) {
        int count = 1;
        int total = 0;

        for (int i : nums) {
            total += i;
            if (total > sum) {
                total = i;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }

}


