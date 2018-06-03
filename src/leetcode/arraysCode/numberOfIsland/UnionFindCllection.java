package leetcode.arraysCode.numberOfIsland;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 *
 * @author Yu
 * @create 2018-06-02 21:09
 **/
public class UnionFindCllection<T> {
    private HashMap<T,T> fatherMap;
    private HashMap<T,Integer> sizeMap;

    public UnionFindCllection() {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
    }

    public UnionFindCllection(List<T> list){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (T item :list) {
            fatherMap.put(item,item);
            sizeMap.put(item,1);
        }
    }

    public T findFather(T node){
        T father = fatherMap.get(node);
        if(father!=node){
            father = findFather(node);
        }
        fatherMap.put(node,father);
        return father;
    }

    public boolean nodeIsEqual(T a ,T b){
        return findFather(a)==findFather(b);
    }

    public void union(T a,T b){
        if(a==null||b==null){
            return ;
        }
        T aFather = findFather(a);
        T bFather = findFather(b);
        if(aFather!=bFather){
            int aSize = sizeMap.get(aFather);
            int bSzie = sizeMap.get(bFather);
            if(aSize>bSzie){
                fatherMap.put(bFather,aFather);
                sizeMap.put(aFather,aSize+bSzie);
            }
            else {
                fatherMap.put(aFather,bFather);
                sizeMap.put(bFather,aSize+bSzie);
            }
        }

    }
}
