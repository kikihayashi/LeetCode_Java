package LeetCode;

public class L704_E_BinarySearch {

    /**
     * https://leetcode.com/problems/binary-search/
     */


    public static void main(String[] args) {
//        int[] test = new int[]{-1, 0, 3, 5, 9, 12};
        int[] test = new int[]{5};
        int n = 50;

        System.out.println(search(test, n));
    }

    //別人寫的：0 ms、39.6 MB
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //0 ms、40.1 MB
    public static int search2(int[] nums, int target) {
        if (nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
