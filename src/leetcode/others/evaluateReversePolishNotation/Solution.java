package leetcode.others.evaluateReversePolishNotation;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * @author Yu
 * @create 2018-07-31 16:25
 **/
public class Solution {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                process(stack, tokens[i]);
            }else {
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private static void process(Stack<String> stack, String f) {
        String one = stack.pop();
        while ("+".equals(one) || "-".equals(one) || "*".equals(one) || "/".equals(one)) {
            process(stack, one);
            one = stack.pop();
        }
        String two = stack.pop();
        while ("+".equals(two) || "-".equals(two) || "*".equals(two) || "/".equals(two)) {
            process(stack, two);
            two = stack.pop();
        }
        stack.push(work(f, one, two));
    }

    private static String work(String f, String one, String two) {
        int y = Integer.valueOf(one);
        int x = Integer.valueOf(two);
        String res;
        switch (f.charAt(0)) {
            case '+':
                return String.valueOf(x + y);
            case '-':
                return String.valueOf(x - y);
            case '*':
                return String.valueOf(x * y);
            case '/':
                return String.valueOf(x / y);
            default:
                throw new RuntimeException("error");
        }
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{
                "2","1","+","3","*"
        }));
    }
}
