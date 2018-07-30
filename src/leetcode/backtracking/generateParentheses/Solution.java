package leetcode.backtracking.generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * @author Yu
 * @create 2018-07-22 18:15
 **/
public class Solution {
    static List<String> result;
    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        process(new StringBuilder(""),n,n);
        return result;
    }

    public static void process(StringBuilder s,int left,int right){
        if(left==0&&right==0){
            result.add(s.toString());
            return;
        }
        if(left == right){
            process(s.append("("),left-1,right);
        }else if(left == 0){
            process(s.append(")"),left,right-1);
        } else {
            process(new StringBuilder(s.toString()).append("("),left-1,right);
            process(new StringBuilder(s.toString()).append(")"),left,right-1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
