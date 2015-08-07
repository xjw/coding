import java.util.*;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;

    protected static <K, V> LinkedHashMap<K, V> LRUFactory(final int capacity) {
        return new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    LRUCache(int capacity) {
        cache = LRUCache.<Integer, Integer>LRUFactory(capacity);
    }

    int get(int key) {
        return cache.containsKey(key)? cache.get(key): -1;
    }

    void set(int key, int value) {
        cache.put(key, value);
    }

    public static void Main(String[] args) {
    }
}
