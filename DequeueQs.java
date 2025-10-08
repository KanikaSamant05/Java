import java.util.*;
// Dequeue means from both end i.e. double queue, we can perform funcn from both end unline queue eg. add from from, add from rear, remove from front and remove from rear
public class DequeueQs {

    // Stacks using dequeue
    static class Stack{
        Deque<Integer> deque= new LinkedList<>();
        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
           return deque.removeLast();
        }
        public int peek(){
           return deque.getLast();
        }

    }

    // queue using dequeue
    static class Queue{
        Deque<Integer> deque= new LinkedList<>();
        public void add(int data){
            deque.addLast(data);
        }
        public int remove(){
           return deque.removeFirst();
        }
        public int peek(){
           return deque.getFirst();
        }

    }

    public static void main(String[] args) {
        Deque<Integer> deque= new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(10);
        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        //5,3,1,10,7 
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque+ " ");
        System.out.println("First element: " +deque.getFirst());
         System.out.println("Last element: "+deque.getLast());

        //  Stack using queue
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek= "+ s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        Queue q= new Queue();         
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek with queue= "+ q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
