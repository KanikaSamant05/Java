public class triesQs {

        //  Shortest unique prefix
    static class Node {
        Node[] children=new Node[26];
        boolean eow= false;
        int freq;
        public Node(){
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            freq=1;
        }
    }  
    public static Node root= new Node();     
        public static void insert(String word){
        Node curr= root;
        for(int i=0; i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();        
            }else{
               curr.children[idx].freq++;
            }
            curr= curr.children[idx];
        }
       curr.eow=true;
    }

    // find prefix
    public static void findPrefix(Node root, String ans, int idx){
        if(root==null){
            return;
        }
        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<26;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'), idx);
            }
        }
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

    // count unique substring: toal no. of subtring that are not repeated
    // steps: 1. find all suffix 2. create a trie tree + insert the suffixes in trie D.S 3. count nodes of trie here trie is created because trie is that data st. which stores only unique prefixes

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        // +1 is to count itself (self node) at each level
        return count+1;
    }

    // find longest word in trie 
    public static String ans="";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
            return;
        }
// to print alphabetically in desc. order i.e. from last z y x w
        // for(int i=25;i>=0;i--){

        // to print alphabetically asc. order i.e. a b c d
            for(int i=0;i<26;i--){
            if(root.children[i]!=null && root.children[i].eow==true){
                char ch= (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                // last character of the total length ,-1 becoz to remove the character from temp to backtrack to again store the next values and checking wheteher it makes a longest word or not , if yes ans is updated
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
         // find prefix 
        // String arr[]={"zebra","dog","duck","dove"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }
        // root.freq =-1;
        // findPrefix(root, "", 0);

// count total possible unique substings ans=10
        // String str="ababa";
// suffix and insert
        // for(int i=0; i<str.length();i++){
        //     String suffix= str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countNodes(root));

        // to find longest prefix : in apple or apply alphabet is preferred (lexographically)
        String words[]={"a","banaana","app","appl","ap", "apply","apple"};
        for(int i=0; i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
