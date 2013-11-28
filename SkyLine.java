/*
    S1: {[2,5], vol=10}, {[6,10], vol=2}, ...
    S2: {[1,6], vol=1}, {[8,12], vol=8}, ...
    ...

    Find largest vol from each segmentation and print it out
    [1,2],vol=1, [2,5], vol=10, [5,6], vol = 1, [6,8], vol = 2, [8,12], vol = 8.

    Sources:
    http://www.mitbbs.com/article_t1/JobHunting/32579865_0_1.html
    http://www.mitbbs.com/article_t1/JobHunting/32569901_0_2.html
*/
import java.util.*;
public class SkyLine {

    public static void main(String[] args) {
        new SkyLine().TestSkyLine();
    }

    class Point {
        int x, w, l;
        boolean isStart;

        public Point(int x, int w, int l, boolean isStart) {
            this.x = x;
            this.w = w;
            this.l = l;
            this.isStart = isStart;
        }

        public String toString() {
            return Integer.toString(x);
        }

        public boolean equals(Object o) {
            return (o instanceof Point &&
                    this.x == o.x && this.w == o.w && this.l == o.l && this.isStart == o.isStart);
        }
    }

    class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.x == b.x) { // this is important
                int as = a.isStart? 1 : 0;
                int bs = b.isStart? 1 : 0;
                return as - bs;
            }
            return a.x - b.x;
        }
    }

    public class Line {
        int start, end, w;
        Line(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

    public List<String> getSkyLine(List<Point> points) {
        List<String> res = new ArrayList<String>();

        Collections.sort(points, new PointComparator());
        //for (Point p : points) { System.out.println(p); }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(points.size(),Collections.reverseOrder());

        Point prev = null;
        Set<Integer> lineSet = new HashSet<Integer>();

        for (Point p : points) {
            int w = p.w;

            if (p.isStart) lineSet.add(p.l);
            else lineSet.remove(p.l);

            if (prev != null) {
                line = prev.x + "," + p.x + "," + pq.peek();
                res.add(line);
            }
            prev = p;
            // no line start before current end point, then reset prev to null
            if (lineSet.isEmpty() && !p.isStart) prev = null;
            //System.out.println(lineSet);
            //System.out.println(prev.toString());

            if (p.isStart) pq.add(w);
            else pq.remove(w);

            return res;
        }
    }

    public void TestSkyLine() {
        String text =
              "2,5,10\n" 
            + "6,10,2\n"
            + "1,6,1\n"
            + "8,12,8\n"
            ;

        Scanner scanner = new Scanner(text);
        List<Point> points = new ArrayList<Point>();
        int i = 0;
        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] data = line.split(",");
            Point ps= new Point(Integer.parseInt(data[0]),Integer.parseInt(data[2]),i,true);
            Point pe = new Point(Integer.parseInt(data[1]),Integer.parseInt(data[2]),i,false);
            points.add(ps);
            points.add(pe);
            i++;
        }
        List<String> expected = new ArrayList<String>();
        expected.add("1,2,1");
        expected.add("2,5,10");
        expected.add("5,6,1");
        expected.add("6,8,2");
        expected.add("8,10,8");
        expected.add("10,12,8");

        assert(expected.equals(getSkyLine(points)));
    }
}
