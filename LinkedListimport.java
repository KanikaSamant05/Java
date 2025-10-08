import java.util.LinkedList;

// import linkedListScratch.Node;
// with  import we don't have write the code for performng functions(add, print, etc) in a linked list.
public class LinkedListimport {
       public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
        public static Node tail;

        public void addFirst(int data){
             // create new node
            Node newNode= new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            // assign value head (previous node) to a newNode i.e. linking nodes
            newNode.next=head;
            //   head=newNode;
            head=newNode;
         }


         public void addLast(int data){
             // create new node
            Node newNode= new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            // assign value head (previous node) to a newNode i.e. linking nodes
            tail.next= newNode;
            //   head=newNode;
            tail=newNode;
         }

          public void print(){
            if(head==null){
                System.out.println("linked list is empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
            System.out.print(temp.data+"->" );
            temp=temp.next;
            }
            System.out.println("null");
        }

    // MERGE SORT
    private Node getMid(Node head){
        Node slow= head;
        Node fast= head.next;
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    private Node merge(Node head1, Node head2){
        Node mergedLL= new Node(-1);
        Node temp= mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next= head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
     }
      while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
     }
     return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        // find mid 
        Node mid=getMid(head);
        Node rightHead= mid.next;
        mid.next=null;
        Node newLeft= mergeSort(head);
        Node newRight= mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
}
// ZIG-ZAG
         public void zigZag(){
            // find mid
            Node slow= head;
            Node fast=head.next;
            while(fast!= null && fast.next!=null){
                slow= slow.next;
                fast= fast.next.next;
            }
            // mid is the node which is pointing to slow node
            Node mid= slow;
            // reverse 2nd half
            Node curr= mid.next;
            mid.next= null;
            Node prev=null;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            // left side moves forward and right side moves backwards 
            Node left= head;
            Node right= prev;
            Node nextL,nextR;
            // alternate merge
            while(left!=null && right!=null){
                nextL=left.next;
                // alternate merge right and left
                left.next=right;
                nextR=right.next;
                // alternate merge right and left
                right.next= nextL;

                left=nextL;
                right=nextR;
            }
         }

// 
    public static void main(String[] args) {
        // create LL use classes(Integer, Float, Boolean) not datatype(int , float)
        // LinkedList<Integer> LL= new LinkedList<>();
        // LL.addLast(3);
        // LL.addLast(4);
        // LL.addFirst(5);
        // LL.addFirst(1);
        // to print 
        // System.out.println(LL);
        // LL.removeLast();
        // LL.removeFirst();
        // System.out.println(LL);

        // merge sort 
        LinkedListimport ll= new LinkedListimport();
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // ll.addFirst(6);
        // ll.addFirst(7);
        // ll.print();
        // ll.head =ll.mergeSort(ll.head);
         ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
         ll.print();
        ll.zigZag();
        ll.print();
    }
}
