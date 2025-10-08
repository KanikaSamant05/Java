public class DividenConquer {
    // MERGE SORT
//     public static void prtArr(int arr[]) {
//         for(int i=0;i<arr.length;i++){
//         System.out.print(arr[i]+" ");
//     }
//     System.out.println();
// }
// public static void mergeSort(int arr[],int si, int ei) {
//     // base case
//     if(si>=ei){
//         return;
//     }
//     // kaam
//     int mid=si+(ei-si)/2;
//     // left part
//     mergeSort(arr, si, mid); 
//     // right part
//     mergeSort(arr, mid+1, ei); 
//     merge(arr,si,mid,ei); 
// }
// public static void merge(int arr[],int si, int mid, int ei){
// // left indexes(0,3)i.e. total elements=4; right(4,6)= 3 elements so toal need of space =7 i.e.temporary index(total space needed)=(6-0)+1=7 
//     int temp[]=new int[ei-si+1];
//     // iterator for left part
//     int i=si;
//     // iterator for right part
//     int j=mid+1;
//     // iterator for temp array
//     int k=0;
//     while(i<=mid && j<=ei){
//         if(arr[i]<arr[j]){
//             temp[k]=arr[i];
//             i++; k++;
//         }else{
//             temp[k]=arr[j];
//             j++; k++;
//         }
//     }
//     // left aprt
//     while(i<=mid){
//         temp[k++]=arr[i++];
//     }
//     // right part
//     while(j<=ei){
//         temp[k++]=arr[j++];
//     }
//     // copy temp to original arr
//     for(k=0,i=si;k<temp.length;k++,i++){
//         arr[i]=temp[k];
//     }
// }




// QUICK SORT
 public static void prtArr(int arr[]) {
        for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
}
public static void quickSort(int arr[],int si, int ei){
if(si>=ei){
    return;
}    // last element
int pdx=partition(arr,si, ei);
// left part
quickSort(arr, si, pdx-1);
// left part
quickSort(arr, pdx+1, ei);
}
public static int partition(int arr[], int si, int ei) {
    int pivot= arr[ei];
    // to make place for element lesser than pivot
    int i=si-1; 
    // to check whether the element is less than pivot and swapping them 
    for(int j=si; j<ei;j++){
        if(arr[j]<=pivot){
            i++;
            // swap
            int temp= arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }
     i++;
            // to make sure pivot is in the right pos.
            int temp= pivot;
            // here pivot = arr[i] is not correct since it si a variable and we need to return the index and its value and java follows call by refernce, we will have to swap it through index
            arr[ei]=arr[i];
            arr[i]=temp;
            return i;
}

// find the majority element
public static int majorityElement(int[] nums) {
    int winner= nums[0], lead=1;
    for(int i=1;i<nums.length;i++){
        if(nums[i]==winner){
            lead++;
        }else if(lead>0){
            lead--;
        }else{
            winner= nums[i];
            lead=1;
        }
    }
    return winner;
}
    public static void main(String args[]) {
        // int arr[]={6,3,9,10,5,2,8};
        // mergeSort(arr,0,arr.length-1);
        // quickSort(arr, 0, arr.length-1);
        // prtArr(arr);

        int nums[]={10,20,30,20,30,30,30,30};
        System.out.println(majorityElement(nums));
    
}
}

