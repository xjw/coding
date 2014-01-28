import java.util.*;
// p1: java string comparison use equals not ==, use "+" not '+'!
// p2: missing break in case statement!
class RPN {
    public int eval(int l, int r, String op) {
        int res = 0;
        switch (op) {
            case "+": res = l + r; break;
            case "-": res = l - r; break;
            case "*": res = l * r; break;
            case "/": res = l / r; break;
        }
        return res;
    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<String>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            // if (s == "+" || s == "-" || s == "*" || s == "/") {
                String rh = stack.removeFirst();
                String lh = stack.removeFirst();
                int r = Integer.parseInt(rh);
                int l = Integer.parseInt(lh);
                stack.addFirst(Integer.toString(eval(l,r,s)));
            } else  {
                stack.addFirst(s);
            }
        }
        return Integer.parseInt(stack.removeFirst());
    }

    public static void main(String[] args) {
        RPN rpn = new RPN();
        System.out.println(rpn.evalRPN(new String[] {"0","3","/"}));
        System.out.println(rpn.evalRPN(new String[] {"4","-2","/","2","-3","-","-"}));
    }
}
