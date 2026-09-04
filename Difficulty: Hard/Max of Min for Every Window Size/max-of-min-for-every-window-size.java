class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        int[] left = new int[n];
        int[] right = new int[n];

        // Find Previous Smaller Element
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();

            st.push(i);
        }

        st.clear();

        // Find Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();

            st.push(i);
        }

        // Find maximum of minimums for every window size
        int[] res = new int[n + 1];

        for (int i = 0; i < n; i++) {

            // arr[i] is minimum for this window length
            int len = right[i] - left[i] - 1;

            res[len] = Math.max(res[len], arr[i]);
        }

        // Fill missing window sizes
        for (int k = n - 1; k >= 1; k--) {
            res[k] = Math.max(res[k], res[k + 1]);
        }

        for (int k = 1; k <= n; k++) {
            ans.add(res[k]);
        }

        return ans;
    }
}