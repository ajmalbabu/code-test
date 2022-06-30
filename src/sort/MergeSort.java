package sort;

import java.util.Arrays;


// time = O(n * log(n)),  space o(n)
public class MergeSort {

    public static void main(String[] args) {
        System.out.println("test");
        int[] arr = {4, 3,  8, 3, 9, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // arr = 5 = {0,1,2,3,4}
    private static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int m = (h - l) / 2;
            mergeSort(arr, l, l + m);
            mergeSort(arr, l + m + 1, h);
            merge(arr, l, h);
        }
    }

    private static void merge(int[] arr, int l, int h) {
        int m = (h - l) / 2;
        int[] a1 = new int[m + 1];
        int[] a2 = new int[h - l - m]; // or  (h - l + 1 - ( m + 1 ))

        int i = 0, a1Index = 0, a2Index = 0;

        for (i = l; i <= l + m; i++)
            a1[a1Index++] = arr[i];
        for (i = l + m + 1; i <= h; i++)
            a2[a2Index++] = arr[i];

        i = l;
        a1Index = 0;
        a2Index = 0;

        while (a1Index < a1.length && a2Index < a2.length) {
            if (a1[a1Index] == a2[a2Index]) {
                arr[i++] = a1[a1Index++];
                arr[i++] = a2[a2Index++];
            } else if (a1[a1Index] < a2[a2Index]) {
                arr[i++] = a1[a1Index++];
            } else {
                arr[i++] = a2[a2Index++];
            }
        }


        for (; a1Index < a1.length; a1Index++)
            arr[i++] = a1[a1Index];
        for (; a2Index < a2.length; a2Index++)
            arr[i++] = a2[a2Index];
    }

}
