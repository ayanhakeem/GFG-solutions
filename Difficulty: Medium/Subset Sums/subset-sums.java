// User function Template for Java//User function Template for Java
class Solution {
    public void func(int idx,int sum,int arr[],int n,ArrayList<Integer>ans){
        if(idx==n){
            ans.add(sum);
            return;
        }
        func(idx+1,sum+arr[idx],arr,n,ans);
        
        func(idx+1,sum,arr,n,ans);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer>ans=new ArrayList<>();
        func(0,0,arr,arr.length,ans);
        return ans;
        // code here
        
    }
}