package 第一章_栈和队列.第一题;

import java.util.Stack;

/**
 * Created by  Yu  on  2018/2/7.
 * 时间O(n)
 * 空间O(1)
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        stackData=new Stack<Integer>();
        stackMin=new Stack<Integer>();
    }

    public int pop(){
        stackMin.pop();
        return stackData.pop();

    }

    public void push(Integer newNum){
        stackData.push(newNum);
        if(stackMin.isEmpty()||stackMin.peek()>newNum)
            stackMin.push(newNum);
        else
            stackMin.push(stackMin.peek());
    }
    public int getMin(){
        if(stackMin.isEmpty())
            throw new RuntimeException("Stack is Empty");
        else
            return stackMin.peek();
    }
}
