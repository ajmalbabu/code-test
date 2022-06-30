package dp;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class MinJumpToReachEnd {


    public static void main(String[] args) {

        cache.clear();
        System.out.println(minJump(0, IntStream.of(2, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(1, 2).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(1, 2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(3, 4, 2, 1, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(4, 1, 5, 3, 1, 3, 2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(2, 1, 5, 1, 1, 3, 2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(2, 1, 3, 1, 1, 3, 2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(2, 1, 2, 1, 1, 3, 2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(2, 1, 2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(2, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(1, 1, 1).toArray()));
        cache.clear();
        System.out.println(minJump(0, IntStream.of(1).toArray()));
        cache.clear();

    }

    static Map<Integer,Integer> cache = new TreeMap<>();
    static int count = 0;

    static int minJump(int index, int[] values) {

        count++;
        if(cache.get(index) != null) return cache.get(index);

        if (index == values.length - 1) return 0;

        int val = Integer.MAX_VALUE;

        for (int i = index + 1; i < index + 1 + values[index]; i++) {
            if (i >= values.length) break;
            val = Math.min(val, minJump(i, values)) + 1;
        }

        cache.put(index,val);
        return val;
    }
}
