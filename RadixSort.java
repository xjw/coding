import java.util.*;

/*
18, 5, 100, 3, 19

100, 3, 5, 18, 19
100, 3, 5, 18, 19
3, 5, 18, 19, 100
*/

class RadixSort {
    public static int RADIX = 10;

    public void radixSort(int[] input) {
        List<Integer>[] buckets = new ArrayList[RADIX];
        for (int i=0; i<RADIX; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        int base = 1;
        boolean finished = false;
        while (!finished) {
            finished = true;
            for (int i : input) {
                if (i > base) finished = false;
                buckets[(i / base) % RADIX].add(i);
            }
            for (int i=0, idx=0; i<RADIX; i++) {
                List<Integer> list = buckets[i];
                for (Integer l : list) {
                    input[idx++] = l;
                }
                buckets[i].clear();
            }
            base *= RADIX;
        }
    }

    public void verifySorted(int[] input) {
        for (int i=0; i<input.length; i++) {
            for (int j=i+1; j<input.length; j++) {
                if (input[i] > input[j]) {
                    throw new RuntimeException("Not sorted");
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] input = new int[] {18, 5, 100, 3, 19};
        RadixSort rs = new RadixSort();
        rs.radixSort(input);
        rs.verifySorted(input);
    }
}
