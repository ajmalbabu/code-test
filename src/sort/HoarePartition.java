package sort;

import java.util.Arrays;

// time O(n) and space O(1)
public class HoarePartition {

    public static void main(String[] args) {
        hoare();
    }

    public static void hoare() {

//        int[] arr = {8,4,7,9,3,10,5};   // [5, 4, 7, 3, 9, 10, 8]4    <
                                        // [8, 4, 7, 5, 3, 10, 9]5    <= is not a good option as the lower element will get stuck to first array position


        int[] arr = {10,20,30};
        int l = -1;
        int h = arr.length;
        int p = arr[0];

        while (true) {
            do {
                l++;
            } while (arr[l] < p); // <= which is a bad option
                                  // as first element will get stuck there
            do {
                h--;
            } while (arr[h] > p);

            if (l >= h) break;

            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
        }

        System.out.println(Arrays.toString(arr) + l);
    }


}
