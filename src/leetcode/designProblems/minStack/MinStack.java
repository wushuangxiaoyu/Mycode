package leetcode.designProblems.minStack;

import java.util.Stack;

/**
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 *
 * @author Yu
 * @create 2018-06-18 14:48
 **/
public class MinStack {

    private Stack<Integer> valStack;
    private Stack<Integer> minStack;

    public MinStack() {
        valStack= new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valStack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }
        else {
            minStack.push(Math.min(x,minStack.peek()));
        }
    }

    public void pop() {
        if(minStack.isEmpty())
            return;
        minStack.pop();
        valStack.pop();
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
