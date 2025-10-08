import java.util.ArrayList;
import java.util.*;

public class heapsQs {
    static class Heap {
    ArrayList<Integer> arr= new ArrayList<>();
        public void add(int data){
            arr.add(data);
            // child index
            int x= arr.size()-1; 
            // parent index
            int par= (x-1)/2;
            while(arr.get(x)<arr.get(par)){
                int temp= arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par=(x-1)/2;
            }
         }
         public int peek(){
            return arr.get(0);
         }
         private void heapify(int i){
            int left= 2*i+1;
            int right= 2*i+2;
            int minIdx=i;
            if(left<arr.size() &&  arr.get(minIdx)>arr.get(left)){
                minIdx=left;
            }
        if(right<arr.size() &&  arr.get(minIdx)>arr.get(right)){
            minIdx=right;
        }
        if(minIdx!=i){
            // swap
            int temp= arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);
            heapify(minIdx);
        }
         }
         public int remove(){
            int data= arr.get(0);
            // 1st step: swap 1st and lat
            int temp= arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);
            // 2nd: delete last
            arr.remove(arr.size()-1);
            // heapify: directly can't be used a private function that is later implemented
            heapify(0);
            return data;
         }
         public boolean isEmpty(){
            return arr.size()==0;
         }
     }

    //  heap sort: for ascending: max heap ; for descending order min heapis considered

    // heapify 
    public static void heapify2(int arr[],int i, int size){
            int left= 2*i+1;
            int right= 2*i+2;
            int maxIdx=i;
            if(left<size &&  arr[left]>arr[maxIdx]){
                maxIdx=left;
            }
        if(right<size &&  arr[right]>arr[maxIdx]){
            maxIdx=right;
        }
        if(maxIdx!=i){
            // swap
            int temp= arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify2(arr, maxIdx, size);
        }
     }
    public static void heapSort(int arr[]){
        // buils maxHeap
        int n= arr.length;
        for(int i=n/2;i>=0;i--){
            heapify2(arr, i,n);
            
        }
        // push largest at end
        for(int i=n-1;i>0;i--){
            // swap first with last
            int temp= arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify2(arr,0,i);
        }
    }

    // NEAREST K CARS
    static class Point implements Comparable<Point>{
        int x; 
        int y;
        int distSq;
        int idx;
        public Point(int x, int y, int distSq, int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distSq-p2.distSq;
        }
    }

    // soldier and civilian
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
    public Row(int soldiers, int idx){
        this.soldiers=soldiers;
        this.idx=idx;
    }
    @Override
    public int compareTo(Row r2){
        if(this.soldiers==r2.soldiers){
            return this.idx-r2.idx;
        }else{
            return this.soldiers-r2.soldiers;
        }
    }
    }

    //sliding window program i.e. find the largest among 1st 3 then among next three and so on till last index start from 0 index then 1 ans so on 
    static class pair implements Comparable<pair>{
        int val;
        int idx;
        public pair(int val, int idx){
            this.val=val;
            this.idx=idx;
        }    
        @Override 
        public int compareTo(pair p2){
            // ascending: return this.val-p2.val
            // descending
            return p2.val-this.val;
        }
    }
               
    public static void main(String[] args) {
        // / Insert heap   
        // Heap h= new Heap();
            // h.add(3);
            // h.add(4);
            // h.add(1);
            // h.add(5);
            // while (!h.isEmpty()) {
            //     System.out.println(h.peek());
            //     h.remove();
            // }

        // heap sort
    // int arr[]={1,3,2,4,5};
    // heapSort(arr);
    // for(int i=0; i<arr.length;i++){
    //     System.out.print(arr[i]+ " ");
    // }        

    // NEAREST K CARS
    // int pts[][]={{3,3},{5,-1},{-2,4}};
    // int k=2;
    // PriorityQueue<Point> pq= new PriorityQueue<>();
    // for(int i=0; i<pts.length;i++){
    //     int distSq=pts[i][0]*pts[i][0] +pts[i][1]*pts[i][1];
    //     pq.add(new Point(pts[i][0], pts[i][1], distSq,i));
    // }
    // // nearest k cars
    // for(int i=0; i<k;i++){
    //     System.out.println("C"+pq.remove().idx);
    // }

    // find min cost when combined ropes where cost = size of rpes while connecting
    // int ropes[]={2,3,3,4,6};
    // PriorityQueue<Integer> pq2= new PriorityQueue<>();
    // for(int i=0;i<ropes.length;i++){
    //     pq2.add(ropes[i]);
    // }
    // int cost=0; 
    // while(pq2.size()>1){
    //     int min= pq2.remove();
    //     int min2= pq2.remove();
    //     cost+=min+min2;
    //     pq2.add(min+min2);
    // }
    // System.out.println("cost of connecting ropes= "+ cost);

    // find weak (1 is for soldier , 0 is for civilians)condn if soldier are max in no. i.e. strong and if not then its weak and if equal soldiers, then lower indexed row will be weak
    // int army[][]={{1,0,0,0},
    //             {1,1,1,1,},
    //             {1,0,0,0},
    //             {1,0,0,0}};
    // int k1=2;
    // PriorityQueue<Row>pq3= new PriorityQueue<>();
    // for(int i=0;i<army.length;i++){
    //     int count=0;
    //     for(int j=0;j<army[0].length;j++){
    //         count+=army[i][j]==1?1:0;
    //     }
    //     pq3.add(new Row(count,i));
    // }
    // for(int i=0;i<k1;i++){
    //     System.out.println("R"+pq3.remove().idx);
    // }

    // windows qs
    int arr2[]={1,3,-1,-3,5,3,6,7};
    // window size
    int k2=3;
    // result size
    int res[]=new int [arr2.length-k2+1];
    PriorityQueue<pair> pq4= new PriorityQueue<>();
    for(int i=0;i<k2;i++){
        pq4.add(new pair(arr2[i], i));
    }
    res[0]=pq4.peek().val;
    for(int i=k2;i<arr2.length;i++){
        while(pq4.size()>0 && pq4.peek().idx<=(i-k2)){
            pq4.remove();
        }
        pq4.add(new pair(arr2[i],i));
        res[i-k2+1]=pq4.peek().val;
    }
    for(int i=0; i<res.length;i++){
        System.out.print(res[i]+" ");
    }
}
}
