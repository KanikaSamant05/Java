import java.util.*;
public class hashmaps {

    //  Anagram means all the letters in 2 words or string present or not
    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0; i<s.length();i++){
            // find character at ith index
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch= t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
     
    public static void main(String[] args) {
        // Create
        HashMap<String,Integer> hm = new HashMap<>();
        // insert
        hm.put("India", 150);
        hm.put("US", 100);
        hm.put("Bhutan",50);
        // System.out.print(hm+" ");
        // System.out.println();
        // get
        int population = hm.get("India");
        // System.out.println(population);
        // System.out.println(hm.get("Indonesia"));
        // containsKey
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("China"));
        //  remove
        hm.remove("Bhutan");
        // System.out.println(hm);
        // System.out.println(hm.remove("Indonesia"));
        // size
        // System.out.println(hm.size());
        // isEmpty
        // System.out.println(hm.isEmpty());
        // clear :removes all the valyes and keys
        hm.clear();
        // System.out.println(hm.isEmpty());

        // to iterate in hashmap we need to create a set
        // HashMap<String,Integer> hm2 = new HashMap<>();
        // hm2.put("India", 150);
        // hm2.put("US", 100);
        // hm2.put("Bhutan",200);
        // hm2.put("Switzerland",70);
        // // iterate (hasmap and set gives random orders)
        // Set<String> keys = hm2.keySet();
        // System.out.println(keys);
        // // foreach is used (mostly used in arrays or collection)
        // for (String k : keys) {
        //     System.out.println(("key=")+k+",value="+hm2.get(k));
        // }

        //  using linked list hashmap: T.C= O(1) for each funcn but it prints data serially.
        LinkedHashMap<String,Integer> lhm= new LinkedHashMap<>();
        lhm.put("India", 150);
        lhm.put("US", 100);
        lhm.put("Bhutan",200);
        lhm.put("Switzerland",70);
        // System.out.println("Linked hm");
        // System.out.println(lhm);

        // using tree hashmaps: it prints output while sorting . T.C slighlty increases (O(logn))
        TreeMap<String,Integer> tm= new TreeMap<>();
        tm.put("India", 150);
        tm.put("US", 100);
        tm.put("Bhutan",200);
        tm.put("Switzerland",70);
        // System.out.println("tree hm");
        // System.out.println(tm);


        // MAJORITY ELEMENT  
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer>map= new HashMap<>();
        // for(int i=0;i<arr.length;i++){
        //     if(map.containsKey(arr[i])){
        //         map.put(arr[i], map.get(arr[i])+1);
        //     }else{
        //         map.put(arr[i], 1);
        //     }
        // }
        // Set<Integer> keySet= map.keySet();
        // for(Integer key: keySet){
        //     if(map.get(key)>arr.length/3){
        //         System.out.println(key);
        //     }
        // }

        // to shorten the code i.e. without using set for iteration
        for(int i=0; i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        for(Integer key: map.keySet()){
            if(map.get(key)>arr.length/3){
                // System.out.println(key);
            }
        }

        // ANAGRAM (best case : o(n) T.C )
        String s= "tulip";
        String t= "lipid";
        System.out.println(isAnagram(s, t));
    }
}
