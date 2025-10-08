import java.util.*;

public class QueueQs {
    // static class Queue{
    //     static Stack<Integer>s1= new Stack<>();
    //     static Stack<Integer> s2= new Stack<>();
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }
    //     // add O(n)
    //     public static void add(int data){
    //        while(!isEmpty()){
    //           s2.push(s1.pop());
    //        }
    //        s1.push(data);
    //        while(!s2.isEmpty()){
    //         s1.push(s2.pop());
    //        }

    //     }
    //     // remove
    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("Empty Queue");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
    //     // peek
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("Empty Queue");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }
// }


 // stack using 2 queues
        static class Stack{
            static Queue<Integer> q1= new LinkedList<>();
            static Queue<Integer> q2= new LinkedList<>();
            public static boolean isEmpty(){
                return q1.isEmpty() && q2.isEmpty();
            }
            // add func
            public static void push(int data){
                if(!q1.isEmpty()){
                    q1.add(data);
                }else{
                    q2.add(data);
                }
            }
            public static int pop(){ 
                   if(isEmpty()){
                    System.out.println("Empty stack");
                    return -1;
                }
                    int top=-1;
                    // case1 
                    if(!q1.isEmpty()){
                        while(!q1.isEmpty()){
                            top=q1.remove();
                            if(q1.isEmpty()){
                                break;
                            }
                            q2.add(top);
                        }
                    }else{
                        // case2
                            while(!q2.isEmpty ()){
                                top=q2.remove();
                                if(q2.isEmpty()){
                                    break;
                                }
                                q1.add(top);
                            }
                        }
                    
                    return top;
                }
         
         public static int peek(){
            if(isEmpty()){
                    System.out.println("Empty stack");
                    return -1;
                }
                    int top=-1;
                    // case1 
                    if(!q1.isEmpty()){
                        while(!q1.isEmpty()){
                            top=q1.remove();
                            q2.add(top);
                        }
                    }else{
                        // case2
                            while(!q2.isEmpty ()){
                                top=q2.remove();
                                q1.add(top);
                            }
                        }
                    
                    return top;
         }
        }
        
        
    public static void main(String[] args) {
        // Queue<Integer> q= new LinkedList<>();
        //  q.add(3);
        // q.add(1);
        // q.add(2);
        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

  // stack operation in queue
    //     Queue q= new Queue();
    //     q.add(1);
    //      q.add(2);
    //       q.add(3);
    //        q.add(4);
    // while (!q.isEmpty()) {
    //         System.out.println(q.peek());
    //         q.remove();
    //     } 

 // stack using 2 queues
         Stack s =new Stack();
         s.push(1);
         s.push(2);
         s.push(3);
         while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        }
}
       
   