package Leetcode;

public class L171_E_ExcelSheetColumnNumber {

    /**
     * https://leetcode.com/problems/excel-sheet-column-number/
     */

    public static void main(String[] args) {
        String test = "FXSHRXW";

        System.out.println(titleToNumber(test));
    }

    public static int titleToNumber(String columnTitle) {
        int temp = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            temp += Math.pow(26, length - 1 - i) * (columnTitle.charAt(i) - 64);
        }
        return temp;
    }
}
