package sort;

import java.util.stream.IntStream;

public class InversionInArray {

    public static void main(String[] args) {

        System.out.println(inversion(IntStream.of(30, 20, 10).toArray()));
        System.out.println(inversion(IntStream.of(30, 10, 20).toArray()));
        System.out.println(inversion(IntStream.of(2, 4, 1, 3, 5).toArray()));
        System.out.println(inversion(IntStream.of(10, 20, 30, 40).toArray()));
        System.out.println(inversion(IntStream.of(60, 50, 40, 30).toArray()));
        System.out.println(inversion(IntStream.of(60, 50, 40, 30, 20, 10, 2, 1).toArray()));

        System.out.println(inversion(IntStream.of(8, 2, 2, 4, 3, 9).toArray()));
        System.out.println(inversion(IntStream.of(8, 2).toArray()));
        System.out.println(inversion(IntStream.of(2, 8).toArray()));
        System.out.println(inversion(IntStream.of(2, 2).toArray()));

    }

    public static int inversion(int[] arr) {
        return countInverse(arr, 0, arr.length);
//        return countInv(arr, 0, arr.length - 1);
    }

    private static int countInverse(int[] arr, int l, int r) {
        int inverse = 0;
        if (r - l > 1) {
            int m = (l + r) / 2;
            inverse += countInverse(arr, l, m);
            inverse += countInverse(arr, m, r);
            inverse += merge(arr, l, m, r);
        }
        return inverse;
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int inverse = 0, idx = 0;
        int[] left = new int[m - l];
        int[] right = new int[r - m];
        for (int i = l; i < m; i++)
            left[idx++] = arr[i];
        idx = 0;
        for (int i = m; i < r; i++)
            right[idx++] = arr[i];

        idx = l;
        int leftIdx = 0, rightIdx = 0;
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                arr[idx++] = left[leftIdx++];
            } else if (left[leftIdx] > right[rightIdx]) {
                inverse += left.length - leftIdx;
                arr[idx++] = right[rightIdx++];
            } else {
                arr[idx++] = left[leftIdx++];
                arr[idx++] = right[rightIdx++];
            }
        }

        for (; leftIdx < left.length; leftIdx++)
            arr[idx++] = left[leftIdx];
        for (; rightIdx < right.length; rightIdx++)
            arr[idx++] = right[rightIdx];

        return inverse;
    }

    static int countInv(int arr[], int l, int r) {
        int res = 0;
        if (l < r) {

            int m = (r + l) / 2;

            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    static int countAndMerge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];
        int res = 0, i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res = res + (n1 - i);
            }
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
        return res;
    }

}
