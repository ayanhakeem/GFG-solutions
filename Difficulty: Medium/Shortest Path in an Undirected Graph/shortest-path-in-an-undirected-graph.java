class Solution {
   class Pair {
        int node;
        int distance;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    private void makeList(int V, int[][] edges, ArrayList<ArrayList<Pair>> adj) {
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        makeList(n, edges, adj);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];//why n+1 means its 1 based indexed graph
        for(int i =1;i<=n;i++){
            parent[i]= i;//initial fill with node itself
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        pq.add(new Pair(0,1));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int d = curr.distance;
            int node = curr.node;

            if (d > dist[node]) continue;

            for (Pair e : adj.get(node)) {
                int newDist = d + e.distance;
                if (newDist < dist[e.node]) {
                    dist[e.node] = newDist;
                    pq.add(new Pair(newDist, e.node));
                    parent[e.node]= node;//set the parent from where it came
                }
            }
        }
        int destNode =n;
        if(dist[destNode]==Integer.MAX_VALUE){
            return Arrays.asList(-1);
        }
        List<Integer> ls = new ArrayList<>();
        while(parent[destNode]!=destNode){
            ls.add(destNode);
            destNode = parent[destNode];
        }
        ls.add(1);
        Collections.reverse(ls);
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(ls);

        return result;
    }
}