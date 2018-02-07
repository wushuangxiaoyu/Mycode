package 第一章_栈和队列.第二题;

import java.util.Stack;

/**
 * Created by  Yu  on  2018/2/7.
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPop=new Stack<Integer>();
        stackPush=new Stack<Integer>();
    }

    public void add(Integer newNum){
        if (stackPop.isEmpty())
            stackPush.push(newNum);
        else {//stackPop 中的倒入
            while (!stackPop.isEmpty())
                stackPush.push(stackPop.pop());
            stackPush.push(newNum);
        }
    }

    public int poll(){
        if(stackPush.isEmpty()&&stackPop.isEmpty())
            throw new RuntimeException("Queue is empty");
        else if(stackPop.isEmpty())
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        return stackPop.pop();

    }

    public int peek(){
        if(stackPush.isEmpty()&&stackPop.isEmpty())
            throw new RuntimeException("Queue is empty");
        else if(stackPop.isEmpty())
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        return stackPop.peek();
    }



}
