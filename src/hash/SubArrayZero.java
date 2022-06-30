package hash;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SubArrayZero {

    public static void main(String[] args) {


        // 1,4,5  => 1,5,10
        // 1,4,6  => 1,5,11
        // 1,4,10 => 1,5,11
        // 10,1,2 => 10,11,13

        // 4, -3, 2, 1, 8 => 4,1,3,4,12


        System.out.println(isSubArrayZero(IntStream.of(4, -3, 2, 1, 8).toArray()));
        System.out.println(isSubArrayZero(IntStream.of(-3, 2, 1, 8).toArray()));
        System.out.println(isSubArrayZero(IntStream.of(-3, 2, 2, 8).toArray()));
        System.out.println(isSubArrayZero(IntStream.of(0).toArray()));
        System.out.println(isSubArrayZero(IntStream.of(1, 0).toArray()));
    }


    private static boolean isSubArrayZero(int[] arr) {
        Set<Integer> cumulatives = new HashSet<>();
        cumulatives.add(0);
        int cum = 0;
        if (arr != null && arr.length > 0) {
            for (int e : arr) {
                cum += e;
                if (cumulatives.contains(cum)) {
                    return true;
                }
                cumulatives.add(cum);
            }
        }
        return false;
    }


}
