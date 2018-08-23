package 其他.Thread.哲学家吃饭问题2;


/**
 * Created by  Yu  on  2017/12/3.
 * 哲学家吃饭问题
 */
public class Philosopher extends Thread {
    private int num=100;
    //左筷子
    protected ChopStick left;
    //右筷子
    protected ChopStick right;
    public String name;

    public Philosopher(ChopStick left, ChopStick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public void eat(){
       if(putUp()){
        chew();
        putDown();
       }
    }

    //拿筷子
    public boolean putUp(){
        System.out.println("哲学家 " + name + " 准备拿左筷子...");
        if(!left.pickUp()){
            System.out.println("哲学家 " + name + " 放弃拿左筷子");
            return false;
        }
        System.out.println("哲学家 " + name + " 准备拿右筷子...");
        if(!right.pickUp()){
            System.out.println("哲学家 " + name + " 放弃拿右筷子...");
            System.out.println("哲学家 " + name + " 放下左筷子...");
            left.pickDown();
            return false;
        }
        return true;
    }

    //吃饭
    public void chew(){
        System.out.println("哲学家 " + name + " 准备吃一口...");
        int sleepTime = 0;
        try {
            sleepTime = (int)(Math.random() * 1000);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("哲学家 " + name + " 吃完这一口, 用时 " + sleepTime + " ms");
    }

    //放下筷子
    public void putDown(){
        System.out.println("哲学家 " + name + " 准备放下左筷子...");
        left.pickDown();
        System.out.println("哲学家 " + name + " 放下了左筷子");
        System.out.println("哲学家 " + name + " 准备放下右筷子...");
        right.pickDown();
        System.out.println("哲学家 " + name + " 放下了右筷子");
    }

    public void run(){
        for(int i = 0; i < num; i++){
            eat();
        }
    }


}
