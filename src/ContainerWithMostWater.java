// 1:30

import java.lang.reflect.Array;
import java.util.*;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {10, 14, 10, 4, 10, 2, 6, 1, 6, 12}; // 96
//        int[] height = {1, 1};
//        int[] height = {1, 2, 4, 3};
        System.out.println(-1 / 2);
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    // 2:14 to 2:19

    public int maxArea(int[] height) {

        int max = 0;
        int width = height.length - 1;

        for (int i = 0, j = height.length - 1; i != j;) {

            int minHeight = Math.min(height[i], height[j]);

            max = minHeight * width > max ? minHeight * width : max;

            if (height[i] <= height[j])
                i++;
            else
                j--;

            width--;

        }

        return max;
    }

    public int maxAreaBrute(int[] height) {

        int maxVol = -1;
        for (int i = 0; i < height.length; i++) {

            int length = 1;
            for (int j = i + 1; j < height.length; j++) {
                int vol = Math.min(height[i], height[j]) * length++;
                if (vol > maxVol) maxVol = vol;
            }
        }
        return maxVol;
    }

    public int maxAreaBruteOptimize(int[] height) {

        int maxVol = -1;
        for (int i = 0; i < height.length; i++) {

            int startPos = i;
            if (height[i] > 0)
                startPos = maxVol / height[i];
            if (startPos <= 0 || startPos <= i) startPos = i;
            int length = startPos == 0 ? 1 : startPos - i + 1;

            for (int j = startPos + 1; j < height.length; j++) {
                int vol = Math.min(height[i], height[j]) * length++;
                if (vol > maxVol) maxVol = vol;
            }
        }
        return maxVol;
    }


}


