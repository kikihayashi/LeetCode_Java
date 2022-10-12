package Leetcode;

public class L35_E_SearchInsertPosition {

    /**
     * https://leetcode.com/problems/search-insert-position/
     */

    public static void main(String[] args) {

//        int[] nums = new int[]{1, 3, 5, 6};
//        int target = 6;

        int[] nums = new int[]{1, 2, 4, 6, 7};
        int target = 7;

//        int[] nums = new int[]{1, 3};
//        int target = 3;

//        int[] nums = new int[]{1, 3, 5};
//        int target = 3;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
//        if (target == nums[nums.length - 1]) {
//            return nums.length - 1;
//        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        return getIndex(nums, target, 0, nums.length - 1);
    }


    public static int getIndex(int[] nums, int target, int first, int last) {
        int middle = (first + last) / 2;
        if (target > nums[middle]) {
            if (last - first == 1) {
                return last;
            } else {
                return getIndex(nums, target, middle, last);
            }
        } else if (target < nums[middle]) {
            return getIndex(nums, target, first, middle);
        } else {
            return middle;
        }
    }
}
