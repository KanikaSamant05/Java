import java.util.*;
public class greedyQs {
    static class Job{
        int deadline;
        int profit;
        int id; 
    
    public Job(int i, int d, int p){
        id=i;
        deadline=d;
        profit=p;

    }
}
     public static void main(String[] args) {
        int jobsInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs= new ArrayList<>();
        for(int i=0; i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }
        // descending
        Collections.sort(jobs,(obj1, obj2)->obj2.profit-obj1.profit);
        ArrayList<Integer> seq= new ArrayList<>();
        int time=0; for(int i=0; i<jobs.size();i++){
            Job curr= jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        // System.out.println("Max jobs= "+seq.size());
        for(int i=0; i<seq.size();i++){
            // System.out.println(seq.get(i));
        } 

        // choclate problem
        int n=4, m=6;
        // n-1
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());
         int h=0, v=0;
         int hp=1;
         int vp=1;
         int cost=0;
         while(h<costHor.length && v<costVer.length){
            if(costVer[v]<= costHor[h]){
                cost+= (costHor[h]*vp);
                hp++;
                h++;
            }else{
                cost+= (costVer[v]*hp);
                vp++;
                v++;
            }
         }
         while(h<costHor.length){
            cost+=(costHor[h]*vp);
            hp++;
            h++;
         }
           while(v<costVer.length){
            cost+=(costVer[v]*hp);
            vp++;
            v++;
           }
           System.out.println("min cost of cuts=  "+cost);
} 
} 