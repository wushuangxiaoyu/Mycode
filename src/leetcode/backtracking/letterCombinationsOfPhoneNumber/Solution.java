package leetcode.backtracking.letterCombinationsOfPhoneNumber;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author Yu
 * @create 2018-07-22 15:37
 **/
public class Solution {
    public static Map<Character, char[]> map;
    static List<String> result;

    static {
        map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {

        result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        process(digits, 0, "");
        return result;
    }

    private static void process(String digits, int start, String s) {
        if (start == digits.length()) {
            result.add(s);
            return;
        }
        char c = digits.charAt(start);
        if (map.containsKey(c)) {
            char[] chars = map.get(c);
            for (int i = 0; i < chars.length; i++) {
                process(digits, start + 1, s + chars[i]);
            }
        } else {
            process(digits, start + 1, s);
        }
    }

    /**
     * @Description: leetcode上快的
     * @date 2018/7/22 16:40
     */
    public List<String> letterCombinations2(String digits) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("d");
        list3.add("e");
        list3.add("f");
        ArrayList<String> list4 = new ArrayList<String>();
        list4.add("g");
        list4.add("h");
        list4.add("i");
        ArrayList<String> list5 = new ArrayList<String>();
        list5.add("j");
        list5.add("k");
        list5.add("l");
        ArrayList<String> list6 = new ArrayList<String>();
        list6.add("m");
        list6.add("n");
        list6.add("o");
        ArrayList<String> list7 = new ArrayList<String>();
        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");
        ArrayList<String> list8 = new ArrayList<String>();
        list8.add("t");
        list8.add("u");
        list8.add("v");
        ArrayList<String> list9 = new ArrayList<String>();
        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");

        map.put("2", list2);
        map.put("3", list3);
        map.put("4", list4);
        map.put("5", list5);
        map.put("6", list6);
        map.put("7", list7);
        map.put("8", list8);
        map.put("9", list9);

        // if (!digits.contains("1")) {

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> al = map.get(digits.charAt(i) + "");
            if (i == 0) {
                result = al;
            } else {
                ArrayList<String> temp = new ArrayList<String>();
                for (String re : result) {
                    for (String a : al) {
                        String tem = re + a;
                        temp.add(tem);
                    }
                }
                result = temp;
            }
        }
        return result;
//		}else {
//			System.out.println("你输入的数字包括数字1");
//		}
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("");
    }
}
