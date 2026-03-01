class Solution {
    public static int kthLargest(int[] arr, int k) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                pq.offer(sum);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
