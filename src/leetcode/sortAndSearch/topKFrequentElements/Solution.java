package leetcode.sortAndSearch.topKFrequentElements;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author Yu
 * @create 2018-07-24 18:57
 **/
public class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Map.Entry item : map.entrySet()) {
            if (treeMap.containsKey(item.getValue())) {
                treeMap.get(item.getValue()).add((Integer) item.getKey());
            } else {
                List<Integer> list = new ArrayList<>();
                list.add((Integer) item.getKey());
                treeMap.put((Integer) item.getValue(), list);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry item : treeMap.entrySet()) {
            List<Integer> values = (List<Integer>) item.getValue();
            for (int i = 0; i < values.size(); i++){
                if (k == 0) {
                    return list;
                }
                list.add(values.get(i));
                k--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}
