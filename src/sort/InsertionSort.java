package sort;

import java.util.Arrays;

// O (n^2)
public class InsertionSort {

    public static void main(String[] args) {
        merge();
    }

    public static void merge() {

//        int[] arr = {4, 2, 3, 5, 1, 1};
        int[] arr = {30, 20, 10};

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void sortWithArrayCopy() {

        int[] e = {4, 2, 3, 5, 1, 1};

        for (int i = 1; i < e.length; i++) {

            for (int j = 0; j < i; j++) {
                if (e[i] < e[j]) {
                    int temp = e[i];
                    System.arraycopy(e, j, e, j + 1, i - j);
                    e[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(e));
    }
}
