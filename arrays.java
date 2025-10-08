import java.util.*;
public class arrays {

    // arrays as argument java always takes the copy of variable i.e. rference
    // public static void update(int marks[]) {
    //     for(int i=0;i<marks.length;i++){
    //         marks[i]=marks[i]+1;
    //     }    }

// largest no. and smallest no.
// public static int Largest(int numbers[]){
//     int largest=Integer.MIN_VALUE;
//     // or int largest=0;
//     int smallest=Integer.MAX_VALUE;
//     for(int i=0;i<numbers.length;i++){
//         if(largest<numbers[i]){
//             largest=numbers[i];
//         }
//         if(smallest>numbers[i]){
//            smallest= numbers[i];
//         }
//     }
// System.out.println("Smallest number is: "+smallest);
//     return largest;

// }

// max subarray sum
// public static void maxSubarraySum(int nums[]) {
//     // total subarrays formula=n(n+1)/2
//     int currSum=0;
//     int maxSum=Integer.MIN_VALUE;
//     for(int i=0;i<nums.length;i++){
//         int start=i;
//         for(int j=i;j<nums.length;j++){
//             int end=j;
//             currSum=0;
//             for(int k=start;k<=end;k++){
//                 currSum+=nums[k];
//             }
//             System.out.println(currSum);
//             if(maxSum<currSum){
//             maxSum=currSum;
//         }
//         }
//     }
//     System.out.println("max sum: "+maxSum);
// }

// prefix maxsubarraysum

// public static void prefixSubarraySum(int nums[]) {
//     int currSum=0;
//     int maxSum= Integer.MIN_VALUE;
//     int prefix[]=new int[nums.length];
//     prefix[0]=nums[0];
// // calculate prefix array
// for(int i=1;i<prefix.length;i++){
//     prefix[i]=prefix[i-1]+nums[i];
// };

// for(int i=0;i<nums.length;i++){
//             int start=i;
//             for(int j=i;j<nums.length;j++){
//                 int end=j;
//                 currSum= start==0? prefix[end]: prefix[end]-prefix[start-1];
//                 if(maxSum<currSum){
//                     maxSum=currSum;
//                 }
//             }
//         }
//         System.out.println("maxSum= "+maxSum);
//     }


// kadane's algorithm: considers negatives as 0 and then calculating sums of all +ves  or large +ve and small -ve number and simultaneously saving and calculating the max sum.
// public static void KadanesAlgortihm(int nums[]){;
// int ms=Integer.MIN_VALUE;
// int cs=0;
// for(int i=0;i<nums.length;i++){
//     cs=cs+nums[i];
//     if(cs<0){
//         cs=0;
//     }
//     ms=Math.max(cs,ms);
//     }
//     System.out.println("our max subarray sum= "+ms);
// }

// trapping rainwater calculate: calculated only when there ARE 3 bars where middle one should be smaller otherwise it will spill 
// for calcualating rainwater : for a particular bar find max left and max right ht where considered width is 1 then find water level=mininum of max left and max right(min(max left,max right)) then volume (trapped water) = (water level-ht)*width
public static int trappedRainwater(int height[]) {
    // calculate left max boundary
    int n=height.length;
    int leftMax[]=new int[n];
    leftMax[0]=height[0];
    for(int i=1;i<n;i++){
        leftMax[i]=Math.max(height[i],leftMax[i-1]);
    }
    // calculate right max boundary
    int rightMax[]=new int[n];
    rightMax[n-1]=height[n-1];
    for(int i=n-2;i>=0;i--){
      rightMax[i]=Math.max(height[i], rightMax[i+1]);
    }
   int trappedWater=0;
  // loop
  for(int i=0;i<n;i++){
 // water level wl= min(left max-right max boundary)
    int wl=Math.min(leftMax[i],rightMax[i]); 
// trapped water= wl-height
    trappedWater += wl-height[i];
  }
  return trappedWater;
}

// buy and sell stocks
public static int buyAndSellstocks(int prices[]) {
    int buyPrice=Integer.MAX_VALUE;
    int maxProfit=0;
    for(int i=0;i<prices.length;i++){
        if(buyPrice<prices[i]){
            int profit= prices[i]-buyPrice;
            maxProfit=Math.max(maxProfit, profit);
        }else{
            buyPrice=prices[i];
        }
    } return maxProfit;
}

    public static void main(String[] args) {
    //    int arr[]={1,2,5};
    // String arr2[]={"hi ","bye ","go "};
    //    char arr3[]={'j','h','o'};
    //    int marks[]=new int[5];

// System.out.println(arr);
// System.out.println(arr3);
// System.out.println(arr2);

// Scanner sc=new Scanner(System.in);
// System.out.print("Marks of subjects are as follows: ");
// marks[0]=sc.nextInt();
// marks[1]=sc.nextInt();
// marks[2]=sc.nextInt();
// System.out.println("Physics marks: "+marks[0]);
// System.out.println("Maths marks: "+marks[1]);
// System.out.println("English marks: "+marks[2]);
// marks[2]=90;
// System.out.println("Updated marks in maths: "+marks[2]);

// int percentage=((marks[0]+marks[1]+marks[2])/3);
// System.out.println("percentage:"+percentage+"%");
// System.out.println(marks.length);
// sc.close();
    
// 
// int marks[]={97,98,99};
// update(marks);
// for(int i=0;i<marks.length;i++){
// System.out.println(marks[i]+" ");
// }

// int numbers[]={3,8,7,6,9,89,2};
// System.out.println("Largest numbr is "+ Largest(numbers));
// int nums[]={2,4,6,8,10};
// maxSubarraySum(nums);

// int nums[]={1,-2,6,-1,3};
// prefixSubarraySum(nums);
// int nums[]={-2,-3,4,-1,-2,1,5,-3};
// KadanesAlgortihm(nums);

// int height[]={4,2,0,6,3,2,5};
// System.out.println(trappedRainwater(height));

int prices[]={7,1,5,3,6,4};
    System.out.println(buyAndSellstocks(prices));
}
}



 

