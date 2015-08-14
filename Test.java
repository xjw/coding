import java.util.*;

class Test {
    public static <T> List<T> test() {
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        List<Integer> l = Test.<Integer>test();
        System.out.println("abc".substring(2,3));
    }

}
