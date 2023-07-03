import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int totalSum = 0;
        for (String str : operations) {
            if (str.equals("+") && st.size() >= 2) {
                int num1 = st.pop();
                int num2 = st.peek();
                int res = num1 + num2;
                st.push(num1);
                st.push(res);
            } else if (str.equals("C") && !st.isEmpty()) {
                st.pop();
            } else if (str.equals("D") && !st.isEmpty()) {
                int res = st.peek();
                st.push(2 * res);
            } else {
                st.push(Integer.parseInt(str));
            }
        }
        // total sum
        while (!st.isEmpty()) {
            System.out.println("final digits ->" + st.peek());
            totalSum += st.pop();
        }
        return totalSum;
    }
}