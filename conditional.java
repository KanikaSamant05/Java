import java.util.Scanner;
// public class conditional {
//     public static void main(String args[]){
//         int age=15;
//         if(age>=18){
//             System.out.println("adult");
//         }
//         if(age>=13 && age<18){
//             System.out.println("teen");
//         }
//         else{
//             System.out.println("child");
//         }
//     }
// }

// largest of 3
public class conditional {
    public static void main(String args[]){
//         Scanner sc= new Scanner(System.in);
//         System.out.print("Enter A: ");
//         int a= sc.nextInt();
//         Scanner scn= new Scanner(System.in);
//         System.out.print("Enter B: ");
//         int b= scn.nextInt();

//         Scanner snr= new Scanner(System.in);
//         System.out.print("Enter C: ");
//         int c= snr.nextInt();

//         if(a>=b && a>c){
//             System.out.println("Largest no. is: "+a);
//         }
//         else if(b>a && b>c){
//             System.out.println("Largest no. is: "+b);
//         }
//         else{
//             System.out.println("Largest no. is: "+c);
//         }

//         sc.close();
//         scn.close();
//         snr.close();
//     }
// }

// ternary : variable= condition?statement 1: statement 2
//     int marks=55;
//     String result=(marks>33)?"Pass":"Fail";
//     System.out.println(result);
// }
// }
// Switch statement
// int number=1;
// switch (number) {
//     case 1:
//         System.out.println("burger ordered");
//         break;
//     case 2:
//         System.out.println("pizza ordered");
//          break;
//     case 3:
//          System.out.println("sandwich ordered");
//     default:    
//          System.out.println("please order");
//          break;
// }
// }
// }
Scanner sc= new Scanner(System.in);
System.out.print("A= ");
int a= sc.nextInt();
System.out.print("B=");
int b=sc.nextInt();
System.out.print("opeartor: ");
char op= sc.next().charAt(0);
switch (op) {
    case '+':
        System.out.println(a+b);
        break;
    case '-':
        System.out.println(a-b);
         break;
    case '*':
         System.out.println(a*b);
    case '/':
        System.out.println(a/b);
        break;
    case '%':
         System.out.println(a%b);
         break;
    default:    
         System.out.println("please enter right operator");
         break;
}
sc.close();
}
}