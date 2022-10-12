package Leetcode;

import java.util.*;

public class L350_E_IntersectionofTwoArraysII {

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays-ii/
     */

    public static void main(String[] args) {
//        int[] test1 = new int[]{9, 4, 9, 8, 4};
//        int[] test2 = new int[]{4, 9, 5};
//        int[] test1 = new int[]{3, 1, 2};
//        int[] test2 = new int[]{1, 1};
        int[] test1 = new int[]{1, 2, 2, 1};
        int[] test2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection2(test2, test1)));
    }

    //參考別人的概念改寫1 ms、39.3 MB
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        int[] array = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            array[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (array[nums2[i]] > 0) {
                list.add(nums2[i]);
                array[nums2[i]]--;
            }
        }
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        return temp;
    }

    //別人寫的：3 ms、40.5 MB
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        int index = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                nums1[index] = nums1[p1];
                p1++;
                p2++;
                index++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}
