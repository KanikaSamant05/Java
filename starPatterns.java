public class starPatterns {
    // public static void main(String[] args) {
    //     for(int line=1;line<=4;line++){
    //         System.out.println("****");
    //     }
    // }
// }

// right triangle star pattern(
// lines (outer loop - 4 times)
// STAR print (inner loop i.e. 1st line-1, 2nd-2...4th line- 4 stars) i.e. i times 
// for(int line=1;line<=4;line++){
//     for (int star=1;star<=line;star++){
//         System.out.print("*");
//     }
//     System.out.println();
// }


// right triangle star pattern(inverted) n is total no. of line
// int n=4;
// for (int line=1;line<=n;line++){
//     for(int star=1;star<=n-line+1;star++){
//         System.out.print("*");
//     }
// System.out.println();
// }
// }
// }

// half pyramid 
// int n=4;
// for(int line=1; line<=n;line++){
//     for(int num=1;num<=line;num++){
//         System.out.print(num);
//     }
//     System.out.println();
// }
// }
// }


// Charachter pattern
// int n=4;
// char ch='A';
// for(int line=1;line<=n;line++){
//     for(int chars=1;chars<=line;chars++){
//         System.out.print(ch);
//         ch++;
//     }
//     System.out.println();
// }
    
// }

// hollow rectangle pattern
// public static void hollw_rec(int tot_rows, int tot_cols) {
//     for( int i=1; i<=tot_rows;i++){
//         for(int j=1; j<=tot_cols;j++){
//             if(i==1||i==tot_rows||j==1||j==tot_cols){
//                 System.out.print("*");
//             }else{
//                 System.out.print(" ");
//             }
//         }
//         System.out.println();
//     }   
// }

// rotated half pyramid
public static void invertedPyramid(int n){
    for(int i=1;i<=n;i++){
        for(int j=1; j<=n-i;j++){
            System.out.print(" ");
        }
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    }

// public static void invertedPyramidNum(int n){
// for(int i=1;i<=n;i++){
//     for(int j=1; j<=n-i+1;j++){
//         System.out.print(j);
//     }
//     System.out.println();
// }
// }

// floyd treiangle pattern
// public static void floydTri(int n){
//     int counter=1;
//     for(int i=1;i<=n;i++){
//         for(int j=1; j<=i;j++){
//             System.out.print(counter+" ");
//             counter++;
//         }
        
//         System.out.println();
//     }
//     }

// 0-1 triangle pattern
// public static void zero_one_tri(int n){
//         for(int i=1;i<=n;i++){
//             for(int j=1; j<=i;j++){
//                 if((i+j)%2==0){
//                     System.out.print("1"+" ");                    
//                 }else{
//                     System.out.print("0"+" ");
//                 }              
//             }           
//             System.out.println();
//         }
        // }/

    
// butterfly pattern

// public static void butterflyPattern(int n) {
// 1st half

//     for(int i=1;i<=n;i++){
//         for(int j=1;j<=i;j++ ){
//             System.out.print("*");
//         }
//         for(int j=1;j<=2*(n-i);j++){
//             System.out.print(" ");
//         }
//         for(int j=1;j<=i;j++){
//             System.out.print("*");
//         }
//         System.out.println();
//     }
// // 2nd half

// for(int i=n;i>=1;i--){
//     for(int j=1;j<=i;j++){
//         System.out.print("*");
//     }
//     for(int j=1;j<=2*(n-i);j++){
//         System.out.print(" ");
//     }
//     for(int j=1;j<=i;j++){
//         System.out.print("*");
//     }
//     System.out.println();
// }    
// } 

// solid rhombus pattern
// public static void rhombusPattern(int n) {
// for(int i=1;i<=n;i++){
//     for(int j=1;j<=(n-i);j++){
//         System.out.print(" ");
//     }
//     for(int j=1;j<=n;j++){
//         System.out.print("*");
//     }
//     System.out.println();
// }   
// }

// hollow rhombus
// public static void hollowRhombus(int n) {
//     for(int i=1;i<=n;i++){
//         for(int j=1;j<=(n-i);j++){
//             System.out.print(" ");
//         }
//         // hollow rect stars
//         for(int j=1;j<=n;j++){
//             if(i==1||i==n||j==1||j==n){
//                 System.out.print("*");
//             }else{
//                 System.out.print(" ");
//             }
//         }
//         System.out.println();
//     }
// }

// diamond pattern
public static void diamond(int n) {
    // 1st half
    for(int i=1;i<=n;i++){
        for(int j=1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    // 2nd half
    for(int i=n;i>=1;i--){
        for(int j=1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=(2*i)-1;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
    // hollw_rec(4, 5);
    // invertedPyramidNum(5);
    // invertedPyramid(5);
    // floydTri(5);
    // zero_one_tri(5);
    // butterflyPattern(5);
    // rhombusPattern(5);
    // hollowRhombus(5);
    diamond(4);
}
}














