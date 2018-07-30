package 其他.HeapSort;

import java.util.Random;

/**
 * 堆排序
 *
 * @author Yu
 * @create 2018-07-29 16:48
 **/
public class Solution {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        //建立大根堆
        for (int i = 0; i < nums.length; i++) {
            HeapInsert(nums, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
    }

    private static void heapify(int[] nums, int i, int size) {
        int leftIndex = 2 * i + 1;
        while (leftIndex < size) {
            int largestIndex = leftIndex + 1 < size && nums[leftIndex + 1] > nums[leftIndex] ? leftIndex + 1 : leftIndex;
            largestIndex = nums[i] > nums[largestIndex] ? i : largestIndex;
            if(largestIndex == i){
                break;
            }
            swap(nums,i,largestIndex);
            i = largestIndex;
            leftIndex =  2 * i + 1;
        }
    }

    private static void HeapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i - 1) / 2]) {
            swap(nums, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[20];
        int[] b = new int[]{2, 1};
        Random random = new Random(0);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println("排序前：");
        for (int i : a) {
            System.out.print(i + "  ");
        }
        sort(a);
        System.out.println("");
        System.out.println("排序后");
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println("排序前：");
        for (int i : b) {
            System.out.print(i + "  ");
        }
        sort(b);
        System.out.println("排序后");
        for (int i : b) {
            System.out.print(i + "  ");
        }

    }
}
