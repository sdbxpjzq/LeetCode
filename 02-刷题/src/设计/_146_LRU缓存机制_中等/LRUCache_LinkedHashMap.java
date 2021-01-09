package 设计._146_LRU缓存机制_中等;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache_LinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache_LinkedHashMap(int capacity) {
        // zz true -  访问顺序 false  -  插入顺序
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
