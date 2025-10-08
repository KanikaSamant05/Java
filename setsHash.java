import java.util.*;
public class setsHash {
//     // HASHSET: similar to hash map and contains only unique values, derived as hashmaps

// FIND ITENARY FOR TICKETS
    public static String getStart(HashMap<String,String>tickets){
        HashMap<String, String> revMAp= new HashMap<>();
        for (String key : tickets.keySet()) {
            revMAp.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if(!revMAp.containsKey(key)){
                return key;
            }         
        }
        return null;
    }
    public static void main(String[] args) {
//         HashSet<Integer> set= new HashSet<>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(3);
//         set.add(1);
//         set.add(4);
//         // System.out.println(set);
//         // System.out.println(set.size());
//         // System.out.println(set.isEmpty());
//         if(set.contains(2)){
//             // System.out.println("contains");
//         }
//         set.remove(3);
//         if(set.contains(3)){
//             // System.out.println(" doesn't contains");
//         }
//         set.clear();
//         // System.out.println(set.size());

//         // iterations on hashset (unordered)
//          HashSet<String> cities= new HashSet<>();
//          cities.add("Delhi");
//          cities.add("Noida");
//          cities.add("Bhopal");
//          cities.add("Pune");
//          Iterator it= cities.iterator();
//         //  hasnext() funcn checks whether there is any next value in HashSet
//          while (it.hasNext()) {
//          // itnext() automaticaaly iterates the value once it prints the exxisting one
//             // System.out.println(it.next());
//          }

//         //  2nd method for iteration usinf foreach method
//         // for (String city : cities) {
//         //     System.out.println(city); 
//         // }

//         // LINKED HASHSET: simplar to linked hashmap : order is followed based on the order it was added
//         // Linked hashmap and linked hashset performs extra operations to maintain order thus their performance is slighlty less than hashmap and hashset but T.C remains same
//         LinkedHashSet<String> lhs= new LinkedHashSet<>();
//         lhs.add("Delhi");
//         lhs.add("Noida");
//         lhs.add("Bhopal");
//         lhs.add("Pune");
//         // System.out.println(lhs);

//         // TREE SET : sorted order in ascending order . internally used as tree map as red black tree; no null values is inserted unlike hashset and linked hashset
//         // T.C: O(logn) more than hash and linkedhasset O(1) due to sorting
//         TreeSet<String> ts= new TreeSet<>();
//         ts.add("Delhi");
//         ts.add("Noida");
//         ts.add("Bhopal");
//         ts.add("Pune");
//         // System.out.println(ts);

//         // count distinct elements: in this the repeated element counted as a single element T.C: O(n)
        int num[]= {4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<num.length;i++){
            hs.add(num[i]);            
        } 
        // System.out.println("answer is: "+ hs.size());

        // find itenary for tickets
        HashMap<String, String> tickets= new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");
        String start= getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("->"+ tickets.get(start));
            start=tickets.get(start);
        }
        System.out.println();

        // largest subarray length where sum=0 by soving the values the sum is 0 so print largest subarray among these which gives sum=0
        int arr[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int len=0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                len=Math.max(len, j-map.get(sum));
            }else{
                map.put(sum,j);
            }
        }
        System.out.println("largest subarray length: "+ len);
    
    // subarray sum equals k:count how many subarrays 
        int arr2[]={10,2,-2,-20,10};
        int k=-10;
        HashMap<Integer,Integer>maps=new HashMap<>();
        maps.put(0, 1);
        int sum1=0;
        int ans=0;
        for(int j=0;j<arr2.length;j++){
            sum1+=arr2[j];
            if(maps.containsKey(sum1-k)){
                ans+=maps.get(sum1-k);
            }
            maps.put(sum1, maps.getOrDefault(sum1, 0)+1);
        }
        System.out.println(ans); 
    }
}
