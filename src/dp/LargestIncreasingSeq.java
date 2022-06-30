package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LargestIncreasingSeq {


    public static void main(String[] args) {
        // 4,10,5,6,20,8,9,15,25,12,14

        System.out.println(largestIncreasingSeq(IntStream.of(40, 4, 10, 5, 6, 20, 8, 9, 12, 15, 16).toArray(), 0));
        System.out.println(count);

        count = 0;
        System.out.println(largestIncreasingSeqMemo(IntStream.of(40, 4, 10, 5, 6, 20, 8, 9, 12, 15, 16).toArray(), 0));
        System.out.println(count);


        //        System.out.println(largestIncreasingSeq(IntStream.of(40, 4, 10, 5, 20, 6, 7, 50, 60, 70, 80).toArray(), 0));
    }

    static int count = 0;
    static Map<Integer, Integer> memo = new HashMap<>();

    // IMP - There is n log(n) solution here where auxilary array is used with log (n) search to find the mid-point and count from there, watch video.

    static int largestIncreasingSeq(int[] arr, int i) {
        count++;
        if (i == arr.length - 1) return 0;
        int val1 = arr[i] < arr[i + 1] ? 1 : 0;
        if (i < arr.length - 2) {
            int val2 = arr[i] < arr[i + 2] ? 1 : 0;
            return Math.max(val1 + largestIncreasingSeq(arr, i + 1), val2 + largestIncreasingSeq(arr, i + 2));
        }
        return val1 + largestIncreasingSeq(arr, i + 1);
    }

    static int largestIncreasingSeqMemo(int[] arr, int i) {
        count++;
        if (memo.get(i) != null) return memo.get(i);
        if (i == arr.length - 1) return 0;
        int val1 = arr[i] < arr[i + 1] ? 1 : 0;
        if (i < arr.length - 2) {

            int res1 = largestIncreasingSeqMemo(arr, i + 1);
            memo.put(i + 1, res1);

            int val2 = arr[i] < arr[i + 2] ? 1 : 0;

            return Math.max(val1 + res1, val2 + largestIncreasingSeqMemo(arr, i + 2));
        }

        return val1 + largestIncreasingSeqMemo(arr, i + 1);
    }

    static int largestIncreasingSeq(int[] arr) {

        int res = 0;

        for (int left = 0; left < arr.length - 1; left++) {
            for (int right = left + 1; right < arr.length; right++) {

                int currResult = largestIncreasingSeq1(arr, left, right);
                if (currResult > res) res = currResult;

            }
        }

        return res;
    }

    private static int largestIncreasingSeq1(int[] arr, int left, int j) {

        int res = 0;
        for (int right = j; right < arr.length; right++) {
            if (arr[left] < arr[right]) {
                res++;
                left = right;
            }
        }
        return res;

    }
    //        int res = 1;
//        for (int i = left; i < arr.length; i++) {
//            int curr = arr[i];
//            int currRes = 1;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (curr < arr[j]) {
//                    curr = arr[j];
//                    currRes++;
//                }
//            }
//            if (currRes > res) res = currRes;
//        }
//        return res;
}
