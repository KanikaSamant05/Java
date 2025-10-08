import java.util.Arrays;

public class dpMatrix {
    public static int mcm(int arr[], int i, int j){
        if(i==j){
            return 0; //single matrix case
        }
        int ans= Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
             int cost1= mcm(arr, i, k);      // Ai....Ak=> arr[i-1] to arr[k]
            int cost2= mcm(arr, k+1, j);   // Ai+1....Aj=> arr[k] to arr[j]
            int cost3= arr[i-1]*arr[k]*arr[j];//
            int finCost= cost1+cost2+cost3;
            ans= Math.min(ans, finCost);
        }
         return ans; // min cost
    }

    // memoization
    public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans= Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1= mcmMem(arr,i,k,dp);
            int cost2= mcmMem(arr, k+1, j, dp);
            int  cost3= arr[i-1] * arr[k] * arr[j];
            ans= Math.min(ans, cost1+cost2+cost3);
        }
        return dp[i][j]=ans;
    }
    // tabulation
    public static int mcmTab(int arr[]){
        int n= arr.length;
        int dp[][]= new int [n][n];
        for(int i=0;i<n;i++){
            dp[i][i]= 0;
        }
        for(int len=2;len<=n-1;len++){
            for(int i=1; i<=n-len;i++){
            int j= i+len-1;
            dp[i][j]= Integer.MAX_VALUE;
            for(int k=i; k<=j-1;k++){
                int cost1= dp[i][k];
                int cost2= dp[k+1][j];
                int cost3= arr[i-1]*arr[k]*arr[j];
                dp[i][j]=Math.min(dp[i][j], cost1+cost2+cost3);
            }
        }
        }
        print(dp);
        return dp[1][n-1];
    }
    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // MINIMUM SUBSET SUM DIFFERENCE OR MINIMUM PARTITIONING: ARRANGING susets in such form where the difference of 2 subset(addition of no. in each subset than their difference) is min
    public static int minPartition(int arr[]){
        int n=arr.length;
        int sum=0;
        for(int i=0; i<arr.length;i++){
            sum+=arr[i];
        }
        int W= sum/2;
        int dp[][]= new int[n+1][W+1];
        // bttom up
        for(int i=1;i<n+1;i++){
            for(int j=1; j<W+1;j++){
                if(arr[i-1]<=j){
                    // valid
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        int sum1= dp[n][W];
        int sum2= sum-sum1;
        return Math.abs(sum1-sum2);
    }

    // minimum jumps:
    public static int minJumps(int nums1[]){
        int n= nums1.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int steps= nums1[i];
            int ans= Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps && j<n;j++){
                if(dp[j]!=-1){
                    ans=Math.min(ans,dp[j]+1);
                }
            }
            if(ans!=Integer.MAX_VALUE){
                dp[i]=ans;
            }
        }
        return dp[0];
    }

    public static void main(String args[]){
        int arr[]={1,2,3,4,3};
        // int n= arr.length; // n=5
        // System.out.println("recursion"+mcm(arr, 1, n-1));

        // memoization
        // int dp[][]= new int[n][n];
        // for(int i=0; i<n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println("memoization: "+ mcmMem(arr, 1, n-1, dp));
        // tabualtion
        System.out.println("mcmTAb: "+mcmTab(arr));

        // min pRTITONAING
        int nums[]={1,6,11,5};
        System.out.println("min partiton: "+minPartition(nums));

        // min jumps
        int nums1[]= {2,3,1,1,4};
        System.out.println("min jumps: "+minJumps(nums1));
    }
}
