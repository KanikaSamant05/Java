// import java.util.Scanner;

// public class SimpleCalculator {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Display the menu
//         System.out.println("Simple Calculator");
//         System.out.println("-------------------");
//         System.out.println("Enter the first number: ");
//         double num1 = scanner.nextDouble();

//         System.out.println("Enter an operator (+, -, *, /): ");
//         char operator = scanner.next().charAt(0);

//         System.out.println("Enter the second number: ");
//         double num2 = scanner.nextDouble();

//         double result;

//         // Perform the operation using a switch case
//         switch (operator) {
//             case '+':
//                 result = num1 + num2;
//                 System.out.println("The result is: " + result);
//                 break;

//             case '-':
//                 result = num1 - num2;
//                 System.out.println("The result is: " + result);
//                 break;

//             case '*':
//                 result = num1 * num2;
//                 System.out.println("The result is: " + result);
//                 break;

//             case '/':
//                 if (num2 != 0) {
//                     result = num1 / num2;
//                     System.out.println("The result is: " + result);
//                 } else {
//                     System.out.println("Error: Division by zero is not allowed.");
//                 }
//                 break;

//             default:
//                 System.out.println("Invalid operator! Please use +, -, *, or /.");
//                 break;
//         }

//         scanner.close(); // Close the scanner
//     }
// }


import java.util.Scanner;
    public class SimpleCalculator{
    public static void main(String[] args) {
        int[] arr = {1, 4, 34, 56, 7};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to search: ");
        int number = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                System.out.println(i)  ;
            } 
        }
        else{
            System.out.println(-1);
        }
    }
}

