package Leetcode;

import java.util.*;


/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */

public class L692_M_TopKFrequentWords {

    public static void main(String[] args) {
//        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//        int k = 4;

//        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
//        int k = 2;

        String[] words = new String[]{"a", "aaa", "aa"};
        int k = 2;

        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> list = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(words.length, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o2) > map.get(o1)) {
                    return 1;
                } else if (map.get(o2) < map.get(o1)) {
                    return -1;
                } else {
                    for (int i = 0; i < o1.length() && i < o2.length(); i++) {
                        if (o1.charAt(i) == o2.charAt(i)) {
                            continue;
                        } else {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (String word : words) {
            queue.offer(word);
        }

        while (list.size() < k) {
            String word = queue.poll();
            if (list.size() == 0) {
                list.add(word);
            } else {
                if (!word.equals(list.get(list.size() - 1))) {
                    list.add(word);
                }
            }
        }
        return list;
    }
}
