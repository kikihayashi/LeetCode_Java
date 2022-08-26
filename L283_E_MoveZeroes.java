package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L283_E_MoveZeroes {

    /**
     * https://leetcode.com/problems/move-zeroes/
     */

    public static int[] test;

    public static void main(String[] args) {


        test = new int[]{1};
        test = new int[]{1, 0, 2};
        test = new int[]{0, 1, 0, 3, 12};
        test = new int[]{45192, 0, -659, -52359, -99225, -75991, 0, -15155, 27382, 59818, 0, -30645, -17025, 81209, 887, 64648};


        moveZeroes(test);

        System.out.println(Arrays.toString(test));
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        int prev = nums[index];

        for (int i = 1; i < nums.length; i++) {
            if (prev == 0) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                    index++;
                }
            } else {
                index++;
                prev = nums[index];
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (queue.size() > 0) {
                    int temp = nums[i];
                    nums[queue.poll()] = temp;
                    nums[i] = 0;
                    queue.add(i);
                }
            } else {
                queue.add(i);
            }
        }
    }
}
