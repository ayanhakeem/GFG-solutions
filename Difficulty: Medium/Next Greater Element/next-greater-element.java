class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        // Traverse from right → left
        for (int i = n - 1; i >= 0; i--) {

            // Pop all smaller elements
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack empty → no greater element
            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            // Push current element
            st.push(arr[i]);
        }

        // convert array into ArrayList
        for (int x : nge) ans.add(x);

        return ans;
    }
}
