package leetcode.string.firstUniqueCharacterInAString;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * @author Yu
 * @create 2018-06-22 11:20
 **/
public class Solution {
    public static int firstUniqChar(String s) {
        if(s == null ||  "".equals(s)){
            return  -1;
        }
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<chars.length;i++) {
            if(map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }
            else {
                map.put(chars[i],1);
            }
        }

        for(int i = 0 ;i<chars.length;i++){
            if(
                    map.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
