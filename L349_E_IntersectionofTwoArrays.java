package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L349_E_IntersectionofTwoArrays {

    /**
     * https://leetcode.com/problems/intersection-of-two-arrays/
     */

    public static void main(String[] args) {
        int[] test1 = new int[]{9, 4, 9, 8, 4};
        int[] test2 = new int[]{4, 9, 5};
//        int[] test1 = new int[]{1, 2, 2, 1};
//        int[] test2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersection(test2, test1)));
    }

    //8 ms、40.8 MB
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                if (!list.contains(nums1[p1])) {
                    list.add(nums1[p1]);
                }
                p1++;
                p2++;
            }
        }
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        return temp;
    }

    //10 ms、40.8 MB
    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }


}
