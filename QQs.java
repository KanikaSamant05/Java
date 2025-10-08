import java.security.PublicKey;
import java.util.*;
public class QQs {
    public static void printNonRepeating(String str){
    //    a to z
        int freq[]= new int[26];
        Queue<Character>q= new LinkedList<>();
        for(int i=0; i<str.length();i++){
            char ch= str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }System.out.println();
    }

    //Interleave 2 halves of queue eg.i queue- 1,2,3,4,5; 2Queue 6,7,8,9,10 the output is: 1 6 2 7 3 8 4 9 5 10 
public static void interLeave(Queue<Integer> q){
    Queue<Integer>firstHalf= new LinkedList<>();
    int size=q.size();
    for(int i=0;i<size/2;i++){
        firstHalf.add(q.remove());
    }
       while(!firstHalf.isEmpty()){
        q.add(firstHalf.remove());
        q.add(q.remove());
       }
}

// REVERSE OF NO. :reverse a queue 12345 output 54321 , for this create a stack and remove the queue(queue removes from front FIFO always) and put it in stack then pop the stack and add in queue.

     public static void reverse(Queue<Integer> q1){
        Stack<Integer>s = new Stack<>();
        while(!q1.isEmpty()){
            s.push(q1.remove());
        }

        while(!s.isEmpty()){
            q1.add(s.pop());
        }
     }
    public static void main(String[] args) {
        // String str="aabccxb";
        // printNonRepeating(str);

    
    //Interleave 2 halves of queue     
    // Queue<Integer>q= new LinkedList<>();
    // q.add(1);
    // q.add(2);
    // q.add(3);
    // q.add(4);
    // q.add(5);
    // q.add(6);
    // q.add(7);
    // q.add(8);
    // q.add(9);
    // q.add(10);
    // interLeave(q);
    // while(!q.isEmpty()){
    //     // System.out.print(q.remove()+" ");
    // }

    // REVERSE OF NO.
    Queue<Integer>q1= new LinkedList<>();
    q1.add(1);
    q1.add(2);
    q1.add(3);
    q1.add(4);
    q1.add(5);
    reverse(q1);
    // print
    while(!q1.isEmpty()){
        System.out.print(q1.remove()+" ");
    }
   }
}
