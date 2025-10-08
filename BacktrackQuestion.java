public class BacktrackQuestion {
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

public static boolean NQueens(char board[][], int row) {
// /base case
if(row==board.length){
    printBoard(board);
    return true;
} 
    //    column loop
    for(int j=0;j<board.length;j++){
        if(isSafe(board, row, j)){
             board[row][j]='Q';
        // function call
             if(NQueens(board,row+1)){
                return true;
             };
        // backtracking step
             board[row][j]='x';
        }     
    }
    return false;
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

// SUDOKU
public static boolean isSafe(int sudoku[][],int row,int col, int digit) {
    // column
    for(int i=0;i<=8;i++){
        if(sudoku[i][col]==digit){
            return false;
        }
    }
    // row
    for(int j=0;j<=8;j++){
        if(sudoku[row][j]==digit){
            return false;
        }
    }
    // grid
    // helps in finding the first row of the grid (3*3 matrix)
    int sr=(row/3)*3;
    // helps in finding the first column of grid 
    int sc=(col/3)*3;
    for(int i=sr;i<sr+3;i++){
        for(int j=sc; j<sc+3;j++){
           if(sudoku[i][j]==digit){
            return false;
           } 
        }
    }
    return true;
}
public static boolean sudokuSolver(int sudoku[][], int row,int col){
// base case
if(row==9 && col==0){
return true;
}

// recursion
int nextRow=row, nextCol=col+1;
if(col+1==9){
    nextRow=row+1;
    nextCol=0;
}

if(sudoku[row][col]!=0){
    return sudokuSolver(sudoku, nextRow, nextCol); 
}
for(int digit=1;digit<=9;digit++){
    if(isSafe(sudoku,row,col,digit)){
        sudoku[row][col]=digit;
        // solution exist
        if(sudokuSolver(sudoku,nextRow,nextCol)){
            return true;
        }
        sudoku[row][col]=0;
    }
}
return false; 
}
public static void printSudoku(int sudoku[][]) {
    for(int i=0; i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(sudoku[i][j]+" ");
        }
        System.out.println();
    }
    
}


// print all the paths in 4*4 matrix from 0,0 to N,N(it is the last cell of matrix)
// public static void findallPath(int i , int j, int N, int[][] matrix, boolean[][] visited, String psf){
//     if(i<0 || j<0 ||i>=N ||j>=N){
//         return;
//     }
//     if(matrix[i][j]==0||visited[i][j]==true){
//         return;
//     }
//     if(i==N-1 && j==N-1){
//        System.out.println("Reached destination with path"+psf);
//        return; 
//     }

//     visited[i][j]= true;
//     findallPath(i-1, j, N, matrix, visited, psf+"U");
//     findallPath(i+1, j, N, matrix, visited, psf +"D");
//     findallPath(i, j-1, N, matrix, visited, psf +"L");
//     findallPath(i, j+1, N, matrix, visited, psf +"R");
// // false : where there is no right path, the visited cell will return and it will be empty and can be considered for other paths
//     visited[i][j]= false;
// }

// knights problem(ghoda:2.5 movt.): knight walks in 2 up and 1 right direction
public static void findKnightsPath(int i , int j, int N, int[][] matrix, int moveNumber){
    if(i<0 || j<0 ||i>=N ||j>=N){
        return;
    }
    // has already visited this point
    if(matrix[i][j]!=0){
        return;
    }
    matrix[i][j]=moveNumber;
    if(moveNumber==N*N-1){
        // print matrix
        for(int x=0;x<N;x++){
            for(int y=0;y<N;y++){
              System.out.print(matrix[x][y]+" ");
            }
            System.out.println();
        }
       return; 
    }
    findKnightsPath(i-2, j+1,N,matrix,moveNumber+1);
    findKnightsPath(i-1, j+2,N,matrix,moveNumber+1);
    findKnightsPath(i+1, j+2,N,matrix,moveNumber+1);
    findKnightsPath(i+2, j+1,N,matrix,moveNumber+1);
    findKnightsPath(i+2, j-1,N,matrix,moveNumber+1);
    findKnightsPath(i+1, j-2,N,matrix,moveNumber+1);
    findKnightsPath(i-1, j-2,N,matrix,moveNumber+1);
    findKnightsPath(i-2, j-1,N,matrix,moveNumber+1);
//    can visit cell for other path
    matrix[i][j]=0;
}

public static void main(String[] args) {

    // NQueens problem
    //     int n=5;
    //     char board[][]=new char[n][n];
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             board[i][j]='x';
    //         }
    //     }
    //   if(NQueens(board, 0)) {
    //     System.out.println("Possible solution");
    //     printBoard(board);
    //   }else{
    //     System.out.println("no possible solution");
    //   } 
      
    //   sudoku 
    // int sudoku[][]={{0,0,8,0,0,0,0,0,0},
    // {4,9,0,1,5,7,0,0,2},
    // {0,0,3,0,0,4,1,9,0},
    // {1,8,5,0,6,0,0,2,0},
    // {0,0,0,0,2,0,0,6,0},
    // {9,6,0,4,0,5,3,0,0},
    // {0,3,0,0,7,2,0,0,4},
    // {0,4,9,0,3,0,0,5,7},
    // {8,2,7,0,0,9,0,1,3}};   
    // if(sudokuSolver(sudoku, 0, 0)){
    //     System.out.println("Solution exist");
    //     printSudoku(sudoku);
    // } else{
    //     System.out.println("Sol. doesn't exist ");
    // }

    // find no. of paths can't enter in the cell where there is 0
    // here wherever there is 1 in the cell, the movement of object will be there only; cells containing 0 will not allow the movement in that cell
    // int[][] matrix= {{1,1,1,1},{0,1,0,1},{1,1,1,1},{1,0,1,1}};
    // int N= matrix.length;
    // boolean[][] visited= new boolean[N][N];
    // findallPath(0, 0, N, matrix, visited," ");

    // knights path
    findKnightsPath(0, 0, 8, new int[8][8], 0);
}
}

