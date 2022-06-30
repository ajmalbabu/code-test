// https://leetcode.com/problems/median-of-two-sorted-arrays
public class Median2SortedArrays {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 3};

        System.out.println(new Median2SortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int count = 0;
        int i = 0, j = 0;
        Integer median1, median2 = null;
        int firstValue = 0;

        if ((nums1.length + nums2.length) % 2 == 0) {
            median2 = (nums1.length + nums2.length) / 2;
            median1 = median2 - 1;
        } else {
            median1 = (nums1.length + nums2.length) / 2;
        }
        while (true) {

            int value = 0;
            if (i >= nums1.length && j >= nums2.length) {
                break;
            }
            if (i >= nums1.length) value = nums2[j++];
            else if (j >= nums2.length) value = nums1[i++];
            else {
                if (nums1[i] <= nums2[j]) value = nums1[i++];
                else value = nums2[j++];
            }

            if (count == median1) {
                if (median2 == null) return value;
                firstValue = value;
            } else if (median2 != null && count == median2) {
                return ((double) (firstValue + value)) / 2;
            }

            count++;
        }

        return 0;
    }
}
