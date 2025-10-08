import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class dpQst {
    // lcs: longest common subsequence : where 2 strings are compared and the longest common substring is identified that too should be in an order as written in the string 
    public static int lcs(String str1, String str2, int n, int m){
        if(n==0  ||m==0){
            return 0;
        }
        if(str1.charAt(n-1)== str2.charAt(m-1)){
            // for last alphabet same
            return lcs(str1, str2, n-1, m-1)+1;
        }else{
            int ans1= lcs(str1, str2, n-1, m);
            int ans2= lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    // memoization
     public static int lcs2(String str1, String str2, int n, int m, int dp[][]){
        if(n==0  ||m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)== str2.charAt(m-1)){
            // for last alphabet same
            return dp[n][m]= lcs(str1, str2, n-1, m-1)+1;
        }else{
            int ans1= lcs(str1, str2, n-1, m);
            int ans2= lcs(str1, str2, n, m-1);
            return dp[n][m]=Math.max(ans1, ans2);
        }
    }
    // tabulation
         public static int lcsTab(String str1, String str2){
            int n= str1.length();
            int m= str2.length();
            int dp[][]= new int [n+1][m+1];
            for(int i=0; i<n+1;i++){
                for(int j=0; j<m+1;j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }
                }
            }
            for(int i=1; i<n+1;i++){
                for(int j=1; j<m+1;j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]= dp[i-1][j-1]+1;
                    }else{
                        int ans1= dp[i-1][j];
                        int ans2= dp[i][j-1];
                        dp[i][j]=Math.max(ans1, ans2);
                    }
                }
            }
            return dp[n][m];
        }
    
        // LCS: LONGEST COMMON SUBSTRING: where a substring is a contiguous sequence of characters within a string eg s1= ABCDGH s2= ACDGHR output: CDGH ; it can't be c=CDH i.e. (if s2= ACDHR) G is missing can't be possible because G is mentioned in s1 and here it shouls be in a contiguous manner unline lcs(common subsequence)
        public static int longestCommonSubstring(String str3, String str4){
            int n= str3.length();
            int m= str4.length();
            int ans=0;
            int dp[][]= new int[n+1][m+1];
            // initialize
            for(int i=0; i<n+1;i++){
                dp[i][0]=0;
            }
            for(int j=0;j<m+1;j++){
                dp[0][j]=0;
            }
            // bootom up
            for(int i=1; i<n+1;i++){
                for(int j=1; j<m+1;j++){
                    if(str3.charAt(i-1)==str4.charAt(j-1)){
                        dp[i][j]= dp[i-1][j-1]+1;
                        ans= Math.max(ans, dp[i][j]);
                    }else{
                        dp[i][j]=0;
                    }
                }
            }
            return ans;
        }

        // LONGEST INCREASING SUBSEQUENCE: here order of no. will be same as assigned in an array where check the orders which are longest in increasing order keeping in mind there should be no repeatation of same no.( done by hashset if same no are present in array)
        // longest coomon sorted unique subsequence id LIS
        public static int lcs2(int arr1[], int arr2[]){
            int n= arr1.length;
            int m= arr2.length;
            int dp[][]=new int [n+1][m+1];
            // initialize
            for(int i=0;i<n+1;i++){
                dp[i][0]=0;
            }
            for(int j=0;j<m+1;j++){
                dp[0][j]=0;
            }
            // bottom up
            for(int i=1;i<n+1;i++){
                for(int j=1; j<m+1;j++){
                    if(arr1[i-1]==arr2[j-1]){
                        dp[i][j]= dp[i-1][j-1]+1;
                    }else{
                        int ans1= dp[i-1][j];
                        int ans2= dp[i][j-1];
                        dp[i][j]=Math.max(ans1, ans2);
                    }
                }
            }
            return dp[n][m];
        }
        public static int lis(int arr1[]){
            HashSet<Integer> set= new HashSet<>();
            for(int i=0; i<arr1.length;i++){
                set.add(arr1[i]);
            }
            // sorted unique elements
            int arr2[]= new int[set.size()];
            int i=0;
            for(int num:set){
                arr2[i]=num;
                i++;
            }
            // asending order
            Arrays.sort(arr2);
            return lcs2(arr1,arr2);
        }

        // WILDCARD MATCHING
        public static boolean isMatch(String s, String p){
            int n= s.length();
            int m= p.length();
            // s= string, p= pattern
            boolean dp[][]= new boolean[n+1][m+1];
            // initialize
            dp[0][0]= true;
            // pattern=" "
            for(int i=1; i<n+1;i++){
                dp[i][0]= false;
            }
            // s=" "
            for(int j=1;j<m+1;j++){
                if(p.charAt(j-1)=='*'){
                    dp[0][j]= dp[0][j-1];
                }
            }
            // bottom up
            for(int i=1; i<n+1;i++){
                for(int j=1; j<m+1;j++){
                    // case 1: ith char == jth || jth char==?
                    if(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='?'){
                        dp[i][j]=dp[i-1][j-1];
                    }else if(p.charAt(j-1)=='*'){
                        dp[i][j]=dp[i-1][j]|| dp[i][j-1];
                    }else{
                        dp[i][j]= false;
                    }
                }
            }
            // string- n; pattern-m 
            return dp[n][m];
        }

        // CATALAN'S NUMBER:
        public static int catalanRec(int x){
            if(x==0||x==1){
                return 1;
            }
            int ans=0;
            for(int i=0; i<=x-1;i++){
                ans+=catalanRec(i)*catalanRec(x-i-1);
            }
            return ans;
        }

        // memoization catalan
        public static int catalanMem(int x, int dp1[]){
            if(x==0 || x==1){
                return 1;
            }
            if (dp1[x]!=-1) {
                return dp1[x];
            }
            int ans=0;
            for(int i=0;i<x;i++){
                ans+=catalanMem(i,dp1)*catalanMem(x-i-1, dp1);
            }
            return ans;
        }
        //  tabulation catalan
        public static int catalanTab(int x){
            int dp[]= new int[x+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2; i<=x;i++){
                for(int j=0; j<i;j++){
                    // Ci= Cj*Ci-j-1
                    dp[i]+=dp[j]*dp[i-j-1];
                }
            }
            return dp[x];
        }

        // COUNT BST: USING CATALAN NUMBER CODE
        public static int countBST(int n){
            int dp[]=new int[n+1];
            dp[0]=1;
            dp[1]=1;
            for(int i=2; i<n+1;i++){
                for(int j=0; j<i;j++){
                int left= dp[j];
                int right= dp[i-j-1];
                dp[i]+=left*right;
                }
            }
            return dp[n];
        }

        // mountain ranges
        public static int mountainRanges(int y){
            int dp2[]= new int[y+1];
            dp2[0]=1;
            dp2[1]=1;
            for(int i=2; i<y+1;i++){
                for(int j=0;j<i;j++){
                    int inside= dp2[j];
                    int outside= dp2[i-j-1];

                    dp2[i]+= inside*outside;
                }
            }
            return dp2[y];
        }
    public static void main(String[] args) {
        String str1="abcdge";
        String str2="abedg";
        // // lcs= "abdg"; length =4
        // System.out.println("lcs recursion: "+lcs(str1, str2, str1.length(), str2.length()));
        // memoization in lcs
        int n= str1.length();
        int m= str2.length();
        int dp[][]= new int [n+1][m+1];
        
        for(int i=0; i<n+1;i++){
            for(int j=0; j<m+1;j++){
                dp[i][j]=-1;
            }
        }
        // System.out.println("memoization lcs :"+ lcs2(str1, str2, n, m, dp));
        // tabulation
        System.out.println("tabulation lcs: "+lcsTab(str1, str2));

        // Longest common substring
        String str3= "ABCDE";
        String str4="ABGCE";
        // output 2 (AB)
        System.out.println("Longest common substring: "+ longestCommonSubstring(str3, str4));

        // LIS
        int arr[]={50,3,10,7,40,80};
        System.out.println("lONGEST INCREASING SUBSEQUENCE: "+ lis(arr));

        // wildcard matching: wheere * can take place of any characcters or empty string, the letters can be one or more whereas ? takes place of single character and can be any alphabet. After that if 2 string mathches return true
        String s= "baaabab";
        String p= "****ba*****ab";
        // output:true
        System.out.println("wildcard matching: "+ isMatch(s, p));

        // catalan's number
        // for large no. recursion will not be efficient(it will not show output wil processs the calculation for long time) becoz it will calculate again the values while dp will directly use value without calculating the values again
        int x=5;
        System.out.println("catalan's number recursion: "+ catalanRec(x));
        int dp1[]= new int[n+1];
        Arrays.fill(dp1, -1);
        System.out.println("catalan's number memoization: "+ catalanMem(5, dp1));
        System.out.println("catalan tabulation: "+catalanTab(5));

// count bst
         System.out.println("count BST: "+ countBST(4));
    
// mountain ranges    
         System.out.println("mountain ranges: "+ mountainRanges(3)); 
    }
}
