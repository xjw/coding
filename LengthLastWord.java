public class LengthLastWord {
    /**
     * Need a boolean to indicate whether previous character is space
     * (to record new start - character after space)
     */
    public int lengthOfLastWord(String s) {
        int start = 0;
        int end = -1;
        boolean prevSpace = false;
        for (int i=0; i< s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                prevSpace = true;
            } else {
                if (prevSpace) start = i;
                end = i;
                prevSpace = false;
            }
        }
        return end - start + 1;
    }

}
