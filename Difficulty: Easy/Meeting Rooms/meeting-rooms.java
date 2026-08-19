class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        int n=arr.length;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int end=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]<end){
                return false;
            }else{
                end=Math.max(end,arr[i][1]);
            }
        }
        return true;
    }
}