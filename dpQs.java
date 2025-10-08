import java.util.*;
public class dpQs {
// climbing stairs by recusrion
    public static int countWays(int n){
        if (n==0){
            return 1;
        }
        if (n<0){
            return 0;
        }
        return countWays(n-1)+countWays(n-2);
    }

    // climbing stairs by DP(Memoization)
     public static int countWaysM(int n,int ways[]){
        if (n==0){
            return 1;
        }
        if (n<0){
            return 0;
        }
        if(ways[n]!=-1){
        return ways[n];
        }
        ways[n]=countWaysM(n-1,ways)+countWaysM(n-2,ways);
        return ways[n];
    }
    // climbing stairs by tabulation
    public static int countWaysTab(int n){
        int dp[]= new int[n+1];
        dp[0]=1;
        // tabulation loop
        for(int i=1; i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

// 0-1 knapsack PROBLEM 
    // by recusrion
    public static int knapsack(int val[], int wt[], int W, int n){
        if(W==0 || n==0){
            return 0;
        }
        if(wt[n-1]<=W){
            // include
            int ans1= val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
            // exclude
            int ans2= knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
            // not valid
        }else{
            return knapsack(val, wt, W, n-1);
        }
    }

    // memoization
     public static int knapsackM(int val[], int wt[], int W, int n,int dp[][]){
        if(W==0 || n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(wt[n-1]<=W){
            // include
            int ans1= val[n-1]+knapsackM(val, wt, W-wt[n-1], n-1,dp);
            // exclude
            int ans2= knapsackM(val, wt, W, n-1,dp);
            dp[n][W]= Math.max(ans1, ans2);
            return dp[n][W];
            // not valid
        }else{
           dp[n][W]= knapsackM(val, wt, W, n-1,dp);
           return dp[n][W];
        }
    }

    // tabulation
    public static int knapsackTab(int val[], int wt[], int W){
        int n= val.length;
        int dp[][]= new int[n+1][W+1];
        for(int i=0; i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }   
    for(int i=1;i<n+1;i++){
        for(int j=1; j<W+1;j++){
            // ith item value
        int v= val[i-1];
        // ith item wt.
        int w= wt[i-1];
        if(w<=j){
            int incProfit= v+dp[i-1][j-w];
            int excProfit=dp[i-1][j];
            dp[i][j]= Math.max(incProfit, excProfit);
        }else{
            int excProfit= dp[i-1][j];
            dp[i][j]= excProfit;
        }
    }
    }
    return dp[n][W];
}


// target sum problem:with the help of knapsack considring value= wt. 
// here target sum =10 by subset sum
// printing output array

public static boolean targetSumSubset(int arr[], int sum){
    int n= arr.length;
    boolean dp[][]= new boolean[n+1][sum+1];
    // i= items j= target sum
    for(int i=0; i<n+1;i++){
        dp[i][0]= true;
    }
    for(int i=1;i<n+1;i++){
        for(int j=1; j<sum+1;j++){
            int v= arr[i-1];
            // include
            if(v<=j && dp[i-1][j-v]==true){
                dp[i][j]= true;
            }
            // exclude
            else if(dp[i-1][j]==true){
                dp[i][j]=true;
            }
        }
    }
    print(dp);
    return dp[n][sum]; 
}

// UNBOUNDED KNAPSACK: where one value can be repeated multiple times unlinke bounded knapsack
public static int unboundedKnapsack(int val[], int wt[], int W){
    int n= val.length;
    int dp[][]= new int[n+1][W+1];
    for(int i=0; i<n+1;i++){
        dp[i][0]=0;
    }
    for(int j=0;j<W+1;j++){
        dp[0][j]=0;
    }
    for(int i=1; i<n+1;i++){
        for(int j=1;j<W+1;j++){
            if(wt[i-1]<=j){
                dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
            }   else{
                dp[i][j]=dp[i-1][j];
            }
         }
    }
    return dp[n][W];
}

public static void print (boolean dp[][]){
    System.out.print("TARGET SUM ARRAY: ");
    System.out.println();
    for(int i=0; i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }
    System.out.println();
}

// rod cutting problem 
// weight= length; val= price;W= totRod
    public static int rodCutting(int length[], int price[], int totRod) {
         int n= price.length;
         int dp[][]=new int [n+1][totRod+1];
         for(int i=0;i<n+1;i++){
            for(int j=0;j<totRod+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
         }
         for(int i=1;i<n+1;i++){
            for(int j=1;j<totRod+1;j++){
                // valid
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else{
                   dp[i][j]= dp[i-1][j];
                }
            }
         }
         return dp[n][totRod];
    }
 
    public static void main(String[] args) {
        int n=5;
        System.out.println("Recursion output: "+countWays(n));
        int ways[]= new int[n+1];
        // -1 is assigned to each index of an array initially
        Arrays.fill(ways,-1);
        System.out.println("Memoization output: "+countWaysM(n,ways));
        System.out.println("Tabulation: "+countWaysTab(n));

        // 0-1KNAPSACK
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println("recusrion knapsack: "+ knapsack(val, wt, W, val.length));
        // memoization
        int dp[][]=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
        }
        }
        System.out.println("memoization knapsack: "+knapsackM(val, wt, W,val.length, dp));
        // tabulation
        System.out.println("tabulation knapsack: "+ knapsackTab(val, wt, W));
        // Unbounded knapsack
        System.out.println("Unbounded knapsack: "+ unboundedKnapsack(val, wt, W));

        // target sum 
        int arr[]= {4,2,7,1,3};
        int sum= 10;
        System.out.println("target sum: "+targetSumSubset(arr, sum) );

        // rod cutting problem
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int totRod=8;
        System.out.println("total price of rod: "+ rodCutting(length, price, totRod));
    }
}
