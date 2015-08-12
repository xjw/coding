import java.util.*;
import java.util.regex.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreakDP(s, wordDict);
    }

    /**
     * Worst time complexity O(2^n) (n = s.length())
     * basically explore all the possible segmentations 
     * s = ("aaaaaaaaaab")
     * dict = ("a", "aa", "aaa")
     */
    public boolean wordBreakRecursion(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty()) return true;

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix) && wordBreakRecursion(s.substring(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * O(n^2) with caching
     */ 
    public boolean wordBreakRecursionWithCaching(String s, Set<String> wordDict, Map<String, Boolean> cache) {
        if (s == null || s.isEmpty()) return true;
        if (cache.containsKey(s)) return cache.get(s);

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix) && wordBreakRecursionWithCaching(s.substring(i))) {
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);
        return false;
    }

    /**
     * O(n^2) with caching
     *
     * 1. len+1 arary is needed to guard for ending case, as well as set ending to true
     * 2. check cache[j] first before substr which is more expensive
     */
    public boolean wordBreakDP(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] cache = new boolean[len+1];
        cache[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j <= len ; j++) {
                if (cache[j] && wordDict.contains(s.substring(i,j))) {
                    cache[i] = true;
                }
            }
        }
        return cache[0];
    }

    /**
     * DFA can be built in O(2^m) (m = wordDict.size()) steps and evaluated in O(n) (n = s.length())
     */
    public boolean wordBreakRegex(String s, Set<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        for (String w : wordDict) {
            sb.append(w + "|");
        }
        String pattern = sb.toString().substring(0, sb.length()-1);
        pattern = "(" + pattern + ")*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        return m.matches();

    }


    public void test() {
        Set<String> dict = new HashSet<String>(Arrays.asList("home", "depot", "jack", "in", "the", "box"));
        System.out.println(wordBreakDP("homedepot", dict));
        System.out.println(wordBreakDP("jackinthebox", dict));
    }

    public static void main(String[] args) {
        new WordBreak().test();
    }

}

