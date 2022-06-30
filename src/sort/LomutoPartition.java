package sort;

import java.util.Arrays;

// time O(n) and space O(1)
public class LomutoPartition {

    public static void main(String[] args) {
        lomuto();
    }

    public static void lomuto() {

        int[] arr = {2, 7, 8, 7, 7}; // [2, 7, 7, 7, 8] => 3
//        int[] arr = {10, 80, 30, 90, 40, 50, 70}; // 10,30,40,50,70,90,80 => 4
//        int[] arr = {2, 7, 8, 3, 7}; // 2,7,3,7,8 => 3
//        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4}; // 2, 1, 3, 4, 7, 5, 6, 8 => 3
//        int[] arr = {70, 60, 80, 40, 30}; // [30, 60, 80, 40, 70] => 0
//        int[] arr = {30, 40, 20, 50, 80}; // [30, 40, 20, 50, 80] => 4

        int low = -1;
        int pivot = arr[arr.length - 1];
        for (int high = 0; high < arr.length; high++) {
            if (arr[high] <= pivot) { // He has < and & additional swap for last element,
                                      // advantage is that lesser movement of elements
                low++;
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        System.out.println(Arrays.toString(arr) + low);
    }

    // Below is wrong for the input 2, 7, 8, 7, 7 output is not doing tings right.
    public static void lomuto1() {
        int[] arr = {2, 7, 8, 7, 7}; // [2, 7, 8, 7, 7]1

        int l = 0;
        int h = 4;
        int pivot = arr[h];

        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;

        System.out.println(Arrays.toString(arr) + (i + 1));

    }


}
