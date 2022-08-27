package LeetCode;

import java.util.Arrays;

public class L88_E_MergeSortedArray {

    /**
     * https://leetcode.com/problems/merge-sorted-array/
     */

    public static void main(String[] args) {

//        int[] nums1 = new int[]{1};
//        int[] nums2 = new int[]{};
//        int n1 = 1;
//        int n2 = 0;

//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{1};
//        int n1 = 0;
//        int n2 = 1;

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

//        int[] nums1 = new int[]{8, 9, 11, 0, 0, 0};
//        int[] nums2 = new int[]{2, 5, 33};
        int n1 = 3;
        int n2 = 3;
        merge(nums1, n1, nums2, n2);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        //設置p點位置在nums最尾端
        int p1 = m - 1;
        int p2 = n - 1;

        while (true) {
            //如果p2位置的值 >= p1位置的值
            if (nums1[p1] <= nums2[p2]) {
                //將p2位置的值放到nums1的最尾端(位置由當下p1、p2決定)
                nums1[p1 + p2 + 1] = nums2[p2];
                //p2往前一格
                p2--;
            }
            //如果p2位置的值 < p1位置的值
            else {
                //將p1位置的值放到nums1的尾端(位置由當下p1、p2決定)
                nums1[p1 + p2 + 1] = nums1[p1];
                //p1往前一格
                p1--;
            }

            //如果p2位置已經是負的，結束迴圈
            if (p2 < 0) {
                return;
            }
            //如果p1位置已經是負的
            if (p1 < 0) {
                //將nums2的第0~p2位置，放到nums1裡
                for (int i = 0; i <= p2; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
        }
    }
}
