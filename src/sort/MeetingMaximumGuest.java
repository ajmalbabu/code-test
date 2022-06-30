package sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MeetingMaximumGuest {

    public static void main(String[] args) {

        System.out.println("MeetingMaximumGuest");

        System.out.println(maxGuestOverlap(IntStream.of(900, 1000).toArray(), IntStream.of(1000, 1030).toArray()));
        System.out.println(maxGuestOverlap(IntStream.of(800, 700, 600, 500).toArray(), IntStream.of(840, 820, 830, 530).toArray()));
        System.out.println(maxGuestOverlap(IntStream.of(900, 940, 950, 1100, 1500, 1800).toArray(), IntStream.of(910, 1200, 1120, 1130, 1900, 2000).toArray()));
        System.out.println(maxGuestOverlap(IntStream.of(600, 700, 800, 900).toArray(), IntStream.of(830, 840, 930, 940).toArray()));
        System.out.println(maxGuestOverlap(IntStream.of(600, 700).toArray(), IntStream.of(600, 700).toArray()));

    }


    private static int maxGuestOverlap(int[] arr, int[] dep) {
        int res = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int arrivalCount = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                i++;
                res = Math.max(res, ++arrivalCount);
            } else {
                j++;
                arrivalCount--;
            }
        }
        return res;
    }


}
