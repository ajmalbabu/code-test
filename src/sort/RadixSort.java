package sort;

import java.util.Arrays;

// O O ( d * (n+10) ) , where d = number of digits in the largest number
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {300, 25, 435};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) max = i;
        }
        for (int exp = 1; max / exp > 0; exp = exp * 10) {
            sort(arr, exp);
        }
    }

    private static void sort(int[] arr, int exp) {
        int[] count = new int[10];
        for (int val : arr) {
            count[(val / exp) % 10]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] sorted = new int[arr.length];

        // do reverse from array index
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }
}
