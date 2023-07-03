import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (!stk.isEmpty()) {
                    if (c == ')' && '(' == stk.peek()) {
                        stk.pop();
                    } else if (c == ']' && '[' == stk.peek()) {
                        System.out.println("current ] " + stk.peek());
                        stk.pop();
                    } else if (c == '}' && '{' == stk.peek()) {
                        stk.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            }
        }
        return stk.isEmpty();
    }
}