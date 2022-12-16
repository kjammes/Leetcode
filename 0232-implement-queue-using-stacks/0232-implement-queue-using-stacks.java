class MyQueue {
    
    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    public MyQueue() {
        stackOne = new Stack<Integer>();
        stackTwo = new Stack<Integer>();
    }
    
    public void push(int x) {
        while(!stackOne.empty()) {
            stackTwo.push(stackOne.pop());
        }
        stackOne.push(x);
        while(!stackTwo.empty()) {
            stackOne.push(stackTwo.pop());
        }
    }
    
    public int pop() {
        return stackOne.pop();
    }
    
    public int peek() {
        return stackOne.peek();
    }
    
    public boolean empty() {
        return stackOne.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */