package leetcode.arraysCode.groupAnagrams;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @author Yu
 * @create 2018-07-13 21:38
 **/
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                continue;
            }
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = String.copyValueOf(chars);
            if (set.contains(sorted)) {
                map.get(sorted).add(strs[i]);

            } else {
                set.add(sorted);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            value.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) == o2.charAt(i)) {
                            continue;
                        } else {
                            return o1.charAt(i) < o2.charAt(i) ? -1 : 1;
                        }
                    }
                    return 0;
                }
            });
            result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
    }
}


