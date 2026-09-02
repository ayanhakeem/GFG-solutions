class myQueue {

    // Initialize your data members
    Stack<Integer>s1;
    Stack<Integer>s2;

    myQueue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    void enqueue(int x) {
        // Implement enqueue operation
        while(!s1.isEmpty()){
            s2.push(s1.pop());   
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());   
        }
    }
        

    void dequeue() {
        // Implement dequeue operation
        if(s1.isEmpty()) return;
        
        s1.pop();
    }

    int front() {
        // Implement front operation
        if(s1.isEmpty()) return -1;
        return s1.peek();
    }

    int size() {
        // Implement size operation
        return s1.size();
    }
}
