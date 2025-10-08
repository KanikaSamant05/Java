import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreesQs {
    static class Node{
        int data;
        Node left, right;
    
    public Node(int data){
        this.data= data;
        this.left= null;
        this.right= null;
    }
}
    // we use recursion 
    // HEIGHT: DISTANCE FROM ROOT TO LEAF(LAST NODE WITH NO FURTHUR CHILD)2 METHODS:1. NODE 2. EDGES 
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh= height(root.right);
        return Math.max(lh,rh)+1;
    }
    // count nodes
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftCount= count(root.left);
        int rightCount= count(root.right);
        return leftCount+rightCount+1;
    }
    // sum of nodes
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum=sum(root.left);
        int rightSum= sum(root.right);
        return leftSum+rightSum+root.data;

   }

//    diameter : finding possible distance between 2 nodes. The maximum dist. is considered as diameter ( found by counting node)
    //   TC: O(n^2): ht and dia
        // public static int diameter(Node root){
    //     if(root==null){
    //         return 0;
    //     }
    //     int leftdia= diameter(root.left);
    //     int leftht= height(root.left);
    //     int rightdia= diameter(root.right);
    //     int rightht= height(root.right);
    //     int selfdia= leftht+rightht+1;
    //     return Math.max(selfdia, Math.max(leftdia, rightdia));

    //   }

    //   2nd approach to fing diameter: O(n) TC becoz here now a node will return its diameter and ht. simultaneously 
    static class Info{
        int diam;
        int ht;
        public Info(int diam, int ht){
            this.diam= diam;
            this.ht= ht;
        }
    }
    public static Info diameter(Node root){
        if(root==null){
            return new Info(0, 0);
        }
    //    both ht and diameter is provided as Info class contains both ht and diameter.
        Info leftInfo= diameter(root.left);
        Info rightInfo= diameter(root.right);
        int diam= Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht= Math.max(leftInfo.ht, rightInfo.ht)+1;
        return new Info(diam,ht);
    }  

    // subtree of another tree eg 
            //     2      
            //     /\    true 
            //    4  5
        public static boolean isIdentical(Node node, Node subRoot){
            if(node==null && subRoot==null){
                return true;
            }
            else if(node==null || subRoot==null || node.data!=subRoot.data){
                return false;
            }
            if(!isIdentical(node.left, subRoot .left)){
                return false;
            }
             if(!isIdentical(node.right, subRoot .right)){
                return false;
            }
            return true;
        }
        public static boolean isSubtree(Node root, Node subRoot){
            if(root==null){
                return false;
            }
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }          
            }
            boolean leftAns= isSubtree(root.left, subRoot);
            boolean rightAns= isSubtree(root.right, subRoot);
            return leftAns || rightAns;
        }    

// TOP VIEW
        static class Information{
            Node node;
            int hd;
            public Information(Node node, int hd){
                this.node=node;
                this.hd= hd;
            }
        }
        
        public static void topView(Node root){
            // level order
            Queue<Information> q= new LinkedList<>();
            HashMap<Integer,Node> map= new HashMap<>();
            int min=0, max=0;
            q.add(new Information(root,0));
            q.add(null);
            while(!q.isEmpty()){
                Information curr=q.remove();
                if(curr== null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                    else{
                         if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Information(curr.node.left, curr.hd-1));
                    min=Math.min(min, curr.hd-1);
                }if(curr.node.right!=null){
                    q.add(new Information(curr.node.right, curr.hd+1));
                    max=Math.max(max, curr.hd+1);
                }
                }
            }       
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
        }

        // kth level: print all nodes of the given level
         public static void kLevel(Node root, int level,int k){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            kLevel( root.left, level+1, k);
            kLevel(root.right,level+1, k);
         }

        //  LAST COMMON ANCESTOR: here the function will check from root to the nodes given than the last common parent is the output
        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }
            boolean foundLeft= getPath(root.left, n, path);
            boolean foundRight= getPath(root.right, n, path);
            if(foundLeft||foundRight){
                return true;
            }
            path.remove(path.size()-1);
            return false;
           }
        
        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1= new ArrayList<>();
            ArrayList<Node> path2= new ArrayList<>();
            getPath(root, n1, path1);
            getPath(root, n2, path2);

            // last common ancestor
            int i=0;
            for(i=0; i<path1.size() && i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
            Node lca= path1.get(i-1);
            return lca;
        }
        // 2nd approach
        public static Node lca2(Node root, int n1, int n2 ){
            if(root==null){
                return null;
            }
            if(root.data==n1 || root.data==n2){
                return root;
            }
            Node leftLca=lca2(root.left, n1, n2);
            Node rightLca=lca2(root.right, n1, n2);
            if(rightLca==null){
                return leftLca;
            }
              if(leftLca==null){
                return rightLca;
            }
            return root;
        }

        // minimum distance
        public static int lcaDist(Node root, int n){
             if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftDist= lcaDist(root.left, n);
            int rightDist= lcaDist(root.right, n);
            if(leftDist==-1 && rightDist==-1){
                return -1;
            }else if(leftDist==-1){
                return rightDist+1;
            }else{
                return leftDist+1;
            }
        }
        public static int minDist(Node root, int n1, int n2){
           
            Node lca= lca2(root, n1, n2);
            int dist1= lcaDist(lca,n1);
             int dist2= lcaDist(lca, n2);
             return dist1+dist2;
                  }

        // k ancestot
         public static int kAncestor (Node root, int n, int K){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int leftDist=kAncestor(root.left, n, K);
            int rightDist= kAncestor(root.right, n, K);
            if(leftDist==-1 && rightDist==-1){
                return -1;
            }
            int max= Math.max(leftDist, rightDist);
            if(max+1==K){
                System.out.println(root.data);
            }
            return max+1;
         }

        //  sum of subtrees
        public static int transform(Node root){
            if(root==null){
                return 0;
            }
            int leftChild= transform(root.left);
            int rightChild= transform(root.right);
            int data= root.data;
            int newLeft= root.left==null?0: root.left.data;
            int newright= root.right==null?0:root.right.data;
            root.data= newLeft+leftChild+newright+rightChild;
            return data;
        }
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

    
        public static void main(String[] args) {
        //      1
//              /\
//             2   3     
//            / \   \
//           4   5   6
        Node root= new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left= new Node(6);
        root.right.right= new Node(7);
        // System.out.println(height(root));
        // System.out.println(count(root));
        // System.out.println(sum(root));
        // System.out.println(diameter(root));

// 2nd approach O(n) : here class creates an object thus, to access object like diam , ht we call the objects usig dot operator
        // System.out.println(diameter(root).diam);
        // System.out.println(diameter(root).ht);

        // subtree of another node
        // Node subRoot= new Node(2);
        // subRoot.left= new Node(4);
        // subRoot.right=new Node(5);
        // System.out.println(isSubtree(root, subRoot));

        // topView(root);

        // Kth level
        // int k=2;
        // kLevel(root, 1, k);

        // Last common ancestor
        // int n1=4, n2=6;
        // System.out.println(lca(root, n1, n2).data);
        // int n1=6, n2=7;
        // System.out.println(lca2(root, n1, n2).data);

        // MIN. DISTANCE 
        // int n1=4,  n2=6;
        // System.out.println(minDist(root, n1, n2));

        // kth ancestor
        int n=5, K=1;
        kAncestor(root, n, K);

        // SUM TREE
        transform(root);
        preorder(root);
    }

}
