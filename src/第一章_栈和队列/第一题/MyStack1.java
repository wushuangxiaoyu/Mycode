package 第一章_栈和队列.第一题;

import java.util.Stack;

/**
 * Created by  Yu  on  2018/2/7.
 * 时间O(n)
 * 空间O(1)
 * 较省空间
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData=new Stack<Integer>();
        this.stackMin=new Stack<Integer>();
    }

    public void push(Integer newNum){
        stackData.push(newNum);
        if(stackMin.isEmpty()||this.getMin()>=newNum)
            stackMin.push(newNum);
    }

    public int pop(){
        if (stackData.isEmpty())
            throw new RuntimeException("stack is Empty!");
        int result=stackData.pop();
        if(result==stackMin.peek())
            stackMin.pop();
        return result;
    }

    public int getMin(){
        if (stackMin.isEmpty())
            throw new RuntimeException("stack is Empty!");
        else
            return stackMin.peek();
    }
}
