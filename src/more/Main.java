package more;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 滴滴2018秋招 选择题
 * 从1到2048的所有整数中1的出现的个数是
 *
 * @author Yu
 * @create 2018-08-02 21:12
 **/
public class Main {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("");
        for(int i =0 ;i<2048;i++){
            stringBuffer.append(i);
        }
        String s = stringBuffer.toString();
        int res =0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                res++;
            }
        }
        System.out.println(res);
    }
}
