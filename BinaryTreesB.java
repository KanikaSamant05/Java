import java.util.LinkedList;
import java.util.*;
public class BinaryTreesB {
    // BINAR TREES refers to the parent and child relation, it forms a hierarchy i.e. there are parent and children nodes. 
    // in the main funcn there is -1 which represents null ( no furthur node from that particular node)
    // T.C. O(n)
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data= data;
            this.left= null;
            this.right= null;
        }
    }
    static class BinaryTree{
        static int idx= -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode= new Node(nodes[idx]);
            newNode.left= buildTree(nodes);
            newNode.right= buildTree(nodes);
            return newNode;
        }
//              1
//              /\
//             2   3     
//            / \   \
//           4   5   6
// 


    // PREORDER TRAVERSAL: writing nodes where root node gets 1st position i.e. root left subtree right subtree here in below given eg. 1 2 4 5 3 6
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }


// INORDER TRAVERSAL: root is in between i.e. left subtree root right subtree (eg. 4 2 5 1 3 6)
     public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }

    // POSTORDER TRAVERSAL: root at last i.e. left subtree right subtree root(eg.4 5 2 6 3 1)
      public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);       
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }

    // LEVEL ORDER : level wise printing nodes(eg 1 23 456)
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode= q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
}
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree= new BinaryTree();
        Node root= tree.buildTree(nodes);
        System.out.println(root.data);

        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        tree.levelOrder(root);
    }   
}
