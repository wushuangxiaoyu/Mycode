package leetcode.others.validParentheses;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author Yu
 * @create 2018-06-27 18:55
 **/
public class Solution {
    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < chars.length) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tmp = stack.pop();
                switch (chars[i]) {
                    case ')':
                        if (tmp != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (tmp != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (tmp != '{') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
