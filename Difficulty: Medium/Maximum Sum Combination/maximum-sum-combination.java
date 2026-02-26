class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        
        HashSet<String>visited=new HashSet<>();
        PriorityQueue<int[]>maxheap=new PriorityQueue<>((x,y)->y[0]-x[0]);//based on sum maxheap  sort 
        int n=a.length;
        maxheap.offer(new int[]{a[n-1]+b[n-1],n-1,n-1});
        visited.add((n-1)+","+(n-1));
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(k-->0 && !maxheap.isEmpty()){
            int curr[]=maxheap.poll();
            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];

            res.add(sum);
            
        
        
            if (i - 1 >= 0) {
                String key1 = (i - 1) + "," + j;
                if (!visited.contains(key1)) {
                    maxheap.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                    visited.add(key1);
                }
            }
        
        

            // Check for new combination (i, j - 1)
            if (j - 1 >= 0) {
                String key2 = i + "," + (j - 1);
                if (!visited.contains(key2)) {
                    maxheap.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                    visited.add(key2);
                }
            }
        }
        
        return res;
        
        
        
        
    }
}