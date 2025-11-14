class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        ArrayList<Integer>ans=new ArrayList<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                a[i]=-1;
            }else{
                a[i]=st.peek();
            }
            st.push(arr[i]);
        }
        for(int x:a){
            ans.add(x);
        }
        return ans;
        
    }
}