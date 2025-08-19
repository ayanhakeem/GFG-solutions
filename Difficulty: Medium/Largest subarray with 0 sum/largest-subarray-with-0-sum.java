class Solution {
    int maxLength(int arr[]) {
        // code here
        int sum=0;
        int max=0;
        int n=arr.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;
            }else{
                if(map.get(sum)!=null){
                    max=Math.max(max,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
        }
        return max;
    }
}