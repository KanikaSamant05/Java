public class sorting {
    // public static void bubbleSort(int arr[]) {
    //     for(int turn=0;turn<arr.length-1;turn++){
    //         for(int j=0;j<arr.length-1-turn;j++){
    //             if(arr[j]>arr[j+1]){
    //                 int temp=arr[j];
    //                 arr[j]=arr[j+1];
    //                 arr[j+1]=temp;
    //             }
    //         }
    //     }
    // }

// descending
// for(int turn=0;turn<arr.length;turn++){
//           for(int j=0;j<arr.length-1-turn;j++){
//               if(arr[j]<arr[j+1]){
//                   int temp=arr[j];
//                   arr[j]=arr[j+1];
//                   arr[j+1]=temp;
//               }
//           }
//       }
//   }

    // // selection sort
    // public static void SelectionSort(int arr[]) {
    //     for(int i=0;i<arr.length-1;i++){
    //         int minPos=i;
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[minPos]>arr[j]){
    //                 minPos=j;
    //             }
    //         }
    //         int temp=arr[minPos];
    //         arr[minPos]=arr[i];
    //         arr[i]=temp;
    //     }
        
    // }
    
    // descending: 
    //     for(int i=0;i<arr.length;i++){
    //         int maxPos=i;
    //         for(int j=i+1;j<arr.length;j++){
    //             if(arr[j]>arr[maxPos]){
    //                 maxPos=j;
    //             }
    //         }
    //         int temp=arr[i];
    //         arr[i]=arr[maxPos];
    //         arr[maxPos]=temp;
    //     }       
    // }

    // insertion sort
    // public static void insertionSort(int arr[]) {
    //     for(int i=1;i<arr.length;i++){
    //         int temp=arr[i];
    //         int previous_index=i-1;
    //         while(previous_index>=0 && arr[previous_index]>temp){
    //             arr[previous_index+1]=arr[previous_index];
    //             previous_index--;
    //         }
    //         arr[previous_index+1]=temp;
    //     }       
    // }

    // descending:
//     for(int i=1;i<arr.length;i++){
//         int temp=arr[i];
//         int previous_index=i-1;
//         while(previous_index>=0 && arr[previous_index]<temp){
//             arr[previous_index+1]=arr[previous_index];
//             previous_index--;
//         }
//         arr[previous_index+1]=temp;
//     }       
// }

//counting sort
public static void countingSort(int arr2[]) {
     int max=0;
     for(int i=0;i<arr2.length;i++){
        if(arr2[i]>max){
            max= arr2[i];
        }
     }
     int[] freq= new int[max+1];
     for(int i=0;i<arr2.length;i++){
        freq[arr2[i]]+=1;
     }
     for(int i=max;i>=0;i--){
        while(freq[i]>0){
            System.out.print(i);
            System.out.print(" ");
            freq[i]-=1;
        }
     }
     
    
}

public static void printArr(int arr[]) {
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+ " ");
    }
}


// inversion count

    public static void main(String[] args) {
        // int arr[]={5,4,3,2,1,10};
        int arr2[]={3,6,2,1,8,7,4,5,3,1};
        // bubbleSort(arr);
        // printArr(arr);
         // or
        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+ " ");
        // }
       
// System.out.print("Selection sort: ");
// SelectionSort(arr);
// insertionSort(arr);
countingSort(arr2);
// printArr(arr);
    }
}






    

