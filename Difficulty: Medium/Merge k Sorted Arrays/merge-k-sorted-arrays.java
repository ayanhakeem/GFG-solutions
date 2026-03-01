class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n = mat.length;

        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
        for(int i=0;i<n;i++) {
            minHeap.offer(new HeapNode(0, mat[i][0], mat[i]));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            HeapNode node = minHeap.poll();
            list.add(node.val);
            int idx = node.idx;
            int[] arr = node.arr;

            idx++;
            if(idx < arr.length) {
                minHeap.offer(new HeapNode(idx, arr[idx], arr));
            }
        }

        return list;
    }
    
    static class HeapNode {
        int idx;
        int val;
        int[] arr;

        public HeapNode(int idx, int val, int[] arr) {
            this.idx = idx;
            this.val = val;
            this.arr = arr;
        }
    }
}