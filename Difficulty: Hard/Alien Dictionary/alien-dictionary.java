import java.util.*;

class Solution {

    public String findOrder(String[] words) {

        int K = 26;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < K; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[K];
        boolean[] exists = new boolean[K];

        // mark existing characters
        for(String word : words){
            for(char c : word.toCharArray()){
                exists[c - 'a'] = true;
            }
        }

        // build graph
        for(int i = 0; i < words.length - 1; i++){

            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());

            int j = 0;

            while(j < len && s1.charAt(j) == s2.charAt(j))
                j++;

            if(j < len){

                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';

                adj.get(u).add(v);
                indegree[v]++;

            } 
            else if(s1.length() > s2.length()){
                return "";
            }
        }

        // topo sort (Kahn's algorithm)
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < K; i++){
            if(exists[i] && indegree[i] == 0)
                q.add(i);
        }

        StringBuilder ans = new StringBuilder();

        while(!q.isEmpty()){

            int node = q.poll();
            ans.append((char)(node + 'a'));

            for(int neigh : adj.get(node)){
                indegree[neigh]--;

                if(indegree[neigh] == 0)
                    q.add(neigh);
            }
        }

        // cycle detection
        int count = 0;
        for(boolean b : exists)
            if(b) count++;

        if(ans.length() < count)
            return "";

        return ans.toString();
    }
}