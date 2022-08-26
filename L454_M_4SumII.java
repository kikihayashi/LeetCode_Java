package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L454_M_4SumII {

    /**
     * https://leetcode.com/problems/4sum-ii/
     */

    public static void main(String[] args) {
//        int[] test1 = new int[]{1, 2};
//        int[] test2 = new int[]{-2, -1};
//        int[] test3 = new int[]{-1, 2};
//        int[] test4 = new int[]{0, 2};

//        int[] test1 = new int[]{-1, -1};
//        int[] test2 = new int[]{-1, 1};
//        int[] test3 = new int[]{-1, 1};
//        int[] test4 = new int[]{1, -1};

        int[] test1 = new int[]{1};
        int[] test2 = new int[]{-1};
        int[] test3 = new int[]{0};
        int[] test4 = new int[]{1};

        System.out.println(fourSumCount(test1, test2, test3, test4));
    }

    //116 ms、39.3 MB
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (map.containsKey(n1 + n2)) {
                    map.put(n1 + n2, map.get(n1 + n2) + 1);
                } else {
                    map.put(n1 + n2, 1);
                }
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                if (map.containsKey(0 - (n3 + n4))) {
                    count += map.get(0 - (n3 + n4));
                }
            }
        }
        return count;
    }

    public static int fourSumCount4(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int target = 0;
        Map<Integer, Integer> map12 = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map12.put(nums1[i] + nums2[j], map12.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        System.out.println(map12);

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (map12.containsKey(target - (nums3[i] + nums4[j]))) {
                    map.put(0, map.getOrDefault(0, 0) + map12.get(target - (nums3[i] + nums4[j])));
                }
            }
        }
        return map.getOrDefault(0, 0);
    }

    public static int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);

            }
        }
        System.out.println(map);

        for (int i = 0; i < nums3.length; i++) {
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int twoSum = e.getKey();
                int twoSumNumber = e.getValue();
                int threeSum = twoSum + nums3[i];
                map2.put(threeSum, map2.getOrDefault(threeSum, 0) + twoSumNumber);
            }
        }
        System.out.println(map2);

        for (int i = 0; i < nums4.length; i++) {
            for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
                int threeSum = e.getKey();
                int threeSumNumber = e.getValue();
                int fourSum = threeSum + nums4[i];
                map3.put(fourSum, map3.getOrDefault(fourSum, 0) + threeSumNumber);
            }
        }
        System.out.println(map3);

        return map3.getOrDefault(0, 0);
    }

    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int target = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        System.out.print(i + "" + j + "" + k + "" + l + "->");
                        System.out.println(nums1[i] + nums2[j] + nums3[k] + nums4[l]);
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
