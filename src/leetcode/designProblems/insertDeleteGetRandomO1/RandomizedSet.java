package leetcode.designProblems.insertDeleteGetRandomO1;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * @author Yu
 * @create 2018-07-26 19:52
 **/
public class RandomizedSet {
    private Map<Integer, Integer> indexIsKeyMap;
    private Map<Integer, Integer> valueIsKayMap;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        indexIsKeyMap = new HashMap<>();
        valueIsKayMap = new HashMap<>();
        size = 0;

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueIsKayMap.containsKey(val)) {
            return false;
        }
        indexIsKeyMap.put(size, val);
        valueIsKayMap.put(val, size++);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valueIsKayMap.containsKey(val)) {
            return false;
        }
        size--;
        Integer index = valueIsKayMap.get(val);
        Integer tmp = indexIsKeyMap.get(size);
        indexIsKeyMap.put(index, tmp);
        valueIsKayMap.put(tmp, index);
        valueIsKayMap.remove(val);
        indexIsKeyMap.remove(size);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (indexIsKeyMap.size() == 0) {
            throw new RuntimeException("dont have ");
        }else {
            System.out.println("Random :"+(int)(Math.random() * size));
            return indexIsKeyMap.get((int)(Math.random() * size));
        }
    }

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(1));
        System.out.println(r.insert(20));
        System.out.println(r.insert(30));
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());
        System.out.println(r.getRandom());

    }
}
