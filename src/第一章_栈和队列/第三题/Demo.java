package 第一章_栈和队列.第三题;

import java.util.Stack;

/**
 * Created by  Yu  on  2018/2/7.
 * 使用递归 和栈操作 逆序一个栈
 */
public class Demo {
    public  static int getAndRemoveLastEle(Stack<Integer> stack){
        int result= stack.pop();
        if(stack.isEmpty())
            return  result;
        else {
            int last =getAndRemoveLastEle(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        else{
            int last=getAndRemoveLastEle(stack);
            reverse(stack);
            stack.push(last);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
