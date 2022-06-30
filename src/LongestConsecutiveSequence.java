// https://leetcode.com/problems/longest-consecutive-sequence/discuss/1151403/Java-Simple-Solution

import java.util.HashSet;
import java.util.Set;


// Push all the elements in a set.
// Iterate over the elements in nums array and check for it's existence in set.
// If element exists then check upper and lower boundary.
// Update max if computed boundary exceeds max boundary.

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) set.add(num);
        int max = 0;
        for(int num : nums) {
            if(!set.contains(num)) continue;
            int low = num - 1;
            while(set.remove(low)) low--;
            int high = num + 1;
            while(set.remove(high)) high++;
            max = Math.max(max, high - low - 1);
        }
        return max;
    }
}
