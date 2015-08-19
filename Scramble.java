import java.util.*;

public class Scramble {
    public boolean isScramble(String s1, String s2) {
        return isScrambleRecursion(s1, s2);
    }

    /* pruning by checking SORTED characters */
    public boolean isScr(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }


    /* pruning by checking unordered char sum - lightweight, no sorting needed */
    public boolean isScrLight(String s1, String s2) {
        int h1, h2;
        h1 = h2 = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            h1 += c1[i];
            h2 += c2[i];
        }
        return h1 == h2;
    }

    /**
     * Time complexity worse case O(4^n)
     */
    public boolean isScrambleRecursion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

        if (s1.equals(s2)) return true;
        if (!isScr(s1, s2)) return false;
        int len = s1.length();
        
        for (int i=1; i< len; i++) {
            if 
            ((
             isScrambleRecursion(s1.substring(0, i), s2.substring(0, i)) && 
             isScrambleRecursion(s1.substring(i), s2.substring(i)) 
            ) ||
             (
             isScrambleRecursion(s1.substring(0, i), s2.substring(len-i)) && 
             isScrambleRecursion(s1.substring(i), s2.substring(0, len-i))
             ))
             return true;
        }
        return false;
    }

    /**
     *
     * Idea:
     * let (i, j) start index of s1 and s2
     * n is length of s1/s2
     * k is the pivot point that separates the string into two parts (k = [1, n-1])
     * F(i, j, n) = F(i, j, k) && F(i+n-k, j+n-k, n-k) 
     *          ||  F(i, j+n-k, k) && F(i+n-k, j, n-k)
     * space O(n^3)
     * time O(n^4)
     *
     *
     * Implementations:
     * Base case F(i, j, 1) = true if s1[i] == s2[i]
     * bottom up build cache, F(i, j, 2) => F(i, j, n)
     * the final result is F(0, 0, n)
     */
    public boolean isScrambleDP(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] cache = new boolean[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                cache[i][j][0] = (s1.charAt(i) == s2.charAt(j));
            }
        }

        for (int n = 2; n < len; n++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    boolean found = false;
                    for (int k = 1; k < n && !found; k++) {
                        if ((cache[i][j][k] && cache[i+n-k][j+n-k][n-k]) ||
                           (cache[i][j+n-k][k] && cache[i+n-k][j][n-k])) {
                            found = true;
                           }
                    }
                    cache[i][j][n] = found;
                }
            }
        }
        return cache[0][0][len];
    }

    public static void main(String[] args) {
        System.out.println(new Scramble().isScramble("abb", "bba"));
    }

}
