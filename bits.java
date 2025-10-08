public class bits {

    // odd or even in bits
// in bits if LSB(rightmost) is 0 its even else its odd. For this consider a digit as 1(bitMask) and do & op. it with the given no. then check its LSB
    // public static void oddOrEven(int n){
    // int bitMask=1;
    // if((n & bitMask)==0){
    //     System.out.println("even");
    //  }
    //  else{
    //     System.out.println("odd");
    //  }
    // }

    // get ith bit 
    // check which bit is in the ith pos. in bits ith pos starts from right to left. Here consider the no. 1<<i pos so that every pos other than ith becomes 0 and then & it to the given no. if ith is 0 then its 0 if its 1 then ith pos is 1.
    // public static int getIthbit(int n, int i){
    //     int bitMask=1<<i;
    //     if((n & bitMask) == 0){
    //         return 0;
    //     }else{
    //         return 1;
        // }
 // swap no. without using 3rd variable
        public static void swap(int x, int y) {
           x=x^y;
           y=y^x;
           x=x^y;
           System.out.println("new value of x: "+x);
           System.out.println("new value of y: "+y);            
        }

        // convert uppercase to lowercase
        public static void tolowerCase() {
            for(char ch='A';ch<='Z';ch++){
                System.out.println((char)(ch|' '));
                // or ASCII VALUE IS THE OUTPUT HERE 
                System.out.println((ch|' '));
            }
        }

        // add1 
        public static void add1() {
            int num;
            num=6;
            System.out.println(num+"+"+1+"="+(-~num));
            num=-4;
            System.out.println(num+"+"+1+"="+(-~num));
            num=0;
            System.out.println(num+"+"+1+"="+(-~num));
        }
    
    
        public static void main(String[] args) {
// AND operation where 1,1=1; 0,0=1 and 1,0=0 convert 5 and 6 into binary no. then check 
        // System.out.println(5 & 6);

// OR where 1,0 =1 ; 0,0=1; 1,1=1; 0,1=1
        // System.out.println(5 | 6);

// XOR^ where 1,0=1; 0,0=0; 1,1=0
// System.out.println(5 ^ 6);
//  binary 1's complement ~ 

// where 0=1 and 1=0; here first convert no into binary no. and add 0 to the left as per your choice mostly upto 8 bits and then find its complement then add 1 and find the no. if complement of MSB( lest most digit) is 0 then no is +ve and if its 1 then no. is -ve {LSB is the right most digit of a binary no.} eg. 5(binary is 101 or 00000101 now its complement is 11111010 and now 1's complement of the complement of 5 is found i.e. 00000101+1 = 00000110 since 1+1=2 in binary 2= 10 so 10 will be the last 2 digit and then final 2's complement after add is 00000110 since 110=6 in decimal and initailly the MSB complement of 5 is -ve output is -6 )
// System.out.println(~5);

// binary left shift <<
// where a<<b convert a to binary no. and then remove digits acc to b from the left and shift no. to the left and add 0 to free space and convert the final no. into decimal. TO check whther no. is correct or not there is formula i.e. a*2to the power b, this should match to the output.
// System.out.println(5<<2);

// binary right shift>>
// where a>>b convert a to binary no. and then remove digits acc to b from the right and shift no. to the right and add 0 to free space and convert the final no. into decimal. TO check whether no. is correct or not there is formula i.e. a/2 to the power b, this should match to the output.
// System.out.println(5>>2);

// odd or even
// oddOrEven(8);

// get ith bit
// System.out.println(getIthbit(10, 2));

// swap no. without using 3rd variable
// swap(5, 9);
// tolowerCase();
add1();
    }   
}


