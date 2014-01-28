import java.util.*;

// P1, Double(+0.) not equals Double(-0.), so they will be different key in hashmap

public class MaxPointsInLine {
    public int numPointsColine(int idx, Point[] points) {
        Map<Double, Integer> counter = new HashMap<Double, Integer>();
        int numSamePoint = 0;
        int maxCount = 1;
        int COUNTER_INITIAL_VAL = 2;
        Point p = points[idx];
        for (int i=idx+1; i<points.length; i++) {
            if (i == idx) continue;
            Point pt = points[i];
            if (pt.x == p.x && pt.y == p.y) {
                numSamePoint++;
                continue;
            }
            double slope = (pt.x == p.x)? Double.POSITIVE_INFINITY : 1.0*(pt.y - p.y)/(pt.x - p.x);
            System.out.println(slope);
            if (slope == 0) slope = 0;
            int slopeCount = counter.containsKey(slope)? counter.get(slope)+1 : COUNTER_INITIAL_VAL;
            counter.put(slope, slopeCount);
            maxCount = Math.max(slopeCount, maxCount);
        }
        return maxCount + numSamePoint;
    }

    public int maxPoints(Point[] points) {
        int max = 0;
        for (int i=0; i<points.length; i++) {
            int np = numPointsColine(i, points);
            if (np > max) max = np;
        }
        return max;
    }


    // Definition for a point.
    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public static void main(String[] args) {
        MaxPointsInLine mpil = new MaxPointsInLine();
        Point[] points = {new Point(2,3), new Point(3,3), new Point(-5,3)};
        System.out.println(mpil.maxPoints(points));
    }


}
