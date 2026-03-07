class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
         // Create adjacency list for undirected graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list from edge list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize distance array with large value (infinity)
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        // Set source distance to 0
        dist[src] = 0;

        // Initialize queue for BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(src);//add initial src with 0 to 0 is dist 0

        // BFS traversal
        while (!q.isEmpty()) {
            int node = q.poll();

            // Traverse neighbors
            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        // Prepare result, replacing infinity with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
//tc=o(v+e)
//sc=
 