package hash;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        // 4,2,0,2,3,1,8

        System.out.println(isSubArrayWithGivenSum(IntStream.of(4, 2, 0, 2, 3, 1, 8).toArray(), 5));
        System.out.println(isSubArrayWithGivenSum(IntStream.of(4, 2, 0, 2, 3, 1, 8).toArray(), 4));
        System.out.println(isSubArrayWithGivenSum(IntStream.of(4, 2, 0, 2, 3, 1, 8).toArray(), 15));
        System.out.println(isSubArrayWithGivenSum(IntStream.of(4, 2, 3).toArray(), 4));
        System.out.println(isSubArrayWithGivenSum(IntStream.of(4, 2, 8, 9, 0, 1, 0, 2, 2, 6).toArray(), 5));
    }


    private static boolean isSubArrayWithGivenSum(int[] arr, int sum) {
        Set<Integer> cumulatives = new HashSet<>();
        cumulatives.add(0);
        int tot = 0;
        for (int e : arr) {
            tot += e;
            if (cumulatives.contains(tot - sum))
                return true;
            cumulatives.add(tot);
        }
        return false;
    }


}
