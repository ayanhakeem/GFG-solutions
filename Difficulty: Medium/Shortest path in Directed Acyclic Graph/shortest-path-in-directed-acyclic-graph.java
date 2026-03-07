// User function Template for Java
class Solution {
     private void topoSort(int node, List<List<int[]>> adj, boolean[] visited, Stack<Integer> stack) {
        
        // Mark the current node as visited
        visited[node] = true;
        
        // Traverse all adjacent nodes
        for (int[] neighbor : adj.get(node)) {
            
            // If the neighbor hasn't been visited, recurse
            if (!visited[neighbor[0]]) {
                topoSort(neighbor[0], adj, visited, stack);
            }
        }
        
        // After visiting all neighbors, push this node into the stack
        stack.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        
        //we use toposort bcoz we know it is dag and intution behind it is we start from src and move its neighbours why we compute src dist and then we go to the neighbours to compute distance means ex=6 5 4 3 in this 6 is src and if we reach 5 we have to come from 6 so we computed 6 dist right we can easily do for the 5 like this so on...
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Fill the adjacency list from edge list
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});//stored in pair v and wt
        }

        // Initialize visited array for topo sort
        boolean[] visited = new boolean[V];
        
        // Stack to hold topological order
        Stack<Integer> stack = new Stack<>();
        
        // Perform topo sort from unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        // Initialize distance array with infinity (represented by large value)
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        // Distance to source (0) is 0
        dist[0] = 0;

        // Process nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            // If the node is reachable
            if (dist[node] != (int)1e9) {
                
                // Traverse all neighbors and update their distances
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int wt = neighbor[1];
                    
                    // Relax the edge
                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Replace all unreachable nodes with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }

        // Return the final distance array
        return dist;
    }
}
