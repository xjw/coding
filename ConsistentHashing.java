import java.util.*;

public class ConsistentHashing<T> {

    public static class HashFunction {
        int hash(Object o) {
            return o.hashCode();
        }
    }

    private final TreeMap<Integer, T> circle = new TreeMap<>();
    private HashFunction hf;

    public ConsistentHashing(HashFunction hf) {
        this.hf = hf;
    }

    public void add(T node) {
        circle.put(hf.hash(node), node);
    }

    public void delete(T node) {
        circle.remove(hf.hash(node));
    }

    public T get(Object key) {
        if (circle.isEmpty()) return null;

        int hash = hf.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, T> tailMap = circle.tailMap(hash);
            if (tailMap.isEmpty()) {
                hash = circle.firstKey();
            } else {
                hash = tailMap.firstKey();
            }
        }
        return circle.get(hash);
    }

    public static void main(String[] args) {
        HashFunction hf = new HashFunction();
        ConsistentHashing ch = new ConsistentHashing<String>(hf);
        ch.add("server1");
        ch.add("server3");
        ch.add("server5");
        System.out.println(ch.get("server0"));
        System.out.println(ch.get("server2"));
    }
}
