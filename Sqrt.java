public class Sqrt {

    public int binarySearchSqrt(int x) {
        if (x <= 1) return x;
        int l, r;
        l = 1;
        r = x;
        while (r > l) {
            int m = l + (r - l)/2;
            if (m <= x/m &&  (m + 1) > x / (m+1)) return m;
            else if (m > x / m) r = m-1;
            else l = m+1;
        }
        return l;
    }

    /**
     * y = x^2 - n
     * dy1/dx1 = (y2 -y1) / (x2 - x1)
     * dy1/dx1 = 2 * x1
     * set y2 = 0
     * x2 = x1 - (x1^2 - n)/(2 * x1) = 1/2 (x1 + n / x1)
     */
    public int newtonSqrt(int x) {
        if (x <= 1) return x;
        double x0 = 0;
        double x1 = x/2;
        while (Math.abs(x0 - x1) > 0.001) {
            x0 = x1;
            x1 = (x1 + x / x1) /2 ;
        }
        return (int)curr;
    }

    /**
     * geometrically x should gets smaller first and when it turns bigger, 
     * the previous x is the answer
     */
    public int newtonSqrtBest(int x) {
        if (x <= 1) return x;
        int x0 = x;
        int x1 = x/2;
        while (x0 > x1) { // turning point from x^2 > n to x^2 < n
            x0 = x1;
            x1 = (x1 + x/x1) / 2;
        }
        return x0;
    }

    double sqrt(double x) {
        if (x == 0) return 0;
        double last = 0.0;
        double res = 1.0;
        while (res != last)
        {
            last = res;
            res = (res + x / res) / 2;
        }
        return res;
    }
    

    public static void main(String[] args) {
        System.out.println(new Sqrt().newtonSqrt(3));
    }


}
