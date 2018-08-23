package 其他.Thread.哲学家吃饭问题1;

/**
 * Created by  Yu  on  2017/12/4.
 * 哲学家吃饭问题  有可能发生死锁
 */
public class Demo {
    public static void main(String[] args) {
        ChopStick[] chopStick=new ChopStick[5];
        for(int i=0;i<5;i++)
            chopStick[i]=new ChopStick();
        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0]=new Philosopher(chopStick[1],chopStick[0],"A");
        philosophers[1]=new Philosopher(chopStick[2],chopStick[1],"B");
        philosophers[2]=new Philosopher(chopStick[3],chopStick[2],"C");
        philosophers[3]=new Philosopher(chopStick[4],chopStick[3],"D");
        philosophers[4]=new Philosopher(chopStick[0],chopStick[4],"E");
        for(int i=0;i<5;i++)
            philosophers[i].start();
    }
}
