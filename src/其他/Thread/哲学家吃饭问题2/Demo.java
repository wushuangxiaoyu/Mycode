package 其他.Thread.哲学家吃饭问题2;

/**
 * Created by  Yu  on  2017/12/4.
 * 哲学家吃饭问题 不会死锁的哲学家
 *
 * 解决方法:
 *  1至多允许4人同时吃通心面
 *  2奇书号哲学家先去左边的筷子，偶数号哲学家先去取右边的筷子
 *  3每位哲学家取到两双筷子才吃饭，否则一双筷子也不占用————>(!这个Demo用的这个方法)
 */
public class Demo {
    public static void main(String[] args) {
        ChopStick[] chopStick=new ChopStick[5];
        for(int i=0;i<5;i++)
            chopStick[i]=new ChopStick();
        Philosopher[] philosophers = new Philosopher[5];
        philosophers[3]=new Philosopher(chopStick[4],chopStick[3],"D");
        philosophers[4]=new Philosopher(chopStick[0],chopStick[4],"E");
        philosophers[0]=new Philosopher(chopStick[1],chopStick[0],"A");
        philosophers[1]=new Philosopher(chopStick[2],chopStick[1],"B");
        philosophers[2]=new Philosopher(chopStick[3],chopStick[2],"C");
        for(int i=0;i<5;i++)
            philosophers[i].start();
    }
}
