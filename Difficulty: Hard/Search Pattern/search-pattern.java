class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        int m=txt.length();
        int n=pat.length();
        for(int i=0;i<=m-n;i++){
            if(txt.substring(i,i+n).equals(pat)){
                ans.add(i);
            }
        }
        return ans;
    }
}