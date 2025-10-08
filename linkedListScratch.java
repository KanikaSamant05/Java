// Lined list is a linear structure which is similar to arrays and arraylist but in linked list the data are connected to each other known as node. Nodes contains 2 parts first is value(int, bollean, string etc) and second is next which is the reference to the next node i.e. address of next node and at last node null is the value stored which indentifies that the linked list is now ended. We define the nodes inside a class because those nodes will contain same type of data 
public class linkedListScratch {
    // linked list class contains only 1 head and tail
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
        // directly we can't perform function in linked list thus methods are used to add, print, remove and other functions in a linked list
        public static Node head;
        public static Node tail;
        public static int size;

        // add node to a linked list 1. ADD at first; it adds before existing node 2. ADD at last
        // we can't directly opearte changes in head and tail thus temp is used, head and tail values should be fixed i.e. start node- head; end node tail pointing null. AddFirstand addLast methods changes the head and tail to the resp. pos. when adding data ato Linked list. 
        public void addFirst(int data){
             // create new node
            Node newNode= new Node(data);
            size++;
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
            size++;
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

        // add in the middle
        public void add(int idx, int data){
            // if new node is added to index=0 then,
            if(idx==0){
                // addFirst eill be called becoz at 0 index the head will be changed to the new node
                addFirst(data);
                return;
            }
            Node newNode=new Node(data);
            size++;
            Node temp=head;
            int i=0;
            while(i<idx-1){
                temp=temp.next;
                i++;
            }
                // i=idx-1; tempis the previous node
                // new node will store address of the next node
                newNode.next=temp.next;
                // here temp is previous node thus temp.next will store address of new node added to the index
                temp.next=newNode; 
        }

//REMOVE OPERATION
    public int removeFirst(){
        // no linked list present
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        // if only 1 node si present in LL then value will be the data in that node and to remove assign head and tail to null coz new head and tail will be present in that node only.
        else if(size==1){
            int val= head.data;
            head= tail=null;
            size=0;
            return val;
        }
        int val= head.data;
        head= head.next;
        size--;
        return val;

    }   
    
    // remove from last ie. tail
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        // if only 1 node si present in LL then value will be the data in that node and to remove assign head and tail to null coz new head and tail will be present in that node only.
        else if(size==1){
            int val= head.data;
            head= tail=null;
            size=0;
            return val;
        }
        // previous node idx=size-2 eg. if size ofLL is 4 i.e. we will ave to remove node of index 3 so previous node which is 2 now will be a tail i.e. prev.N= 4-2
    //    here previous node acts as head, ye wo nodes h jb tk tail value previous node ko assign nhi hoti i.e jb tk prev node equal to 2 nhi hota tb tk wo nodes head ki trh rhenge
        Node prev=head;    
        for(int i=0;i<size-2;i++){
                prev=prev.next;
            }
            // here when size ==2 i.e. previous node which will act as a tail, the code is: 
            // data of tail 
            int val=prev.next.data;
            // assigning previous node as tail by providing the address of next node as null
            prev.next=null;
            // here value of tail is given to prev
            tail=prev;
            size--;
            return val;
    }
        
    // 

public int itrSearch(int key){
    Node temp=head;
    int i=0;
    while(temp!=null){
        if(temp.data==key){
            return i;
        }
        temp=temp.next;
        i++;
    }
    // key not found
    return -1;
}


// RECURSIVE SEARCH for a key. Here every node will behave as head one by one and checks if its data = key , if not then return -1 and if yes then at whatever index it is (i=0 for head always) so the previous head will add 1 to the head where the actual key is and returns by correct index.
    // helper function is created 
public int helper(Node head, int key){
    //base case
         if(head==null){
            return -1;
         }
        //  if data==key found
         if(head.data==key){
            return 0;
         }
        //  finding index,if key not found 
         int idx= helper(head.next,key);
         if(idx==-1){
            return -1;
         } 
        //  if key found
         return idx+1;
     }   
     public int recuSearch(int key){
        return helper(head, key);
    }

    // REVERSE OD LINKED LIST
    public void reverse(){
        // before head there is no node 
        Node prev=null;
        // here assigned value is right to left i.e. head is assigned to tail and tail to curr
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev= curr;
            curr=next;
        }
        head= prev;
    }

    // REMOVE nth NODEfrom end so size of nth node= size-n+1 from start
    // to remove we will set address of prev index directing to the next node instead of previous node.
    public void deleteNthfromEnd(int n){
// calculate size
     int sz=0;
     Node temp=head;
     while(temp!=null){
        temp=temp.next;
        size++;
     }
     if(n==sz){
        // remove head 
        head= head.next;
        return;
     }
    //  to reach prev index i.e. size-n
     int i=1;
     int indexTofind=sz-n;
     Node prev=head;
     while(i<indexTofind){
        prev=prev.next;
        i++;
     }
    //  assigning address of previous targeting the next node of current node (curr node which needs to be removed)
     prev.next=prev.next.next;
     return;
    }

    public static void main(String[] args) {
       linkedListScratch ll= new linkedListScratch();
       ll.print();
       ll.addFirst(2);
    //    ll.print();
       ll.addFirst(1);
    //    ll.print();
       ll.addLast(3);
    //    ll.print();
       ll.addLast(4);
       ll.addLast(20);
       ll.add(2,9);
       ll.add(3,40);

       ll.print();
       System.out.println("size of linked list is: "+ll.size);
       ll.reverse();
       ll.print();
       ll.deleteNthfromEnd(2);
       ll.print();
       ll.removeFirst();
       ll.print();
       System.out.println("size of new linked list is: "+ll.size);
       System.out.println("Iterartive search: "+ll.itrSearch(9));
       System.out.println("Iterartive search: "+ll.itrSearch(50));
        //    recursive search
       System.out.println("Recursive search: "+ll.recuSearch(3));
       System.out.println("Recursive search: "+ll.recuSearch(50));
       
       ll.removeLast();
       ll.print();
       ll.removeFirst();
       ll.print();
       System.out.println("size of new linked list after removeLAst op. is: "+ll.size);
      
    }
}

