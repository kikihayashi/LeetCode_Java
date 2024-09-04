package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */

public class L80_M_RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {
        int[] test0 = new int[]{1};
        int[] test1 = new int[]{1, 1, 1, 2, 2, 3};
        int[] test2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        System.out.println(removeDuplicates(test0));
        System.out.println(removeDuplicates(test1));
        System.out.println(removeDuplicates(test2));
    }

    public static int removeDuplicates(int[] nums) {
        int nowNumber = nums[0];
        int appearTimes = 1;
        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nowNumber) {
                appearTimes++;

                if (appearTimes == 2) {
                    nums[index] = nowNumber;
                    index++;
                }
            } else {
                nowNumber = nums[i];
                appearTimes = 1;
                nums[index] = nowNumber;
                index++;
            }
        }
        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        System.out.println("nums：" + Arrays.toString(nums));
        List<Integer> list = new ArrayList<>();

        int repeatNumber = nums[0];
        int appearTimes = 1;
        int index = 1;

        int[] test = new int[nums.length];

        list.add(nums[0]);
        test[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == repeatNumber) {
                appearTimes++;
                if (appearTimes == 2) {
                    list.add(nums[i]);
                    test[index] = nums[i];
                    nums[index] = nums[i];
                    index++;
                }
            } else {
                repeatNumber = nums[i];
                appearTimes = 1;
                list.add(nums[i]);
                test[index] = nums[i];
                nums[index] = nums[i];
                index++;
            }
        }

        System.out.println("index：" + index);
        System.out.println("list：" + list);
        System.out.println("test：" + Arrays.toString(test));
        System.out.println("ans1：" + Arrays.toString(nums));
        return index;
    }

}
