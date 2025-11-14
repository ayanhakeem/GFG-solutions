class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        int a[]=new int[n];
        ArrayList<Integer>nse=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
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
            nse.add(x);
        }
        return nse;
    }
}