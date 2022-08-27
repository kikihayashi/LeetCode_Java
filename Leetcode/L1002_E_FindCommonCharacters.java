package LeetCode;

import java.util.*;

public class L1002_E_FindCommonCharacters {

    /**
     * https://leetcode.com/problems/find-common-characters/
     */

    public static void main(String[] args) {
        String[] test = new String[]{"bella", "label", "roller"};
//        String[] test = new String[]{"cool", "lock", "coook"};
//        String[] test = new String[]{"aaaa", "babbb", "cccc"};
//        String[] test = new String[]{"abcd"};
//        String[] test = new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"};

        System.out.println(commonChars(test));
    }

    //2 ms、39.1 MB
    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int[] finalArray = new int[26];

        for (char c : words[0].toCharArray()) {
            finalArray[c - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] tempArray = new int[26];
            for (char c : words[i].toCharArray()) {
                tempArray[c - 'a']++;
            }
            for (int j = 0; j < finalArray.length; j++) {
                if (finalArray[j] != 0) {
                    finalArray[j] = Math.min(finalArray[j], tempArray[j]);
                }
            }
        }
        for (int i = 0; i < finalArray.length; i++) {
            if (finalArray[i] != 0) {
                int number = finalArray[i];
                while (number-- > 0) {
                    list.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return list;
    }

    //19 ms、39.5 MB
    public static List<String> commonChars3(String[] words) {
        List<String> list = new ArrayList<>();
        int wordsLength = words.length;
        int[] finalArray = new int[26];

        for (int i = 0; i < words[0].toCharArray().length; i++) {
            finalArray[words[0].charAt(i) - 'a']++;
        }

//        System.out.println(Arrays.toString(finalArray));

        for (int i = 1; i < wordsLength; i++) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int j = 0; j < words[i].toCharArray().length; j++) {
                tempMap.put(words[i].charAt(j), tempMap.getOrDefault(words[i].charAt(j), 0) + 1);
            }
//            System.out.println("--------");
//            System.out.println(tempMap);

            for (int j = 0; j < finalArray.length; j++) {
                if (tempMap.containsKey((char) (j + 'a'))) {
                    finalArray[j] = Math.min(finalArray[j], tempMap.get((char) (j + 'a')));
                } else {
                    finalArray[j] = 0;
                }
            }
//            System.out.println(Arrays.toString(finalArray));
        }

        for (int i = 0; i < finalArray.length; i++) {
            int number = finalArray[i];
            while (number-- > 0) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }

    //19 ms、39.3 MB
    public static List<String> commonChars2(String[] words) {
        List<String> list = new LinkedList<>();
        int wordsLength = words.length;
        int[][] temp = new int[wordsLength][26];

        for (int i = 0; i < wordsLength; i++) {
            for (int j = 0; j < words[i].toCharArray().length; j++) {
                temp[i][words[i].charAt(j) - 'a']++;
            }
        }

//        for (int i = 0; i < wordsLength; i++) {
//            System.out.println(Arrays.toString(temp[i]));
//        }
//        for (int i = 0; i < 26; i++) {
//            for (int j = 0; j < wordsLength; j++) {
//                System.out.print(temp[j][i]);
//            }
//            System.out.println();
//        }

        for (int i = 0; i < 26; i++) {
            int number = temp[0][i];

            for (int j = 1; j < wordsLength; j++) {
                number = Math.min(number, temp[j][i]);
            }
//            System.out.print(i + "---");
//            System.out.println("number:" + number);

            while (number-- > 0) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }

}
