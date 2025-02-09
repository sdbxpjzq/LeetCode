package 设计._146_LRU缓存机制_中等;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {
    int capacity;
    Map<Integer, Integer> map;
    public LRUCache3(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        //如果没有找到
        if (!map.containsKey(key)) {
            return -1;
        }
        //找到了就刷新数据
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        //超出capacity，删除最久没用的即第一个,或者可以复写removeEldestEntry方法
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}
