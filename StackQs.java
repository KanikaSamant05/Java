import java.util.*;
public class StackQs {
    public static void pushAtBottom(Stack<Integer>s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // reverse a string using stack eg. 'abc' output'cba'
    public static String reverseString(String str){
        Stack<Character> ch= new Stack<>();
        int i=0;
        while(i<str.length()){
            ch.push(str.charAt(i));
            i++;
        }
        StringBuilder result= new StringBuilder("");
        while(!ch.isEmpty()){
            char curr=ch.pop();
            result.append(curr);
        }
        return result.toString();
    }

    // reverse stack
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top= s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    // Stock span problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> st= new Stack<>();
        span[0]=1;
        st.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice= stocks[i];
            while(!st.isEmpty()&& currPrice>stocks[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=st.peek();
                span[i]=i-prevHigh;
            }

         st.push(i);
        }

    }

    // VALID PARENTHESIS CODE
    public static boolean isValid(String str){
        Stack<Character>s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            // opening
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }else{
                // closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && ch==')')
                ||(s.peek()=='{' && ch=='}')
                ||(s.peek()=='[' && ch==']') ){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }

    }


    //     // IF DUPLICATE TRUE
            public static boolean isDuplicate(String str){
                Stack<Character>s=new Stack<>();
                for(int i=0; i<str.length();i++){
                    char ch= str.charAt(i);
                    // opening operator operands

                    // closing case
                    if(ch==')'){
                        int count=0;
                        while(s.peek()!='('){
                            s.pop();
                            count++;
                        }
                        if(count<1){
                            return true;
                        }else{
                            s.pop();
                        }
                    }else{
                        s.push(ch);
                    }
                }
                return false;
            }
    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        // reverse string with the help of stack
            // String str="hello";
            // String result= reverseString(str);
            // System.out.println(result);
        
            // reverse the stack
            s.push(1);
            s.push(2);
            s.push(3);
            // initially 3 2 1 
            // printStack(s);
            // reverseStack(s);
            // after reverse 1 2 3 1 will be at the top followed by 2 then 3
            // printStack(s);

// STOCK SPAN PROBLEM
        // int stocks[]={100,80,60,70,60,85,100};
        // int span[]=new int [stocks.length];
        // stockSpan(stocks,span);
        // for(int i=0;i<span.length;i++){
        //     System.out.print(span[i]+" ");
        // }

            // FIND NEXT GREATEST
            int arr[]={6,8,0,1,3};
            Stack<Integer> Ng= new Stack<>();
            int nextGreater[]=new int[arr.length];
            
            for(int idx= arr.length-1;idx>=0;idx--){
                // 1step= 
                while(!Ng.isEmpty() && arr[Ng.peek()]<=arr[idx]){
                    Ng.pop();
                }
                // 2step
                if(Ng.isEmpty()){
                    nextGreater[idx]=-1;
                }else{
                    nextGreater[idx]=arr[Ng.peek()];
                }
                // 3step push in stack
                Ng.push(idx);
            }

            // for(int idx=0;idx<nextGreater.length;idx++){
            //     System.out.print(nextGreater[idx]+" ");
            // }
            // System.out.println();


            // VALID PARENTHESIS CODE
            // String str="({})[]"; 
            // System.out.println(isValid(str));

            // find duplicate parenthesis
            // true
            String str="((a+b))";
            // false
            String str2="(a-b)";
            System.out.println(isDuplicate(str2));
            System.out.println(isDuplicate(str2));
        
        }
    }

