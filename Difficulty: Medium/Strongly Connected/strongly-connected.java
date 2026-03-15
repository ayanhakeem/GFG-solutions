import java.util.*;

class Solution {
    // Step 1: Perform DFS and store nodes in stack by finishing time
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }
        // Push the node into stack after visiting all neighbors
        st.push(node);
    }

    // Step 2: Perform DFS on transposed graph
    private void dfs3(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true;
        for (int it : adjT.get(node)) {
            if (!vis[it]) {
                dfs3(it, vis, adjT);
            }
        }
    }

    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // Build adjacency list from edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        // Step 1: Do DFS to fill stack by finishing times
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2: Build the transpose graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        
        Arrays.fill(vis, false); // reset visited
        
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                adjT.get(it).add(i); // reverse edge
            }
        }

        // Step 3: Process stack to count SCCs
        int scc = 0;
        while (!st.empty()) {
            int node = st.pop();
            if (!vis[node]) {
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
}
