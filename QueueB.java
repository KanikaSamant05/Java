public class QueueB {

// front-exit; rear- entry
// implementation 
// 1. array- fixed thus not relaible, circular queue is made
static class Queue {
    static int arr[];
    static int size;
    static int rear;

    Queue(int n ){
        arr= new int[n];
        size=n;
        rear=-1;
    }
    public static boolean isEmpty(){
        return rear==-1;
    }

    // ADD
    public static void add(int data){
        if(rear==size-1){
            System.out.println("Queue is full");
            return;
        }  
        // initailly rear=-1 if we add data the front will be fixed and rear will increase by 1
        rear= rear+1;
        arr[rear]=data;
      }

    //   REMOVE T.C: O(n)
    public static int remove(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        int front= arr[0];
        for(int i=0;i<rear;i++){
            arr[i]=arr[i+1];
        }
        rear=rear-1;
        return front;
    }

    // PEEK
    public static int peek(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        return arr[0];
    }
    
}
    public static void main(String[] args) {
        Queue q= new Queue(5);
        q.add(3);
        q.add(1);
        q.add(2);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
