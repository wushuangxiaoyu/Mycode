package 其他.Thread.哲学家吃饭问题1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by  Yu  on  2017/12/4.
 * 哲学家吃饭问题 筷子类
 */
public class ChopStick {
    protected Lock lock;

    public ChopStick(){
        lock = new ReentrantLock();
    }

    public boolean pickUp(){
        lock.lock();
        /*try {
			int sleepTime = (int)(Math.random() * 500 + 10);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
        System.out.println(this.getClass().getSimpleName()+"——》拿起筷子上锁");
        return true;
    }

    public boolean pickDown(){
        lock.unlock();
        System.out.println(this.getClass().getSimpleName()+"——>放下筷子 解锁");
        return true;
    }
}
