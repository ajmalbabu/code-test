package sort;

import java.util.Arrays;

public class SortExample {

    // 2:12
    public static void main(String[] args) {

        System.out.println("test");

        int[] arr = {5, 4, 3, 1, 7, 0};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
