package sort;

import java.util.Arrays;
import java.util.stream.Stream;

public class KthSmallestElement {

    public static void main(String[] args) {

        System.out.println("KthSmallestElement");

        System.out.println(kthSmallest(Stream.of(10, 5, 30, 12).mapToInt(i -> i).toArray(), 3));

    }

    static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
//            System.out.println(Arrays.toString(arr));
            int p = partition(arr, l, r);
//            System.out.println(Arrays.toString(arr) + "l=" + l + ",r=" + r + ",p=" + p + ",value " + arr[p]);
            if (p == k - 1)
                return arr[p];
            else if (p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int slow = l - 1;
        for (int fast = l; fast < h; fast++) {
            if (arr[fast] < pivot) {
                swap(arr, fast, ++slow);
            }
        }
        swap(arr, h, ++slow);
        return slow;
    }

    private static void swap(int[] arr, int h, int i2) {
        int temp = arr[i2];
        arr[i2] = arr[h];
        arr[h] = temp;
    }
}
