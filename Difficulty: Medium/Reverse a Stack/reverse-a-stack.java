class Solution {

    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        // Base case
        if(st.isEmpty()) {
            st.push(x);
            return st;
        }

        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);

        return st;
    }

    public static void reverseStack(Stack<Integer> st) {
        // Base case
        if(st.isEmpty()) return;

        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st, top);
    }
}
