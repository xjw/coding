import java.util.*;
/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */

/**
 * Solutions:
 *
 * 1. Same as LadderI, use BFS to find shortest path, instead of recording shortest length, 
 *    this time, path(List<String>) is recorded
 * 2. Need to find all shortest paths, so 
 *      * boolean variable is need to mark success
 *      * word can not be removed from dict until that level finishes
 */

public class WordLadderII {
    public String replaceCharAt(String word, int pos, char newCh) {
        char[] chars = word.toCharArray();
        chars[pos] = newCh;
        return String.valueOf(chars);
    }

    public List<String> getOneDistanceWords(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String newWord = replaceCharAt(word, i, ch);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }
        return result;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new LinkedList<>();
        Queue<List<String>> q = new LinkedList<>();

        List<String> firstList = new LinkedList<>();
        firstList.add(start);
        q.add(firstList);
        dict.add(end); // key
        dict.remove(start);

        boolean found = false;

        while (!found && !q.isEmpty()) {
            int size = q.size();
            Set<String> toBeRemoved = new HashSet<>();
            while (size-- > 0) {
                List<String> list = q.poll();
                String word = list.get(list.size() - 1);
                for (String newWord : getOneDistanceWords(word, dict)) {
                    toBeRemoved.add(newWord); // key
                    List<String> newList = new LinkedList<String>(list);
                    newList.add(newWord); 
                    q.add(newList);
                    if (newWord.equals(end)) {
                        found = true;
                        result.add(newList);
                    }
                }
            }
            dict.removeAll(toBeRemoved);
        }

        return result;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
        List<List<String>> res = new WordLadderII().findLadders(start, end, dict);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }


}
