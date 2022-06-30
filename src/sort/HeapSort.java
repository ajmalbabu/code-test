package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        int n = arr.length;
        buildheap(arr, n);
        swap(arr, 0, n - 1);

        for (int i = n - 1; i > 0; i--) {
            heapify(arr, i, 0);
            swap(arr, 0, i - 1);
        }
    }

    public void buildheap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;

        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }


}
