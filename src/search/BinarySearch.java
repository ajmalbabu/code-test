package search;

import java.util.stream.IntStream;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(bSearch(IntStream.of(10, 20, 30, 40, 50).toArray(), 20));
        System.out.println(bSearch(IntStream.of(5, 15, 25).toArray(), 25));
        System.out.println(bSearch(IntStream.of(5, 10, 15, 25, 35).toArray(), 20));
        System.out.println(bSearch(IntStream.of(10, 15).toArray(), 20));
        System.out.println(bSearch(IntStream.of(10, 15).toArray(), 5));
        System.out.println(bSearch(IntStream.of(10, 10).toArray(), 10));

        System.out.println(bSearchRecursive(IntStream.of(10, 20, 30, 40, 50).toArray(), 20));
        System.out.println(bSearchRecursive(IntStream.of(5, 15, 25).toArray(), 25));
        System.out.println(bSearchRecursive(IntStream.of(5, 10, 15, 25, 35).toArray(), 20));
        System.out.println(bSearchRecursive(IntStream.of(10, 15).toArray(), 20));
        System.out.println(bSearchRecursive(IntStream.of(10, 15).toArray(), 5));
        System.out.println(bSearchRecursive(IntStream.of(10, 10).toArray(), 10));

    }

    private static int bSearch(int[] arr, int v) {

        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (v == arr[m])
                return m;
            else if (v < arr[m])
                r = m - 1;
            else
                l = m + 1;
        }

        return -1;
    }

    private static int bSearchRecursive(int[] arr, int v) {
        return bSearchRecursive1(arr, 0, arr.length - 1, v);
    }

    private static int bSearchRecursive1(int[] arr, int l, int r, int v) {
        if (l > r) return -1;
        else {
            int m = (l + r) / 2;
            if (arr[m] == v) return m;
            else if (v < arr[m]) return bSearchRecursive1(arr, l, m - 1, v);
            else return bSearchRecursive1(arr, m + 1, r, v);
        }
    }
}
