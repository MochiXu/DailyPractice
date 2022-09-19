package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class _9_19_frequencySort_v1 {
    public int[] frequencySort(int[] nums) {
        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        for (int element : nums){
            if (!treeMap.containsKey(element)){
                treeMap.put(element,1);
            }else
                treeMap.put(element,treeMap.get(element)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, (o1, o2) -> Objects.equals(o1.getValue(), o2.getValue()) ?o2.getKey()-o1.getKey():o1.getValue()-o2.getValue());
        int []re=new int[nums.length];
        int f=0;
        for (Map.Entry<Integer,Integer> entry : list){
            for (int i =0;i<entry.getValue();i++){
                re[f++]=entry.getKey();
            }
        }
        return re;
    }
}
