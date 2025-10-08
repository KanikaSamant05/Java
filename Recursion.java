public class Recursion {
    // print no. from n to 1
    public static void printDec(int n) {
        if(n==1){
            System.out.println(n);
        return;
    }
        System.out.print(n+" ");
        printDec(n-1);
    }

    // no. 1 to 10
    public static void printInc(int n) {
        if(n==1){
            System.out.print(n+ " ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    // factorial of no. 
public static int fact(int n) {
    // base case
    if(n==0){
        return 1;
    }
    // recursive func
    int fnm1=fact(n-1);
    int fn=n*fact(n-1);
    return fn;    
}

// sum of n natural no.
public static int CalSum(int n) {
    // base case
    if (n==1){
        return 1;
    }
    // recursive func
    int sum=CalSum(n-1);
    int Sn=n+sum;
    return Sn;
}

// fibonacci series
public static int fib(int n) {
    if(n==0 || n==1){
        return n;
    }
    int fib1= fib(n-1);
    int fib2= fib(n-2);
    int fn= fib1+fib2;
    return fn;
}

// check srted array or not 
public static boolean isSorted(int arr[], int i){
    if(i==arr.length-1){
        // single element eg. arr[3]
        return true;
    }
    if(arr[i]>arr[i+1]){
    return false;
}
else{
    return isSorted(arr, i+1);
}
}

// check first occurrence of a no. in an array
public static int firstOccurence(int arr[], int key, int i) {
    if(i==arr.length){
        return -1;
    }
    if (arr[i]==key) {
        return i;
    }
    return firstOccurence(arr,key,i+1);
    
}
// check last index occurrence of a no. in an array
public static int lastOccurence(int arr[], int key, int i) {
    if(i==arr.length){
        return -1;
    }
    int isFound= lastOccurence(arr, key, i+1);
    if (isFound!= -1) {
        return isFound;
    }

    if(arr[i]==key){
        return i;
    }
    return isFound;
}

// calculation of x power n
public static int power(int x, int n) {
    if(n==0){
        return 1;
    }
    int p1= power(x, n-1);
    int p2= x*p1;
    return p2;
}

// calculation of x power n by optimized method to decrease time and space complexity
public static int optimizedPower(int a, int n) {
    if(n==0){
        return 1;
    }
    // int halfPowerSq= optimizedPower(a, n/2)*optimizedPower(a, n/2);
    // here it can take much time to again call optimizedPower func and then multiply so reduce time we can directly sq the no. and storing it in a variable
    int halfPower= optimizedPower(a, n/2);
    int halfPowerSq= halfPower*halfPower;
    // n is odd
    if(n%2!=0){
        halfPowerSq= a*halfPowerSq;
    }
    return halfPowerSq;
}


// tiling problem
public static int tilingProblem(int n) {
    // base case
    if(n==0 || n==1){
        return 1;
    }
    // kaam
    // vertical choice
    int fnm1= tilingProblem(n-1);
    // horizontal choice
    int fnm2= tilingProblem(n-2);
    int totalWays= fnm1+fnm2;
    return totalWays;
}

// check repetitive char
public static void removeDuplicates(String str, int idx, StringBuilder newString, boolean map[]){
    if(idx==str.length()){
    System.out.println(newString);
    return;
    }
// kaam function
char currChar=str.charAt(idx);
if(map[currChar -'a']==true){
    //it is duplicate i.e. no new char is added
    removeDuplicates(str, idx+1, newString, map);
}else{
    map[currChar-'a']=true;
    // here newString is appended and only single char is added to string
    removeDuplicates(str, idx+1, newString.append(currChar), map);
}
}

// friends pairing problem: to check how many ways are there to pair a person with others
public static int friendsPairing(int n) {
    if(n==1 || n==2){
        return n;
    }
    // kaam (choice)
    // single
    int fnm1= friendsPairing(n-1);
    // pair
    int fnm2= friendsPairing(n-2);
    int pairWays= (n-1)*(n-2);
    // total ways
    int totWays= fnm1+pairWays;
    return totWays;
}

// binary atring method
public static void printBinString(int n , int lastPlace, String str) {
    // base case
    if(n==0){
        System.out.println(str);
        return;
    }
    // kaam
    if(lastPlace==0){
        printBinString(n-1, 0, str+("0"));
        printBinString(n-1, 1, str+("1"));
    }else{
        printBinString(n-1, 0, str+("0"));
    }
} 

// tower of hanoi : moving n disc from A to C using B
public static void toh(int n,int A, int C ,int B) {
    if(n==0){
        return;
    }
    toh(n-1,A,B,C);
    System.out.println("Moving"+n+"th disk from "+A+"to"+C);
    toh(n-1,B,C,A);
}
    public static void main(String[] args) {
        // int n=10;
        // printDec(n);
        // printInc(n);
        // System.out.println(fact(5));
        // System.out.println(CalSum(5));
        // System.out.println(fib(5));
        
        // sorted array or not
        // int arr[]={1,2,3,4,5};
        // int arr[]={1,2,5,4,6};
        // int arr[]={5};
        // i=0 i.e. starting from 0th index
        // System.out.println(isSorted(arr, 0));

        // first occurence
        // int arr[]={1,4,5,6,5,8,8,9,5};
        // System.out.println(firstOccurence(arr, 10, 0));
    
        // last occurrence
        // int arr[]={1,4,5,6,5,8,8,9,5};
        // System.out.println(lastOccurence(arr, 5, 0));

        // power
        // System.out.println(power(2, 10));
        // System.out.println(optimizedPower(2, 5));
 

        // titling Problem
        // System.out.println(tilingProblem(2));

        // check repetetive char
        // String str="appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
    
        // friendsPairing
        // System.out.println(friendsPairing(3));

        // binary string
        printBinString(3, 0, "");
        toh(3, 1, 3, 2);
    }
}

