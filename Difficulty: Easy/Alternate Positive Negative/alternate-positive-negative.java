// User function Template for Java
import java.util.*;

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.size();

        // Separate positives and negatives
        for (int i = 0; i < n; i++) {
            if (arr.get(i) < 0) {
                neg.add(arr.get(i));
            } else {
                pos.add(arr.get(i));
            }
        }

        int[] ans = new int[n];

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                ans[i * 2] = pos.get(i);
                ans[i * 2 + 1] = neg.get(i);
            }
            int idx = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                ans[idx++] = pos.get(i);
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                ans[i * 2] = pos.get(i);
                ans[i * 2 + 1] = neg.get(i);
            }
            int idx = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                ans[idx++] = neg.get(i);
            }
        }

        // Clear original arr and fill with rearranged values
        arr.clear();
        for (int num : ans) {
            arr.add(num);
        }
    }
}
