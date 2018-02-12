package 第一章_栈和队列.第五题;

import java.util.Stack;

/**
 * Created by  Yu  on  2018/2/12.
 * 用一个栈实现另一个栈的排序 从大到小
 */
public class Demo {

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> helpStack=new Stack<Integer>();
        while(!stack.isEmpty()){
            int popInt=stack.pop();
            while(!helpStack.isEmpty()&&helpStack.peek()<popInt)
                stack.push(helpStack.pop());
            helpStack.push(popInt);
        }
        while(!helpStack.isEmpty())
            stack.push(helpStack.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<Integer>();
        stack.push(6);stack.push(4);stack.push(7);stack.push(9);stack.push(1);stack.push(2);
        System.out.println("排序前");
        while(!stack.isEmpty())
            System.out.println(stack.pop());
        stack.push(6);stack.push(4);stack.push(7);stack.push(9);stack.push(1);stack.push(2);
        System.out.println("排序后");
        sortStackByStack(stack);
        while(!stack.isEmpty())
            System.out.println(stack.pop());


    }


}
