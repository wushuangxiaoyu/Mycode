package 第四章_递归和动态规划.第一题;

/**
 * 斐波那契数列 返回第n个数
 * Created by  Yu  on  2018/3/31.
 */
public class Fibonacci {

    //2^n 暴力递归
    public int f1(int n){
        if(n==1||n==2)
            return 1;
        return f1(n-1)+f1(n-2);
    }

    //费空间省时间（N）
    public int f2(int n){
        if(n==1||n==2) {
            return 1;
        }
        int res=1;
        int pre=1;
        int tmp;
        for(int i=3;i<=n;i++)
        {
            tmp=res;
            res=res+pre;
            pre=tmp;
        }
        return res;
    }

    public int f3(int n){
        return 1;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        System.out.println(fibonacci.f1(3));
        System.out.println(fibonacci.f1(20));
        //递归真的很慢
        System.out.println(fibonacci.f1(30));
        System.out.println(fibonacci.f2(3));
        System.out.println(fibonacci.f2(4));
        System.out.println(fibonacci.f2(1000));
    }

}
