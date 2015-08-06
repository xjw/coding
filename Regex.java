/*
 implement regular expression matching with support for '.' and '*'.
       '.' Matches any single character.
       '*' Matches zero or more of the preceding element.
       The matching should cover the entire input string (not partial).
       The function prototype should be:
       bool isMatch(const char *s, const char *p)
       Some examples:
       isMatch("aa","a") → false
       isMatch("aa","aa") → true
       isMatch("aaa","aa") → false
       isMatch("aa", "a*") → true
       isMatch("aa", ".*") → true
       isMatch("ab", ".*") → true
       isMatch("aab", "c*a*b") → true
*/
public class Regex {

    public boolean charEqual(char cs, char cp) {
        return cs == cp || cp == '.';
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        // next character is not *
        if (p.length() == 1 || p.charAt(1) != '*') {
            return !s.isEmpty() &&
                charEqual(s.charAt(0), p.charAt(0)) &&
                isMatch(s.substring(1), p.substring(1));
        }

        int i=0;
        // next character is *
        while (i<s.length() && charEqual(s.charAt(i), p.charAt(0))) {
            if (isMatch(s.substring(i), p.substring(2))) return true;
            i++;
        }
        return isMatch(s.substring(i), p.substring(2));
    }
}
