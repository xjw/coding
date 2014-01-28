import java.util.*;

public class InsertRemoveGetRand {
    List<String> list = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>(); 

    InsertRemoveGetRand () {
    }

    void insert(String s) {
        list.add(s);
        map.put(s, list.size()-1);
    }

    void remove(String s) {
        if (map.containsKey(s)) {
            int pos = map.get(s);
            int lastIndex = list.size()-1;
            String last = list.get(lastIndex);
            list.set(pos,last);
            list.remove(lastIndex);
        }
    }

    String getRand() {
        Random rand = new Random();
        int v = rand.nextInt(list.size());
        return list.get(v);
    }

    public static void main(String[] args) {
        InsertRemoveGetRand irgr = new InsertRemoveGetRand();
        irgr.insert("a");
        irgr.insert("b");
        irgr.insert("c");
        irgr.insert("d");
        irgr.remove("b");
        System.out.println(irgr.getRand());
        System.out.println(irgr.getRand());
    }

}
