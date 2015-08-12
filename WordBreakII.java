import java.util.*;


/**
* https://leetcode.com/submissions/detail/36021271/
* https://stupidcodergoodluck.wordpress.com/2013/11/16/leetcode-word-break-ii/
* http://www.acmerblog.com/word-break-ii-6128.html
*/

public class WordBreakII {

    public void dfs(String s, int start, Set<String> wordDict, boolean[] cache, String curr, List<String> result) {
        if (start >= s.length()) {
            result.add(curr);
            return;
        }

        for (int i = start+1; i <= s.length(); i++) {
            if (cache[i]) {
                String prefix = s.substring(start, i);
                if (wordDict.contains(prefix)) {
                    String newStr = curr.isEmpty()? prefix : curr + " " + prefix;
                    dfs(s, i, wordDict, cache, newStr, result);
                }
            }
        }
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
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
        List<String> result = new LinkedList<String>();
        if (!cache[0]) return result;
        dfs(s, 0, wordDict, cache, "", result);
        return result;
    }


    /**
     * Timeout on 
     * "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
     * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     */ 
    public List<String> wordBreakTimedOut(String s, Set<String> wordDict) {
        int len = s.length();
        List<String>[] words = new LinkedList[len+1];
        words[len] = new LinkedList<String>();
        for (int i = len - 1; i >=0; i--) {
            for (int j = i; j <= len; j++) {
                List<String> suffixList = words[j];
                if (suffixList != null)  {
                    String prefix = s.substring(i, j);
                    if (wordDict.contains(prefix)) {
                        List<String> res = (words[i] == null)? new LinkedList<String>() : words[i];
                        if (suffixList.isEmpty()) {
                            res.add(prefix);
                        } else {
                            for (String suffix : words[j]) {
                                res.add(prefix + " " + suffix); 
                            }
                        }
                        words[i] = res;
                    }
                }
            }
        }

        return words[0];
    }

    public void test() {
        Set<String> dict = new HashSet<String>(Arrays.asList("home", "depot", "jack", "in", "the", "box"));
        System.out.println(wordBreak("homedepot", dict));
        //System.out.println(wordBreak("jackinthebox", dict));
    }

    public static void main(String[] args) {
        new WordBreakII().test();
    }
}
