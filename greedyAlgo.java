import java.util.*;
public class greedyAlgo {

    public static void main(String[] args) {
        // these are sorted
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        // if not sorted 2-D array is created which contains 3 columns where 1st column 0th store index value then start value and last column 2th contains end value.
        int activities[][]= new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }        
        // lambda function-> gives the logic of sorting(here o[2] is guiding lambda funcn to sort array on the basis of 2nd column i.e. end time in ascending order is sorted ), it is a short form 
        Arrays.sort(activities, Comparator.comparingDouble(o->o[2]));
        
        // end time basis sorted
        int maxAct=0;
        ArrayList<Integer> ans= new ArrayList<>();
        // 1st activity(act)
        maxAct=1;
        // for unsorted we use matrix
        // ans.add(activities[0][0]);

        ans.add(0);
        // int lastEnd= activities[0][2];
        
         int lastEnd=end[0];
        for(int i=0;i<end.length;i++){
            // if(activities[i][1]>=lastEnd ){
            //      maxAct++;
            //     ans.add(activities[i][0]);
            //     lastEnd= activities[i][2];
            // }

            if(start[i]>=lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd= end[i];
            }          
        }
        System.out.println("max activities: "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ ans.get(i)+" ");
        }
        System.out.println();

        //  // FRACTIONAL KNAPSACK
        int val[]= {60,100,120};
        int wt[]={10,20,30};
        int W= 50;
        // sorting ratio
        double ratio[][]=new double[val.length][2];
        // 0th col.= idx; 1st col= ratio
        for(int i=0;i<val.length;i++){
            ratio[1][0]=i;
            ratio[i][1]= val[i]/(double)wt[i];

        }
        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        int capacity= W;
        int finVal=0;
        // descending sorted  
        for(int i= ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            // full item include
            if(capacity>=wt[idx]){
                finVal+=val[idx];
                capacity-=wt[idx];
                // fractional add
            }else{
                finVal+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        // System.out.println("final value: "+ finVal);

        // Minimum absolute difference of pairs
        int A[]={1,2,3};
        int B[]={2,1,3};
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff=0;
        for(int i=0;i<A.length;i++){
            minDiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println("Min. absolute difference: "+minDiff);

// total number of chain pair
int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
    int chainLen=1;
    int chainEnd=pairs[0][1];
    for(int i=1;i<pairs.length;i++){
        if(pairs[i][0]>chainEnd){
            chainLen++;
            chainEnd=pairs[i][1];
        }
    }
// System.out.println("max length=: "+ chainLen);

// counting coins
Integer coins[]={1,2,5,10,20,50,100,500,2000};
Arrays.sort(coins, Comparator.reverseOrder());
int countOfcoins=0;
int amount=590;
ArrayList<Integer> answer= new ArrayList<>();
for(int i=0;i<coins.length;i++){
    if(coins[i]<=amount){
        while(coins[i]<=amount){
            countOfcoins++;
            answer.add(coins[i]);
            amount-=coins[i];
        }
    }
}
System.out.println("total minimum coins used= "+countOfcoins);
for(int i=0;i<answer.size();i++){
    System.out.print(ans.get(i)+" ");
}
}
}
