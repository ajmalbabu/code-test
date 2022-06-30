package sort;

import java.util.*;

import static java.util.Comparator.comparingInt;

public class MergeOverlappingIntervals {

    // 6:05

    public static void main(String[] args) {

        System.out.println("MergeOverlappingIntervals");

        System.out.println(merge(List.of(new Pair(1, 3), new Pair(2, 4), new Pair(5, 7), new Pair(6, 8)).toArray(new Pair[0])));
        System.out.println(merge(List.of(new Pair(7, 9), new Pair(6, 10), new Pair(4, 5), new Pair(1, 3), new Pair(2, 4)).toArray(new Pair[0])));

    }

    private static List<Pair> merge(Pair[] input) {
        List<Pair> result = new ArrayList<>();
        System.out.println(Arrays.toString(input));
        Arrays.sort(input, comparingInt(Pair::getStart));
        System.out.println(Arrays.toString(input));
        int i = 0;
        for (int j = 1; j < input.length; j++) {
            if (input[i].end >= input[j].start) {
                input[i].start = Math.min(input[i].start, input[j].start);
                input[i].end = Math.max(input[i].end, input[j].end);
            } else {
                input[++i] = input[j];
            }
        }

        for (int k = 0; k <= i; k++) {
            System.out.print(input[k]);
        }
        return result;
    }

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        @Override
        public String toString() {
            return "(" + start +
                    ", " + end +
                    ')';
        }
    }


}
