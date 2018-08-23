package 其他.sort.quickSort;

import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author Yu
 * @create 2018-08-22 21:07
 **/
public class Solution {
    private static void quickSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int l, int h) {
        if (l < h) {
            swap(a, l + (int) (Math.random() * (h - l + 1)), l);
            int[] p = partition(a, l, h);
            quickSort(a, l, p[0]);
            quickSort(a, p[1], h);
        }
    }

    private static int[] partition(int[] a, int l, int h) {
        int less = l - 1;
        int more = h;
        while (l < more) {
            if (a[l] < a[h]) {
                swap(a, ++less, l++);
            } else if (a[l] > a[h]) {
                swap(a, --more, l);
            } else {
                l++;
            }
        }
        swap(a, more, h);
        return new int[]{less,more};
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[20];
        int[] b = new int[]{2, 1};
        Random random = new Random(1);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println("排序前：");
        for (int i : a) {
            System.out.print(i + "  ");
        }
        quickSort(a);
        System.out.println("");
        System.out.println("排序后");
        for (int i : a) {
            System.out.print(i + "  ");
        }

    }


}
