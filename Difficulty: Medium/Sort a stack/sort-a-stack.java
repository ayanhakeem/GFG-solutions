class Solution {
    public void sortStack(Stack<Integer> st) {
         Stack<Integer> s1 = new Stack<>();

        while (!st.isEmpty()) {
            int temp = st.pop();
            // move smaller elements back to original stack
            while (!s1.isEmpty() && s1.peek() < temp) {
                st.push(s1.pop());
            }
            s1.push(temp);
        }

        // move back so top of st is largest
        while (!s1.isEmpty()) {
            st.push(s1.pop());
        }
    }
}
