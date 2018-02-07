package 第一章_栈和队列.第一题;

/**
 * Created by  Yu  on  2018/2/7.
 * 实现一个特殊的栈 可以返回最小元素 时间复杂度O(1)
 */
public class Demo {
    public static void main(String[] args) {
        MyStack1 myStack1 =new MyStack1();
        myStack1.push(3);
        myStack1.push(4);
        myStack1.push(5);
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(1);

        MyStack2 myStack2 =new MyStack2();
        myStack2.push(3);
        myStack2.push(4);
        myStack2.push(5);
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(1);


    }
}
