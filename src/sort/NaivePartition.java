package sort;

import java.util.Arrays;

// time O(n) and space O(n)
public class NaivePartition {

    public static void main(String[] args) {
        naive();
    }

    public static void naive() {

        int[] arr = {2, 7, 8, 3, 7}; // 2,3,7,7,8,  p = 2
        int p = 1;
        int low = 0, high = 4;

        int pivotCount = 0;
        int[] arr1 = new int[high - low + 1];
        int targetIndex = 0;
        for (int i = low; i <= high; i++) {
            if (arr[i] <= arr[p]) {
                if (arr[i] < arr[p])
                    arr1[targetIndex++] = arr[i];
                else
                    pivotCount++;
            }
        }
        for (int i = 0; i < pivotCount; i++) {
            arr1[targetIndex++] = arr[p];
        }
        int lastPivot = low + targetIndex - 1;
        for (int i = low; i <= high; i++) {
            if (arr[i] > arr[p])
                arr1[targetIndex++] = arr[i];
        }

        System.out.println(Arrays.toString(arr1) + lastPivot);
    }


}
