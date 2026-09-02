class myStack {
    private int[] arr;
    private int top;
    private int n;

    public myStack(int n) {
        arr = new int[n];
        this.n = n;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == n - 1;
    }

    public void push(int x) {
        if (isFull()) return;

        top = top + 1;
        arr[top] = x;
    }

    public int pop() {
        if (isEmpty()) return -1;

        int x = arr[top];
        top--;
        return x;
    }

    public int peek() {
        if (isEmpty()) return -1;

        return arr[top];
    }
}