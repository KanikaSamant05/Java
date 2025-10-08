
    import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class graphsalQs {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }
public static void createGraph(int flights[][],ArrayList<Edge> graph[]){
    for(int i=0; i<graph.length;i++){
        graph[i]= new ArrayList<>();
    }
    for(int i=0; i<flights.length;i++){
        int src= flights[i][0];
        int dest= flights[i][1];
        int wt= flights[i][2];
        Edge e= new Edge( src, dest, wt);
        graph[src].add(e);
    }
}
static class Info{
    int v;
    int cost;
    int stops;
    public Info(int v, int c, int s){
        this.v=v;
        this.cost=c;
        this.stops=s;
    }
}
public static int cheapestFlight(int n, int flights[][],int src, int dest, int k){
    @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[]= (ArrayList<Edge>[]) new ArrayList[n];
    createGraph(flights, graph);
    int dist[]= new int[n];
    for(int i=0;i<n;i++){
        if(i!=src){
            dist[i]= Integer.MAX_VALUE;
        }
    }
    Queue<Info> q= new LinkedList<>();
    q.add(new Info(src,0,0));
    while(!q.isEmpty()){
        Info curr=q.remove();
        if(curr.stops>k){
            break;
        }
        for(int i=0;i<graph[curr.v].size();i++){
            Edge e= graph[curr.v].get(i);
            int u=e.src;
            int v= e.dest;
            int wt= e.wt;
            // if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt<dist[v] && curr.stops<=k){
            // this is correct becoz in some graphs there are chances dist[u] will give wrong ans
        if(dist[u]!= Integer.MAX_VALUE && curr.cost+wt<dist[v] && curr.stops<=k){
                dist[v]= dist[u]+wt;
            q.add(new Info(v,dist[v],curr.stops+1));          
          }
        }
    }
    if(dist[dest]==Integer.MAX_VALUE){
        return -1;
    }else{
        return dist[dest];
    }
}

// qs. connect cities with minimium cost: we use Prims algo.
    static class Edge1 implements Comparable<Edge1>{
        int cost;
        int dest;
        public Edge1(int d, int c){
            this.dest=d;
            this.cost=c;
        }
        @Override 
        public int compareTo(Edge1 e2){
            // ascending
            return this.cost-e2.cost;
        }
    }
    public static int connectCities(int cities[][]){
        PriorityQueue<Edge1>pq= new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];
        pq.add(new Edge1(0,0));
        int finalCost=0;
        while(!pq.isEmpty()){
            Edge1 curr= pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest]=true;
                finalCost+=curr.cost;
                for(int i=0;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i]!=0){
                        pq.add(new Edge1(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    //flood fill algo.: to fill colors where value is 1and move to next box stop where value is 0
    // public void helper(int[][]image,int sr, int sc, int color,boolean vis[][], int orgCol){
    //     // base case
    //     if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||vis[sr][sc]||image[sr][sc]!=orgCol){
    //         return;
    //     }
    //     // left
    //     helper(image, sr, sc-1, color, vis, orgCol);
    //     // right
    //     helper(image, sr, sc+1, color, vis, orgCol);
    //     // up
    //     helper(image, sr-1, sc, color, vis, orgCol);
    //     // down
    //     helper(image, sr+1, sc, color, vis, orgCol);
    // }
    // public int[][] floodFill(int [][]image, int sr, int sc, int color){
    //     boolean vis[][]=new boolean[image.length][image[0].length];
    //     helper(image,sr,sc,color,vis,image[sr][sc]);
    //     return image;
    // } 


    public static void main(String[] args) {
        int n=4;
        int flights[][]= {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0, dst=3, k=1;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[]= (ArrayList<Edge>[]) new ArrayList[n];
        createGraph(flights, graph);
        // cheapestFlight(n, flights, src, dst, 1;)
        int ans= cheapestFlight(n, flights, src, dst, k);
        // System.out.println("cheapest PRice: "+ans);

        // 
        int cities[][]={{0,1,2,3,4},
                         {1,0,5,0,7},
                        {2,5,0,6,0},
                        {3,0,6,0,0},
                        {4,7,0,0,0}};
    System.out.println(connectCities(cities));
    

}
}


