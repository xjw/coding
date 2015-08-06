import java.util.*;

/*
 * http://yiminghe.iteye.com/blog/250120
 */

class MaxGap {
    public double getMin(double[] inputs) {
        if (inputs.length == 0) return 0;
        double min = inputs[0];
        for (int i=1; i<inputs.length; i++) {
            if (inputs[i] < min) {
                min = inputs[i];
            }
        }
        return min;
    }

    public double getMax(double[] inputs) {
        if (inputs.length == 0) return 0;
        double max = inputs[0];
        for (int i=1; i<inputs.length; i++) {
            if (inputs[i] > max) {
                max = inputs[i];
            }
        }
        return max;
    }


    public double maxGap(double[] inputs) {
        double min = getMin(inputs);
        double max = getMax(inputs);
        int buckets = inputs.length + 1;
        double gap = (max - min) / (buckets);
        double[] l = new double[buckets];
        double[] r = new double[buckets];
        int[] counts = new int[buckets];
        for (int i=0; i<buckets; i++) {
            l[i] = max;
            r[i] = min;
            counts[i] = 0;
        }
        for (double x : inputs) {
            int b = (int) ((x - min) / gap);
            if (b == buckets) b = buckets-1;
            counts[b]++;
            l[b] = Math.min(l[b], x);
            r[b] = Math.max(r[b], x);
        }
        double maxGap = 0;
        double last = r[0];
        for (int i=1; i<buckets; i++) {
            if (counts[i] > 0) {
                maxGap = Math.max(maxGap, l[i] - last);
                last = r[i];
            }
        }
        return maxGap;
    }

    public void testMaxGap() {
        double[] inputs = new double[]{2.3, 3.1, 7.5, 1.5, 6.3};
        MaxGap mg = new MaxGap();
        double gap = mg.maxGap(inputs);
        if (Math.abs(gap - 3.2) < 0.00001) {
            System.out.println("Passed test cases");
        } else {
            System.out.println("Failed test cases");
        }
    }

    public static void main(String[] args) {
        new MaxGap().testMaxGap();
    }
}
