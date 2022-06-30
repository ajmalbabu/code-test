package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

// O (n^2)
public class BubbleSort {

    public static void main(String[] args) {
        sort();
    }

    public static void sort() {

        int[] elements = {22, 6, 5, 8, 6, 10, 20, 1};

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(elements));
    }
}
