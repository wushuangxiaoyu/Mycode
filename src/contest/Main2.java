package contest;

import java.text.DecimalFormat;
        import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-20 20:32
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextDouble()){
            double R = sc.nextDouble();
            int x = sc.nextInt();
            DecimalFormat df = new DecimalFormat("#.############################################");
            System.out.println(df.format(myPow(R,x))+" ");
        }
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }
        if (n == 2) {
            return x * x;
        }
        if ((n & 1) == 0) {
            return myPow(myPow(x, n / 2), 2);
        } else {
            return x * myPow(myPow(x, n / 2), 2);
        }
    }
}
