import java.util.*;

class DisjointSet {
    private int[] rank, parent, size;

    public DisjointSet(int n) {
        rank   = new int[n + 1];
        parent = new int[n + 1];
        size   = new int[n + 1];
        Arrays.fill(size, 1);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]); // path compression
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v])       parent[ulp_u] = ulp_v;
        else if (rank[ulp_v] < rank[ulp_u])   parent[ulp_v] = ulp_u;
        else { parent[ulp_v] = ulp_u; rank[ulp_u]++; }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {

    private boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    // ✅ Return type matches what the problem expects
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds  = new DisjointSet(rows * cols);  // ✅ rows/cols, not n/m
        int[][] vis     = new int[rows][cols];
        int cnt         = 0;
        List<Integer> ans = new ArrayList<>();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = { 0, 1, 0, -1};

        for (int[] it : operators) {
            int row = it[0], col = it[1];

            if (vis[row][col] == 1) {       // already added, island count unchanged
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];

                if (isValid(adjr, adjc, rows, cols) && vis[adjr][adjc] == 1) {
                    int nodeNo    = row  * cols + col;   // ✅ cols not m
                    int adjNodeNo = adjr * cols + adjc;
                    if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}