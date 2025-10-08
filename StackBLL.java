import java.util.ArrayList;
public class StackBLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Stack{
        // make static so that the node is accessible to every function
        static Node head=null;
        public static boolean isEmpty(){
            return head==null;
        }
        // pudh operartion : in LL top= head thus, to add new node ata top newNode.next=head and head=newNode
        // in LL direct operations are not possible, methods or func are created
        public static void push(int data){
            Node newNode= new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }

        // pop operation(remove):int because it will return the value
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        // peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
        }

    
    public static void main(String[] args) {
        Stack s = new Stack();
        // 1 is added at first
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        // 5 is added at last top is 5
        s.push(5);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
