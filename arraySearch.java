public class arraySearch{
    // public static int LinearSearch(int numbers[], int key) {
    //     for(int i=0;i<numbers.length;i++){
    //         if(numbers[i]==key){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // binary search always works in a sorted array
    public static int binarySearch(int number[],int key){
    int start=0, end=number.length-1;
    while(start<=end){
        int mid=(start+end)/2;
        if(number[mid]==key){      
            return mid;
        }
        if(number[mid]<key){
            start=mid+1;
        }else{
            end=mid-1;
        }
    }
    return -1;
    }

    // reverse of an array
public static void reverse(int numberss[]) {
    int first=0, last=numberss.length-1;
    while(first<last){
        int temp= numberss[last];
        numberss[last]=numberss[first];
        numberss[first]=temp;
        first++;
        last--;
    }
}

// pairs in array
public static void printPairs(int num[]) {
    // formula to find total pair=n(n-1)/2
    int totalPair=0;
    for(int i=0;i<num.length;i++){
        int curr=num[i];       
        for(int j=i+1;j<num.length;j++){
            System.out.print("{"+curr+","+num[i]+"}");
            totalPair++;
        }
        System.err.println();
    }
    System.out.println("total pairs= "+totalPair);
}

// print subarrays
public static void printsubArray(int nums[]) {
    // total subarrays formula=n(n+1)/2
    int tp=0;
    for(int i=0;i<nums.length;i++){
        int start=i;
        for(int j=i;j<nums.length;j++){
            int end=j;
            for(int k=start;k<=end;k++){
                System.out.print(nums[k]+" ");
            }
            tp++;
            System.out.println();
        }
        System.out.println();
    }
    System.out.println("total pair= "+tp);
}
    public static void main(String[] args) {
        // int numbers[]={2,4,5,7,8,10,90,78};
        // int key=10;
        // int index=LinearSearch(numbers, key);
        //     if(index==-1){
        //         System.out.println("Not found");
        //     }else{
        //         System.out.println("index number is: "+index);
        //     }
        // int number[]={2,4,6,8,9,89};
        // int key= 89;
        // System.out.println("index for key using binary search is:"+ binarySearch(number, key));

        // int numberss[]={2,4,5,34};
        // reverse(numberss);
        // for(int i=0;i<numberss.length;i++){
        //     System.out.print(numberss[i]+" ");
        // }

        int num[]={2,4,6,8};
        printPairs(num);

        int nums[]={2,3,4,5,6};
        printsubArray(nums);
        }
    }
