class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        
        int rooms=0;
        int max=0;
        int i=0,j=0;
        while(i<start.length){
            if(start[i]<end[j]){//room used bcoz another meeting is came inside end
            //Another meeting starts while the previous one is still running.
                rooms++;
                max=Math.max(max,rooms);
                i++;
            }else{
                rooms--;//resued room means the meeting has ended before st
                //A meeting has already ended before the next meeting starts.
                j++;
            }
        }
        return max;
        
    }
}
