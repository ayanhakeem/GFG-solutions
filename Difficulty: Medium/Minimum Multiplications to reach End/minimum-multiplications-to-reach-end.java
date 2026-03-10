// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if (start == end) return 0;
                // Queue to store pairs of (number, steps)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});

        // Distance array to store minimum multiplications needed to reach a number
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        int mod = 100000;

        // BFS traversal
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int steps = current[1];

            // Try multiplying node with each element in arr
            for (int factor : arr) {
                int num = (factor * node) % mod;

                // If this path gives a lesser number of multiplications, update and enqueue
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;

                    // If we reached the target, return the steps
                    if (num == end) return steps + 1;

                    q.offer(new int[]{num, steps + 1});
                }
            }
        }
        // Return -1 if the end number is unreachable
        return -1;
    }

  
}
