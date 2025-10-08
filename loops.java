// import java.util.Scanner;

import java.util.Scanner;

public class loops {
    public static void main(String[] args) {
        // int number=0;
        // while(number<=10){
        //     System.out.println("Hello World ");
        //     number++;
        // }


        // Scanner sc=new Scanner(System.in);
        // System.out.print("Enter range:");
        // int range= sc.nextInt();
        // int i=1;
        // int sum=0;
        // while(i<=range){
        //     sum+=i;
        //     i++;
        // }
        // System.out.println(sum);
        // sc.close();

 // Reverse of no. 
        // int number=679908;
        // while (number>0) {
        //     int lastsDig= number%10;           
        //     number=number/10;
        //     System.out.print(lastsDig);
        //        }


// for loop

// String a="hello";
//     for(int i=1;i<=10;i++){
//          System.out.println(a);
//     }

// do while loop

// int count=1;
// do{
//     System.out.println("hello");
//     count++;
// } while(count<=10);
   
// break statement: to exit loop
// for (int i=1;i<=10;i++){
//     if(i==4){
//         break;
//     }
//     System.out.println(i);
   
// }

// continue statement: to skip an iteration
// for (int i=1;i<=10;i++){
//     if(i==5){
//         continue;
//     }
//     System.out.println(i);
// }
 



// prime or not
Scanner sc= new Scanner(System.in);
System.out.print("Enter the number: ");
int num= sc.nextInt();

boolean isPrime= true;

// for (int i=2; i<=num-1; i++){
//     if(num%i==0){
//         isPrime=false;
//     }
// }

// or
for(int i=2; i<=Math.sqrt(num);i++){
    if(num%i==0){
        isPrime=false;
    }
}
if(isPrime==true){
    System.out.println("No. is Prime");
}else{
    System.out.println("No. is composite");
}
sc.close();
}
}
