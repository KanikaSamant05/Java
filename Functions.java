// jaava always takes call by value instead of call by reference
public class Functions {
    public static void printHelloWorld() {
        System.out.println("hello World");
        System.out.println("hello World");
        return;
    }
    public static int CalculateSum(int num1,int num2){
        int sum=num1+num2;
        return sum;
    }
 // Swap
    public static void SwapNum(int c,int d){
            int temp = c;
             c=d;
             d=temp;

             System.out.println("value of a: "+c);
             System.out.println("value of b: "+d);

    }

    public static int Factorial(int n) {
        int fact=1;
        
        for (int i=1;i<=n;i++){
         fact= fact*i;
        }
        return fact;
        
    }
// binomial cefff c= n!/r!(n-r)!
public static int binCoeff(int n, int r) {
int n_fact=Factorial(n);
int r_fact= Factorial(r);
int nMr_fact= Factorial(n-r);

int BinCeoff= n_fact/(r_fact*nMr_fact);
    return BinCeoff;
}
    // public static void main(String[] args) {
        // Scanner sc= new Scanner(System.in);
        // int a=sc.nextInt();
        // int b= sc.nextInt();
        // // int sum= a+b;
        // int sum=CalculateSum(a, b);
        // System.out.println(sum);
        // // CalculateSum(a, b);
        // sc.close(); 

        // Scanner sc= new Scanner(System.in);
        // int c= sc.nextInt();
        // int d= sc.nextInt();
        // System.out.println("Initial value of c: "+c);
        // System.out.println("Initial value of d: "+d);
        // SwapNum(c,d);
        // sc.close();
        // printHelloWorld();

//        public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.print("Enter number: ");
//         int n= sc.nextInt();
//         System.out.println(Factorial(n));
//         System.out.println("Binomial coefficient is:"+ binCoeff(5, 2));
       
//        sc.close();

//     }
// }


// function overloading using different parameter in the functions having same name. The same name functions are different functions because of change in the parameters. It doesn't depend on return type i.e. only same type of function of same name wil be called as funtion overloading different return type is not considered to be func overloading.

public static int sum(int a, int b){
    return a+b;
}
public static int sum(int a, int b, int c){
    return a+b+c;
}

public static int subtract(int a, int b){
    return a-b;
}

public static float subtract(float a, float b){
    return a-b;
}
// public static void main(String[] args) {      
//     System.out.println( sum(3,5));
//     System.out.println( sum(3,5,2));
//     System.out.println( subtract(5,2));
//     System.out.println( subtract(5.5f, 2.2f));
// }
// }

// 
public static boolean isPrime(int n){
    if(n==2){
        return true;
    }
for (int i=2; i<=Math.sqrt(n);i++){
    if(n%i==0){
        return false;
    }
}
return true;
}

public static void Prange(int n){
   
for (int i=2;i<=n;i++){
    if(isPrime(i)){
        System.out.print(i+" ");
    }
}
}
public static void main(String[] args) {      
    // System.out.println(isPrime(10));
Prange(20);
   
}
}