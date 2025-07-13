// User function Template for Java

class Solution {
    public int KthDistinct(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0) +1);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(map.get(nums[i])==1){
                c++;
            }
            if(c==k){
                return nums[i];
            }
            
        }
        return -1;
        
    }
}