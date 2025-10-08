public class dp {
    // DYNAMIC PROGRAMMING: to make sure T.C is less than that in recursion 2ways: memoization , tabulation
    // memoization: using 
    // FIBONACCI SERIES using DP

    // through memoization (T.C Linear) (Top down: i.e bigger problem is solved then smaller problem): i.e. directly using the values without recalculating the fibonacci of same no. multiple time  unlike recursion(T.C exponential)
    // public static int fib(int n,int f[]){
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     if (f[n]!=0) {
    //         return f[n];
    //     }
    //     f[n]=fib(n-1,f)+fib(n-2, f);
    //     return f[n];
    // }

    // THROUGH TABULATION (bottom-up- smaller to big approach): using iteration i.e using loops no recursion 
    public static int fib(int n, int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        } 
        f[n]=fib(n-1, f)+fib(n-2,f);
        return f[n];
    } 
    public static int fibTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        // ans
        return dp[n];
    }
public static void main(String[] args) {
    int n=5;
    int f[]=new int[n+1];
    // System.out.println(fib(n, f));   
    System.out.println(fibTabulation(n));
    
}
}
