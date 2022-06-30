package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class IntersectionOfTwoSortedArray {

    public static void main(String[] args) {

        System.out.println("intersection of two sorted array");

        intersection(Stream.of(1, 2).mapToInt(i -> i).toArray(), Stream.of(1, 2, 2, 2, 2).mapToInt(i -> i).toArray());

        intersection(Stream.of(1, 2).mapToInt(i -> i).toArray(), Stream.of(1, 2, 2, 2, 2).mapToInt(i -> i).toArray());

        intersection(Stream.of(1, 2, 2, 3, 4, 5).mapToInt(i -> i).toArray(), Stream.of(0, 2, 2, 3, 3, 7, 8).mapToInt(i -> i).toArray());

        intersection(Stream.of(1, 2, 3, 4).mapToInt(i -> i).toArray(), Stream.of(0, 2, 8).mapToInt(i -> i).toArray());

        intersection(Stream.of(1, 2, 3, 4).mapToInt(i -> i).toArray(), Stream.of(0, 8, 9).mapToInt(i -> i).toArray());

        intersection(Stream.of(1, 1, 3, 3, 3).mapToInt(i -> i).toArray(), Stream.of(1, 1, 1, 1, 3, 5, 7).mapToInt(i -> i).toArray());

        intersection(Stream.of(1, 2, 3, 4).mapToInt(i -> i).toArray(), new int[]{});

    }

    static void intersection(int[] a, int[] b) {

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                if (i == 0 || a[i - 1] != a[i])
                    System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        System.out.println();
    }


}
