class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if( !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/") ){
                stack.push(Integer.parseInt(token));
            }else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch(token){
                    case "+":
                        stack.push(val2+val1);
                        break;
                    case "-":
                        stack.push(val2-val1);
                        break;
                    case "*":
                        stack.push(val2*val1);
                        break;
                    case "/":
                        stack.push(val2/val1);
                        break;
                    

                }
                
            }
        }

        return stack.peek();
        
    }
}