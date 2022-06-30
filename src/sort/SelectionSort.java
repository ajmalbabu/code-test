package sort;

import java.util.Arrays;

// O (n^2)
public class SelectionSort {

    public static void main(String[] args) {
        sort();
    }

    public static void sort() {

        int[] elements = {2, 4, 3, 5, 1};

        for (int i = 0; i < elements.length - 1; i++) {
            int lowestPos = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[lowestPos]) {
                    lowestPos = j;
                }
            }
            int temp = elements[i];
            elements[i] = elements[lowestPos];
            elements[lowestPos] = temp;
        }

        System.out.println(Arrays.toString(elements));
    }
}
