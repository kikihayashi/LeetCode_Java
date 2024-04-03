package LeetCode;

import java.util.*;

public class L448_E_FindAllNumbersDisappearedinanArray {

    /**
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     */

    //將指標對應的值改負數，剩下正數的位置即為答案
    //參考：https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/1583741/TIme%3A-O(n)-Space%3A-O(1)

    public static void main(String[] args) {

        Set<Integer> sourceSet = new HashSet<>();
        List<Integer> list = new ArrayList<>(sourceSet);


        int[] test = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
//        int[] test = new int[]{1, 1};
//        int[] test = new int[]{2,1};
        System.out.println(findDisappearedNumbers(test));
    }

    //30 ms	48.1 MB
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        int counter = 1;

        while (index < nums.length) {
            if (counter <= nums.length) {
                set.add(counter);
            }
            counter++;

            if (set.contains(nums[index])) {
                set.remove(nums[index]);
                index++;
            } else {
                if (counter > nums.length) {
                    index++;
                }
            }
        }
        return new ArrayList<>(set);
    }

    //22 ms	48.3 MB
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length + 1; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        return new ArrayList<>(set);
    }


}
