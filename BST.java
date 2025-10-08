import java.util.ArrayList;
public class BST {
    // BST IS BINARY SEARCH TREE: 1 parent 2 child; left subtree is less than root and right subtree is greater than root
    // Time complexity: O(H)  H is height 
    // static class Node{
    //     int data;
    //     Node left;
    //     Node right;
    //     Node(int data){
    //         this.data= data;
    //     }
    // }
    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
       if(root==null){
        return;
       }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // SEARCH a BST
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
     if(root.data==key){
        return true;
     }  
     if(root.data>key){
        return search(root.left, key);
     } 
     else{
        return search(root.right, key);
     }
    }

    // DELETE a NODE
    public static Node delete(Node root, int val){
        if(root.data<val){
            root.right= delete(root.right, val);
        }
        else if(root.data>val){
        root.left=delete(root.left, val);
        }else{
            // case1: to delete leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            // case2: to delete single child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            // case3: to delete both children
            // 1. find inorder successor
            Node IS= findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
        return root;
    }
    
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    // PRINT A RANGE IN BST (EG. K1=5 K2= 12 The no. between 5 and 12 will print)
    public static void printRange(Node root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printRange(root.left, k1, k2);
        }else{
            printRange(root.right, k1, k2);
        }
    }

    // PATH FROM ROOT TO LEAF: IT prints all possible paths from root to leaf 

         public static void printPath(ArrayList<Integer>path){
            for(int i=0; i<path.size();i++){
                System.out.print(path.get(i)+"->");
            }
            System.out.println("Null");
         }
         public static void printRoot(Node root, ArrayList<Integer>path){
            if(root==null){
                return;
                
            }
            path.add(root.data);
            if(root.left==null &&root.right==null){
                printPath(path);
            }
            printRoot(root.left, path);
            printRoot(root.right, path);
            path.remove(path.size()-1);
         }

        //  VALIDATE BST: i.e. whether left subtree is less than root and right subtree is greater than root
        public static boolean isVAlid(Node root, Node min, Node max){
            if(root==null){
                return true;
            }
            if(min!=null && root.data<=min.data){
                return false;
            }else if(max!=null && root.data>=max.data){
                return false;
            }
            return isVAlid(root.left, min, root) && isVAlid(root.right, root, max);
        }

        // MIRROR IMAGE OF BST
        static class Node{
        int data;
        Node left;
        Node right;
       public  Node(int data){
            this.data= data;
            this.left=this.right=null;
        }
    }
    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }
        Node leftMirror= createMirror(root.left);
        Node rightMirror= createMirror(root.right);
        root.left=rightMirror;
        root.right=leftMirror;
        return root;
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
        // int value[]={5,1,3,4,2,7};
        // Node root=null;
        // for(int i=0;i<value.length;i++){
        //     root= insert(root, value[i]);
        // }
        // inorder(root);
        // System.out.println();

        // SEARCH a BST
        // if(search(root, 6)){
        //     System.out.println("found");
        // }else{
        //     System.out.println("not found");
        // }

        // delete
        // int values[]={8,5,3,1,4,6,10,11,14};
        //  Node root=null;
        // for(int i=0;i<values.length;i++){
        //     root= insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();
        // root=delete(root,1);
        // System.out.println();
        // inorder(root);

        // printRange(root, 5, 12);

        // paths root to leaf
        // printRoot(root, new ArrayList<>());

        // if(isVAlid(root, null, null)){
        //     System.out.println("valid");
        // }else{
        //     System.out.println("not valid");
        // }

        // MIRROR 
        Node root= new Node(8);
        root.left= new Node(5);
        root.right= new Node(10);
        root.left.left= new Node(3);
        root.left.right= new Node(6);
        root.right.left= new Node(11);
                //      8
                //      /\
                //     5  10
                //     /\   \
                //    3  6   11
        root= createMirror(root);
        // after:         8
        //                /\
        //               10 5
        //               /  /\ 
        //             11   6 3  
        preorder(root);
    }

}
