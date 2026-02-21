
class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);//o(n log n)
        }
        int mincost=0;
        while(pq.size()>1){
            int min1=pq.remove();
            int min2=pq.remove();
            mincost+=min1+min2;
            pq.add(min1+min2);
        }
        return mincost;
    }
}