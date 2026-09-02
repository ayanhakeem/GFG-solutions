class myQueue {
    int n;
    int arr[];
    int front;
    int rear;
    int currsize;

    // Constructor
    public myQueue(int n) {
        this.n = n;
        arr = new int[n];

        front = 0;
        rear = -1;
        currsize = 0;
    }

    public boolean isEmpty() {
        return currsize == 0;
    }

    public boolean isFull() {
        return currsize == n;
    }

    public void enqueue(int x) {
        if (isFull()) return;

        rear = (rear + 1) % n;
        arr[rear] = x;
        currsize++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;

        int x = arr[front];

        front = (front + 1) % n;
        currsize--;

        return x;
    }

    public int getFront() {
        if (isEmpty()) return -1;

        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;

        return arr[rear];
    }
}