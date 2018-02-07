package 第一章_栈和队列.第二题;

/**
 * Created by  Yu  on  2018/2/7.
 * 用两个栈 实现队列操作
 */
public class Demo {
    public static void main(String[] args) {
        TwoStacksQueue queue=new TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());





    }
}
