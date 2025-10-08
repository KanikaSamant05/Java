import java.util.Scanner;

public class JavaBasics{
    public static void main(String[] args) {
        // System.out.println("heloo");
        // Scanner sc= new Scanner(System.in);
        // System.out.print("Enter a number: " );  
        // int a = sc.nextInt();
        // Scanner scn= new Scanner(System.in);
        // System.out.print("Enter a string: ");
        // String b= scn.nextLine();

        // System.out.println(a);
        // System.out.println(b);

        Scanner snr= new Scanner(System.in);
        float r= snr.nextFloat();
        float area= 3.14f*r*r;
        System.out.println("area of circle = " +area); 
       
       
    snr.close();
    }
}