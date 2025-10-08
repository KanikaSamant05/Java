import java.util.ArrayList;
import java.util.Collections;

public class ArraylistQS {
    // SOrting: use Collections.sort(name of the list)
public static void main(String[] args) {
    ArrayList<Integer> sortList= new ArrayList<>();
    sortList.add(2);
    sortList.add(7);
    sortList.add(9);
    sortList.add(5);
    sortList.add(6);
    // Ascending 
    Collections.sort(sortList);
    System.out.println(sortList);
    // descending
    // Collections.reverseOrder() is a function which provides logic to sort an array list.
    Collections.sort(sortList, Collections.reverseOrder());
    System.out.println("descending "+sortList);

// MULTI-DIMENSIONAL LIST
     ArrayList<ArrayList<Integer>> mainList= new ArrayList<>();
     ArrayList<Integer> list= new ArrayList<>();
     list.add(1); list.add(2);
     mainList.add(list);

     ArrayList<Integer> list2=new ArrayList<>();
     list2.add(3); list2.add(4);
     mainList.add(list2);

     for(int i=0;i<mainList.size();i++){
        ArrayList<Integer> currList = mainList.get(i);
        for(int j=0;j<currList.size();j++){
            System.out.print(currList.get(j)+" ");
        }System.out.println();
     }
     System.out.println(mainList);

// ques. in multi dimensional  
    ArrayList<ArrayList<Integer>> MainList= new ArrayList<>();
    ArrayList<Integer> firstList= new ArrayList<>();
    ArrayList<Integer> secondList= new ArrayList<>();
    ArrayList<Integer> thirdList= new ArrayList<>();
    for( int i=1;i<=5;i++){
        // 1,2,3,4,5
        firstList.add(i*1);
        // 2 4 6 8 10
        secondList.add(i*2);
        // 3 6 9 12 15
        thirdList.add(i*3);
    }
    MainList.add(firstList);
    MainList.add(secondList);
    MainList.add(thirdList);
    System.out.println(MainList);
// to print individual list, nested loop is used 
     for(int i=0;i<MainList.size();i++){
        ArrayList<Integer> Currlist=MainList.get(i);
        for(int j=0;j<Currlist.size();j++){
            System.out.print(Currlist.get(j)+" ");
        } System.out.println();
     }
    
}
}
