//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        return Integer.compare(m1.end, m2.end); // Sort by end time
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        List<Meeting> meetings = new ArrayList<>();

        // Store meetings with their start and end times
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Sort meetings by end time
        Collections.sort(meetings, new MeetingComparator());

        int count = 1; // First meeting is always selected
        int lastEndTime = meetings.get(0).end;

        // Iterate through meetings and select non-overlapping ones
        for (int i = 1; i < start.length; i++) {
            if (meetings.get(i).start > lastEndTime) { // Strictly greater condition
                count++;
                lastEndTime = meetings.get(i).end;
            }
        }
        
        return count;
    }
        // add your code here
}