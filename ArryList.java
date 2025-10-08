// array list stores data as an array but we can change the array sized dynamically(while running the code) unlike array where there is a fixed size, once it is defined then there are no changes to be done.
// array list does not use primitive datatype(int, string etc), instead it uses non-primitive datatype(Integer, String etx these are the classes which contain objects like 1,2,3.. in case of Integer) 
// representation: Arraylist with <> it defines the class we will use then define the name of the ArrayList.eg. Arraylist<Integer>list = new ArrayList<>();
// import ArrayList and its is a part of java collection framework(inbuilt classes and data structure.)
// we use get method to get the element in Array list unlink arrays arr[i]
import java.util.ArrayList;

public class ArryList {

    // SWAP ELEMENTS
    public static void swap(ArrayList<Integer> swapList, int idx1, int idx2){
        int temp=swapList.get(idx1);
        // to swap set assins the value to the index and get will show the value from which we are swapping index 1
        swapList.set(idx1, swapList.get(idx2));
        swapList.set(idx2,temp);
}
    public static void main(String[] args) {
  // angular bracket identifies which type of data is getting store in list.
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

// SWAP
        ArrayList<Integer> swapList = new ArrayList<>();
          swapList.add(2);
           swapList.add(5);
            swapList.add(9);
             swapList.add(3);
              swapList.add(6);
        int idx1=1 , idx2=3;
        System.out.println("BEfore: "+swapList);
        swap(swapList, idx1, idx2);
        System.out.println("After: "+swapList);

// OPERATIONS IN ARRAY LIST
// 1. ADD ELEMENT Time complexity-O(1)
        ArrayList<Integer> list4= new ArrayList<>();
// type the name of the list then .add() put the value inside the bracket 
         list4.add(28);
         list4.add(45);
         list4.add(4);
         list4.add(5);
         System.out.println(list4);
// OTHER METHOD WHICH INCLUDE INDEx i.e. .add(index,value). It adds value to that index and move forwards the other values
//    TC-O(n)
         list4.add(0,12);
         System.out.println(list4);

// 2.  GET ELEMENT- TO FIND THE OBJECT IN A LIST IN A PART. INDEX 
// TC-O(1)
// assign the variable then type the name of the list then type .get() put the index inside the bracket
          int element=list4.get(2);
          System.out.println(element);

// 3.  REMOVE ELEMENT- TO DELETE THE OBJECT IN A LIST IN A PART. INDEX
// TC- O(n)
//  type the name of the list then type .remove() put the index inside the bracket
         list4.remove(3);
          System.out.println(list4);
   
// 4.  SET ELEMENT AT INDEX- TO set THE new value IN A LIST IN A PART. INDEX
// TC- O(n)
// type the name of the list then type .set() put the index no, new value inside the bracket
         list4.set(2,100);
        System.out.println(list4);
   
// 2.  CONTAIN ELEMENT- TO FIND THat whether the element is present IN A LIST.
// TC- O(n)
// type the name of the list then type .contains() put the value inside the bracket, it will return true or false
        
          System.out.println(list4.contains(100));
          System.out.println(list4.contains(459));

        //   SIZE OF ELEMENT  : size is a method or functION here UNLIKE array WHERE length() is a property
        System.out.println(list4.size());
        // PRINT THE ARRAY LIST
        System.out.println("array list");
        for(int i=0; i<list4.size();i++){
            System.out.print(list4.get(i)+" ");
        }
        System.out.println();

        // REVERSE OF AN ARRAY TC-O(n)
        for(int i=list4.size()-1;i>=0;i--){
            System.out.print(list4.get(i)+ " ");
        }
        System.out.println();

        //  MAX IN ARRAY LIST TC-O(n)
        // MAX=-INFINITY i.e.Integer.MIN_VALUE
        int max= Integer.MIN_VALUE;
        for(int i =0;i<list4.size();i++){
        //      if(max<list4.get(i)){
        //         max=list4.get(i);
        //      }
        
        // OR
        max=Math.max(max,list4.get(i));
            }
       System.out.println("Max element= "+ max);
    }
}
