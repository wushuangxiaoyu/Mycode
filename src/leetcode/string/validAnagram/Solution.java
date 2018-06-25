package leetcode.string.validAnagram;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * @author Yu
 * @create 2018-06-22 13:22
 **/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
            return  false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i = 0 ; i<chars1.length;i++){
            if(chars1[i] != chars2[i]){
                return false;
            }
        }
        return  true;
    }
}
