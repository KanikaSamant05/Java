public class Backtracking {
// finding subset: total subset 2 to the power n if n is the string given
public static void findingSubset(String str, String ans, int i){
// base case 
if(i==str.length()){
    // if(ans.length()==0){
    //     System.out.println("null");
    // }else{
    //     System.out.println(ans);
    // }
    System.out.println(ans);
    return;
}
// yes choice
findingSubset(str, ans+str.charAt(i), i+1);
// no choice, i+1 will always occur becoz everytime the choice are asked by characterbut in no choice we will not add string to the answer
findingSubset(str, ans, i+1);
}

// permutation: all possible combination(n string or no. ke n! permutation eg n=3 permutation= 3*2*1=6)
public static void findPermutation(String str, String ans) {
    // base case
    if(str.length()==0){
        System.out.println(ans);
        return;
    }
    // recursion
    for(int i=0; i<str.length();i++){
        char curr= str.charAt(i);
        // abcde=ab+de= abde, c is removed simiarly to remove ith elementwe use below mentioned steps
        String NewStr=str.substring(0, i)+ str.substring(i+1);
        findPermutation(NewStr, ans+curr); 
    }
}

// N-Queen problem
// to check rules: if pos. is wrong we will change its value or the value placed above it.
public static boolean isSafe(char board[][],int row, int col) {
    // vertical up
for(int i=row-1; i>=0;i--){
    if(board[i][col]=='Q'){
    return false;
}
}
// diag right up
for(int i=row-1, j=col+1;i>=0 && j<board.length;i--,j++){
    if(board[i][j]=='Q'){
    return false;
}
}
// diag left up
for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j--){
    if(board[i][j]=='Q'){
    return false;
}
}
return true;
}

public static void NQueens(char board[][], int row) {
// /base case
if(row==board.length){
    printBoard(board);
    count++;
    return;
} 
    //    column loop
    for(int j=0;j<board.length;j++){
        if(isSafe(board, row, j)){
             board[row][j]='Q';
        // function call
             NQueens(board,row+1);
        // backtracking step
             board[row][j]='x';
        }     
    }
}
public static void printBoard(char board[][]) {
    System.out.println("----chess board----");
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board.length;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
    }
}

// count ways of nQueens problem
static int count=0;

// GRID WAYS: To  find ways to reach from 0,0 to target i.e. at the end cell of board
public static int gridWays(int i, int j, int n, int m) {
    // i,j current cell; n,m total row and column(3*3)
    // base case: when current cell is itelf a target cell there will be no furthur movement and the way is 1 ways only by staying at that cell
    if(i==n-1 && j==m-1){
        return 1;
    } 
    // if boundary is crossed i.e. i and j==n. Since i and j starts with 0 thus, n will be out of boundary
    else if(i==n || j==n){
        return 0;
    }
    // down
    int w1= gridWays(i+1, j, n, m);
    // right
    int w2= gridWays(i, j+1, n, m);
    return w1+w2;
}
    public static void main(String[] args) {
        // String str="abc";
        // findingSubset(str,"",0);
        // findPermutation(str, "");

        // NQueens problem
    //     int n=5;
    //     char board[][]=new char[n][n];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             board[i][j]='.';
    //         }
    //     }
    //    NQueens(board, 0);   
    //    System.out.println("Total count: "+ count);

    // GRID WAYS
    int n=3 ,m=3;
    System.out.println(gridWays(0, 0, n, m));

    }
}
