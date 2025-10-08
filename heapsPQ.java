// HEAPS: collection of data a, it is a data st.which s\is a type of BST which uses or implements array or arrrayList which defines priority queue
// max heap: where priority is given max value or priority
// Min heap: where priority is given min value or priority (by default)
// PRIORITY QUEUE: performing functions base on priority
// It is accessed similar to linked list
import java.util.Comparator;
import java.util.PriorityQueue;
public class heapsPQ {

    // to perform functions on object we need to create class object and constructor; and to compare the values in an object we implement Comparable funcn which gives access the object to compare which is accessed by using @Override funcn
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }
        // to compare 1st object this and 2nd object s2
        @Override
        public int compareTo(Student s2){
            return this.rank- s2.rank;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(3);
        // pq.add(4);
        // pq.add(5);
        // pq.add(6);
        //  while(!pq.isEmpty()){
        //     System.out.print(pq.peek()+ " ");
        //     pq.remove();
        //  }

        //  to store objects in priority queue
        PriorityQueue<Student> pq2 =new PriorityQueue<>();
        pq2.add(new Student("A", 4));
        pq2.add(new Student("B", 5));
        pq2.add(new Student("C", 12));
        pq2.add(new Student("D", 2));
        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name+"->"+ pq2.peek().rank);
            pq2.remove();
        }

}
}
