class Solution {
    public int sumoflength(int arr[]) {

        int n = arr.length;
        long mod = 1000000007;
        long total = 0;

        Set<Integer> set = new HashSet<>();
        int left = 0;

        for(int right = 0; right < n; right++) {

            while(set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }

            set.add(arr[right]);

            long L = right - left + 1;

            total = (total + (L * (L + 1) / 2) % mod) % mod;
        }

        return (int) total;
    }
}