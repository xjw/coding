import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/


/**
 * Solution:
 * 1. shortest path - BFS
 * 2. visited node - remove from dict
 * 3. worst case 
 *    time complexity - O(dict.size * 26 * word.length())
 *    space complexity - O(dict.size)
 */
public class WordLadder {

    public String replaceCharAt(String str, int i, char newCh) {
        char[] chars = str.toCharArray();
        chars[i] = newCh;
        return String.valueOf(chars);
    }


    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int len = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            while (count-- > 0) {
                String word = q.poll();
                for (int i=0; i<word.length(); i++) {
                    for (char ch='a'; ch <='z'; ch++) {
                        String newStr = replaceCharAt(word, i, ch);
                        if (newStr.equals(endWord)) {
                            return len + 1;
                        }
                        if (wordDict.contains(newStr)) {
                            q.add(newStr);
                            wordDict.remove(newStr);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
