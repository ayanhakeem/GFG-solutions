class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n=arr.length;
        Map<Integer,Integer>map=new HashMap<>();
        int xr=0;
        int cnt=0;
        map.put(xr,1);
        for(int i=0;i<n;i++){
            xr=xr^arr[i];
            int x=xr^k;
            if(map.containsKey(x)){
                cnt+=map.get(x);
            }
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return cnt;
        
    }
}