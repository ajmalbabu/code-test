package hash;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LongestSubArrayWithEqualZerosAndOnes {

    public static void main(String[] args) {

//        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0).toArray()));
//        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0, 0).toArray()));
//        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(0, 1, 1, 1, 1, 0, 0, 0).toArray()));
        System.out.println(longestSubArrayWithEqualZerosAndOnes(IntStream.of(1, 0, 1, 1, 1, 0, 0).toArray()));

        // See if flatMap can help or collect can help
        List<Integer> v = List.of(1, 2, 5, 11);
        int r = v.stream().reduce(0, (a, b) -> {
            System.out.println("bi=" + a + " " + b);
            return b - a;
        }, (a, b) -> {
            System.out.println("c=" + a + " " + b);
            return 1;
        });

        System.out.println(r);

    }


    private static int longestSubArrayWithEqualZerosAndOnes(int[] arr) {

        Map<Integer, List<Integer>> values = new HashMap<>();

        int result = 0;
        int cum = 0;
        values.put(0, new ArrayList<>(List.of(0)));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) cum--;
            else cum++;


            values.merge(cum, new ArrayList<>(List.of(i + 1)), (v1, v2) -> { // v1 is existing value, v2 is new value
                v1.addAll(v2);
                return v1;
            });

            if (values.get(cum).size() > 1) {
                int length = 0;
                int v = values.get(cum).get(values.get(cum).size() - 1);
                for (int l = values.get(cum).size() - 2; l >= 0; l--) {
                    length += v - values.get(cum).get(l);
                    v = values.get(cum).get(l);
                }
                if (length > result)
                    result = length;
            }
        }
        return result;
    }


}
