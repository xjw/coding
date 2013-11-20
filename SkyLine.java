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

    public Class Point {
        int x;
        int w;
        boolean isStart;
        public Point(int x, int w, boolean isStart) {
            this.x = x;
            this.w = w;
            this.isStart = isStart;
        }
    }

    class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
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

    public void TestSkyLine() {
        String text =
              "2,5,10\n" 
            + "6,10,2\n"
            + "1,6,1\n"
            + "8,12,8\n"
            ;

        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        List<Line> lines = new LinkedList<Line>();
        lines.add(new Line(2,5,10));
        lines.add(new Line(6,10,2));
        lines.add(new Line(1,6,1));
        lines.add(new Line(8,12,8));
    }
}
