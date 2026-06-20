class MinStack {
    int top;
    int[] arr;
    int[] minarr;

    public MinStack() {
        arr = new int[30000];
        minarr = new int[30000];
        top = -1;
    }
    
    public void push(int value) {
        top++;
        arr[top] = value;

        if(top>0){
            minarr[top] = Math.min(value,minarr[top-1]);
        }else{
            minarr[top] = value;
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return arr[top];
    }
    
    public int getMin() {
        return minarr[top];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */