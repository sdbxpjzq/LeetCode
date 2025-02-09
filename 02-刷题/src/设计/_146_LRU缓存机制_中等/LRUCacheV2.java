package 设计._146_LRU缓存机制_中等;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheV2 {
    private int capacity;
    public class LRUHASHMAP<K, V> extends LinkedHashMap<K, V> {
        // 超出capacity,删除最久没用的即第一个,或者可以复写renoveEldestEntry方法
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public LRUHASHMAP<Integer, Integer> lru;
    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        this.lru = new LRUHASHMAP<>();
    }

    public int get(int key) {
        Integer value = lru.get(key);
        if (null == value) {
            return -1;
        }
        //找到了就刷新数据
        lru.remove(key);
        lru.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (lru.containsKey(key)) {
            lru.remove(key);
        }
        lru.put(key, value);
    }
}
