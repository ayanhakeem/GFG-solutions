class maxHeap {
    ArrayList<Integer>list=null;

    // Constructor
    public maxHeap() {
        // Initialize your data members
        list=new ArrayList<>();
    }

    public void push(int x) {
        // Insert x into the heap
        list.add(x);
        Collections.sort(list,Collections.reverseOrder());
    }

    public void pop() {
        // Remove the top (maximum) element
        list.remove(0);
    }

    public int peek() {
        // Return the top element or -1 if empty
        if(list.size()==0) return -1;
        return list.get(0);
    }

    public int size() {
        // Return the number of elements in the heap
        return list.size();
    }
}