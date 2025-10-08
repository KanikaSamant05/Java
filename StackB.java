 // import java.util.ArrayList;
// is using java collection framework
import java.util.*;

public class StackB {

    // implementing stack in the form of arrayList
    // A static class is defined 

    // static class Stack{
    //     static ArrayList<Integer>list= new ArrayList<>();
    //     public static boolean isEmpty(){
    //         return list.size()==0;
    //     }

// push function: adds elements at the top of the stack 
// top-(the topmost eleemnt is known as top in stack).It is the last element added in a stack
    
//   public static void push(int data){
    //     list.add(data);
    //   }

    //   public static int pop(){
    //     if(isEmpty()){
    //         return -1;
    //     }

        // top is shown

        // int top= list.get(list.size()-1);

    //    top is removed list.size()-1 gives the last element added i.e. top in a stack
       
    // list.remove(list.size()-1);

        // new top is returned after the removal of top
       
    //     return top;
    //   }

    //   public static int peek(){
    //       if(isEmpty()){
    //         return -1;
    //     }
    //     return list.get(list.size()-1);
    //   }
    // }
    

    public static void main(String[] args) {
        // using java collection framework requires only 1 step then the operations get accessed whithou writing any other codes as above
        Stack<Integer> s= new Stack<>();

        // Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();

        }

    }
}
