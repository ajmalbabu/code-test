package search;

import java.util.stream.IntStream;

public class SquareRoot {

    // 64 - 8
    // 65 - 8

    public static void main(String[] args) {
        System.out.println(floorSqrt(4));
        System.out.println(floorSqrt(5));
        System.out.println(floorSqrt(3));
        System.out.println(floorSqrt(2));
        System.out.println(floorSqrt(1));
        System.out.println(floorSqrt(65));
        System.out.println(floorSqrt(9));
        System.out.println(floorSqrt(10));
        System.out.println(floorSqrt(15));


    }

    private static int floorSqrt(long x) {
        long sqrt = 1;
        if (x > 1) {
            long l = 1, h = x;
            while (l <= h) {
                long mid = (l + h) / 2;
                long currSqrt = mid * mid;
                if (currSqrt == x) return (int) mid;
                else if (currSqrt > x) h = mid - 1;
                else {
//                    if (x - currSqrt < x - sqrt * sqrt) sqrt = mid;
                    sqrt = mid;
                    l = mid + 1;
                }
            }
        }
        return (int) sqrt;
    }
}
