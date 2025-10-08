
public class linkedlistPallindrome {
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
        //  add at last; it adds after existing node.
         public void addLast(int data){
             // create new node
            Node newNode= new Node(data);
         
            if(head==null){
                head=tail=newNode;
                return;
            }
            // assign value head (previous node) to a newNode i.e. linking nodes
         tail.next=newNode;
            //   head=newNode;
            tail=newNode;
         }

        //  print linked list: create a method or function 
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
        
    // PALLINDROME: SLOW AND FAST MERTHODA: ehere a head is slow (ie. moves 1 steps ahead), fast(moves 2 steps ahead)till the next is null. 
    // Even : to find mid:- slow = mid when fast reaches null then slow is at the mid node 
    // odd: to find mid :- when fast= fast.next=null then mid = node where slow is present.
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
        //    +1 node
            slow=slow.next;
            // +2 node
            fast=fast.next.next;
        }
        return slow;
    } 
    // the mid is used to find whether the let and right part are equal i.e. left part where left head and right part  where right head will move comapred and then left will move to left and new node will be head similarly to the right and they will be compared , this will keep on going until null is achieved (mid points to null) if all are equal then pallindrome.
    public boolean checkPallindrome(){
        // base case single node
        if(head== null|| head.next==null){
            return true;
        }  
        // find mid 
        Node midNode=findMid(head);
          // reverse 2nd half
          Node prev= null;
          Node curr= midNode;
          Node next;
          while(curr!=null){
             next=curr.next;
            curr.next= prev;
            prev=curr;
            curr=next;
          }
        //   right half head
          Node right= prev;
        //   left half head
          Node left= head;
        // 3 check left and righ thalf for pallindrome
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left= left.next;
            right= right.next;
        }
        return true;
    }


    // LINKED LIST CYCLE
    public static boolean isCycle(){
        Node slow= head;
        Node fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
            // cycle exist if at some point after moving ahead slow and fase point again meets at a node where the distance covered is d between slow and fast.
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    // REMOVE CYCLE
    public static void removeCycle(){
        // detect cycle
        Node slow= head;
        Node fast= head;
        boolean cycle= false;
        while(fast!= null && fast.next!= null){
            slow= slow.next;
            fast= fast.next.next;
            if(fast==slow){
                cycle= true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        // find meeting point
        slow= head;
        Node prev= null;
        while(slow!=fast){
            prev= fast;
            slow=slow.next;
            fast= fast.next;
        }
        // remove cycle i.e. last.next=null
        prev.next=null;
    }
    public static void main(String[] args) {
         linkedlistPallindrome LinkedL= new linkedlistPallindrome();
    //    LinkedL.print();
    //    LinkedL.addFirst(1);
    //    LinkedL.addLast(2);
    //    LinkedL.addLast(2);
    //    LinkedL.addLast(1);
    //   LinkedL.print();
    //   System.out.println(LinkedL.checkPallindrome());

    //   linked list cycle: Floyd cycle finding algo
    // 1->2->3->1 i.e. cycle exist
    // head= new Node(1);
    // head.next= new Node(2);
    // head.next.next= new Node(3);
    // head.next.next.next= head;
    // System.out.println(isCycle());

    // 
    head= new Node(1);
    Node temp= new Node(2);
    head.next= temp;
    head.next.next= new Node(3);
    head.next.next.next= temp;
    removeCycle();
    System.out.println(isCycle());
    }
}
