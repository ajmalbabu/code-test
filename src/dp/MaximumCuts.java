package dp;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class MaximumCuts {

    static Map<Integer, Integer> cutHist = new TreeMap<>();
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(cut(30, IntStream.of(1, 2, 3).toArray()));
        System.out.println("count: " + count); // 117897840 vs 88
        count = 0;
        cutHist.clear();
        System.out.println(cut(23, IntStream.of(12, 11, 13).toArray()));
        cutHist.clear();
        System.out.println(cut(3, IntStream.of(2, 4, 2).toArray()));
    }

    static int cut(int n, int[] sizes) {

        count++;
        if (cutHist.get(n) != null) return cutHist.get(n);
        if (n == 0) return 0;

        int res = -1;
        for (int size : sizes) {
            if (n >= size) {
                int resp = cut(n - size, sizes);
                if (resp != -1) {
                    res = Integer.max(res, 1 + resp);
                }
            }
        }
        cutHist.put(n, res);

        return res;
    }
}
