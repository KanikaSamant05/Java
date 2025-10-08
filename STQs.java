public class STQs {
    static int tree[];
    public static void init(int n){
        tree= new int[4*n];
    }
    // O(n)
    public static void buildTree(int arr[], int si, int sj, int i){
        if(si==sj){
           tree[i]= arr[si]; // si start ; sj= end index
           return;        
        }
        int mid=(si+sj)/2;
        buildTree(arr, si, mid, 2*i+1);
        buildTree(arr, mid+1, sj,2*i+2);
        tree[i]= Math.max(tree[2*i+1], tree[2*i+2]);
    }
    
    // O(logn)
    public static int getMax(int arr[], int qi, int qj){
        int n= arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);
    }
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
        if(si>qj || sj<qi){
            return Integer.MIN_VALUE;   // no overlap
        }else if(si>=qi && sj<=qj){
           return tree[i];  // complete overlap
        }else{
           int mid=(si+sj)/2; 
           int leftAns= getMaxUtil(2*i+1, si, mid, qi, qj);
           int rightAns= getMaxUtil(2*i+2, mid+1, sj, qi, qj);
           return Math.max(leftAns,rightAns);
        }
        }

// O(logn)
        public static void update(int arr[], int idx,int newVal ){
            arr[idx]=newVal;
            int n =arr.length;
            updateUtil(0, 0, n-1, idx, newVal);
        }
        public static void updateUtil(int i,int si, int sj, int idx, int newVal){
            if(idx<si || idx>sj){
                return;
            }
            if(si==sj){
                tree[i]=newVal;
            }
            tree[i]=Math.max(tree[i], newVal);
            if(si!=sj){
            int mid=(si+sj)/2;
            // left
            updateUtil(2*i+1, si, mid, idx, newVal);
            // right
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
            }          
        }
    
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n= arr.length;
        init(n);
        buildTree(arr, 0, n-1, 0);
        for(int i=0; i<tree.length;i++){
            System.err.print(tree[i]+" ");
        }
        System.out.println();
        int max=getMax(arr, 2, 5);
        System.out.println("max: "+max);
        update(arr, 2, 20);
        max=getMax(arr, 2, 5);
        System.out.println("max updated value: "+max);
    }
}
