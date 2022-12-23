package hash;

import java.util.*;
import java.util.stream.IntStream;

public class LongestSubArrayWithEqualZerosAndOnesGood {

    public static void main(String[] args) {

        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(1, 0, 1, 1, 0).toArray())); // 4
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 0).toArray())); // 2
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0).toArray())); // 2
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0, 0, 0).toArray())); // 8
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 0, 0, 1, 1, 0, 0, 1, 1, 1).toArray())); // 10
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 0, 1).toArray())); // 4
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 0, 1, 1).toArray())); // 4
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(1, 0, 1, 1, 1, 0, 0).toArray())); // 6
    }

    private static int longestSubArrayWithEqualZerosAndOnes(int[] arr) {
        int length = 0;
        Map<Integer, Cum> values = new TreeMap<>();
        int value = 0;
        int index = 0;
        // For 0 value initialize as a 0 baseline index is needed
        values.put(value, new Cum(index++, 0));
        for (int e : arr) {
            if (e == 0) value--;
            else value++;
            if (values.get(value) == null) {
                values.put(value, new Cum(index++, 0));
            } else {
                // Calculate new currLength using the curr and prev indexes
                Cum cum = values.get(value);
                cum.currLength += index - cum.index;
                cum.index = index++;
                values.put(value, cum);
                if (cum.currLength > length)
                    length = cum.currLength;
            }
        }
        return length;
    }

    static class Cum {
        int index;
        int currLength;

        public Cum(int index, int result) {

            this.index = index;
            this.currLength = result;
        }
    }

    // This fails for 1,0,1,1,0 => Answer should be 4 but returns 2
    private static int longestSubArrayWithEqualZerosAndOnes1(int[] arr) {

        int result = 0;

        Stack<Cum1> vals = new Stack<>();

        for (int i : arr) {
            if (vals.isEmpty()) {
                vals.push(new Cum1(i, result));
            } else if (vals.peek().val + i == 1) {
                int newResult = vals.pop().length + 2;
                if (vals.isEmpty()) {
                    result = newResult;
                } else {
                    vals.peek().length += newResult;
                    if (newResult > result)
                        result = newResult;
                }
            } else {
                vals.push(new Cum1(i));
            }
        }

        return result;
    }

    static class Cum1 {
        int val;
        int length;

        public Cum1(int val) {
            this.val = val;
        }

        public Cum1(int val, int result) {

            this.val = val;
            this.length = result;
        }
    }



}
