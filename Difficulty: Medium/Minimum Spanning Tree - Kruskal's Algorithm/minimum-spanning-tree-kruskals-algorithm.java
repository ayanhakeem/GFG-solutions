class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        
        // Sort edges by weight
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        
        // Initialize Disjoint Set
        int[] parent = new int[V];
        int[] size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        int sum = 0;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            int pu = findUPar(u, parent);
            int pv = findUPar(v, parent);
            
            // If not in same component, include this edge
            if (pu != pv) {
                sum += wt;
                unionBySize(pu, pv, parent, size);
            }
        }
        
        return sum;
    }
    
    // Path compression
    static int findUPar(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node], parent);
    }
    
    // Union by size
    static void unionBySize(int u, int v, int[] parent, int[] size) {
        if (size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        } else {
            parent[v] = u;
            size[u] += size[v];
        }
    }
}