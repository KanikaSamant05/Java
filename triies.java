// TRIES: THESE ARE DATA ST. MAINLY FOCUSES ON STRING WHICH IS USED TO FIND THE PREFIX OF STRING, THEY ARE IN THE TREE FORMAT eg. apple, apprentice prefix: app. Also known also prefix tree and 
// known as k-arry tree because contains n no. of child and the prefixes comes only once they are not repeated in a tree
public class triies {
    static class Node {
        Node children[]=new Node[26];
        boolean eow= false;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }        
    }
    public static Node root= new Node();

    // Insertion in tries T.C is O(l) l= length of words
    public static void insert(String word){

        Node curr=root;
        for(int level=0; level<word.length();level++){
            int idx= word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    // startsWith problem : it checks whether the given trie or array contains any prefix or not asked for the given value and returns as true or not eg. for prefix- app is true; for prefix- moon is false
    public static boolean startsWith(String prefix){
        Node curr=root;
        for(int i=0; i<prefix.length();i++){
            int idx= prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    // search O(l)
    public static boolean search(String key){
        Node curr= root;
        for(int level=0; level<key.length();level++){
            int idx= key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr= curr.children[idx];
        }
        return curr.eow==true;
    }

    // find whether the words are present or not
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
           if(search(key.substring(0, i)) &&
           wordBreak(key.substring(i))){
            return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        // String words[]={"the","a","there","their","any","thee"};
        // for(int i=0; i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(search("thee"));
        // System.out.println(search("thor"));

        // 
        String arr[]={"i","like","sam","samsung","mobile","ice"};
        for(int i=0; i<arr.length;i++){
            insert(arr[i]);
        }
        String key="ilikesam";
        // System.out.println(wordBreak(key)); 
        
        // startWith problem
        String words[]={"apple","app","man","mango","woman"};
        String prefix1= "app";
        String prefix2= "moon";
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println("prefix 1 "+startsWith(prefix1));
        System.out.println("prefix 2 "+startsWith(prefix2));
    }

}
