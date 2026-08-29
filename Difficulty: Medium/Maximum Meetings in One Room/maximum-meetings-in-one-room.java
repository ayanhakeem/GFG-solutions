class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        List<int[]>meetings=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            meetings.add(new int[]{f[i],s[i],i+1});
        }
        
        meetings.sort(Comparator.comparingInt(a->a[0]));
        ArrayList<Integer>ans=new ArrayList<>();
        int lastend=-1;
        for(int m[]:meetings){
            if(m[1]>lastend){
                ans.add(m[2]);
                lastend=m[0];
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
//tc=o(nlo)