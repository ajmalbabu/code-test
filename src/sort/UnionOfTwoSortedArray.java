package sort;

import java.util.stream.IntStream;

public class UnionOfTwoSortedArray {

    public static void main(String[] args) {

        System.out.println("Union of two sorted array");

        union(IntStream.of(3, 5, 8).toArray(), IntStream.of(2, 8, 9, 10, 15).toArray());
        union(IntStream.of(2, 3, 3, 3, 4, 4).toArray(), IntStream.of(4, 4).toArray());


    }

    static void union(int[] a, int[] b) {

        int aIdx = 0;
        int bIdx = 0;

        while (aIdx < a.length && bIdx < b.length) {

            if (a[aIdx] < b[bIdx]) {
                if (aIdx == 0 || a[aIdx] != a[aIdx - 1]) {
                    System.out.print(a[aIdx] + " ");
                }
                aIdx++;
            } else if (b[bIdx] < a[aIdx]) {
                if (bIdx == 0 || b[bIdx] != b[bIdx - 1]) {
                    System.out.print(b[bIdx] + " ");
                }
                bIdx++;
            } else {
                if (aIdx == 0 || bIdx == 0 || a[aIdx] != a[aIdx - 1]) {
                    System.out.print(a[aIdx] + " ");
                }
                aIdx++;
                bIdx++;
            }
        }

        for (; aIdx < a.length; aIdx++) {
            if (aIdx == 0 || a[aIdx] != a[aIdx - 1]) {
                System.out.print(a[aIdx] + " ");
            }
        }
        for (; bIdx < b.length; bIdx++) {
            if (bIdx == 0 || b[bIdx] != b[bIdx - 1]) {
                System.out.print(b[bIdx] + " ");
            }
        }
        System.out.println();

    }


}
