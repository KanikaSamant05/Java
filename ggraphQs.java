import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class ggraphQs {  
     static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int  w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }     
    }
    static void createGraph(ArrayList<Edge> graph1[]){
    for(int i=0; i<graph1.length;i++){
            graph1[i]= new ArrayList<>();
        }
        // 0 vertex
        graph1[0].add(new Edge(0,1,1));
        graph1[0].add(new Edge(0,2,1));

        // 1 vertex
        graph1[1].add(new Edge(1,0,1));
        graph1[1].add(new Edge(1,3,1));
        // 2 vertex
        graph1[2].add(new Edge(2,1,1));
        graph1[2].add(new Edge(2,4,1));
        // 3 vertex
        graph1[3].add(new Edge(3,1,1));
        graph1[3].add(new Edge(3,4,1));
        graph1[3].add(new Edge(3,5,1));

        // 4 vertex
        graph1[4].add(new Edge(4,2,1));
        graph1[4].add(new Edge(4,3,1));
        graph1[4].add(new Edge(4,5,1));

        // 5 vertex
        graph1[5].add(new Edge(5,3,1));
        graph1[5].add(new Edge(5,4,1));
        graph1[5].add(new Edge(5,6,1));

        graph1[6].add(new Edge(6,5,1));

    }

    //  Breadth first search : it checks all the neighbour values targeting one vertex , then move to the next 
    public static void bfs(ArrayList<Edge> graph1[]){
        // Queue is used to store the value once it is visited in a graph to make sure if are visiting a certain vertex again, it won't print the value again(becoz graph is mostly cyclic, there are chances we might visit the vertex repeatedly.)
        Queue<Integer> q= new LinkedList<>();
        boolean vis[]= new boolean[graph1.length];
    //    from source 0( i.e. 0 vertex) 
        q.add(0);
        while(!q.isEmpty()){
            int curr= q.remove();
            // if not visited then only print 
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0; i<graph1[curr].size();i++){
                    Edge e= graph1[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // DFS(depth first search): keep going to the first neighbour uses recusion stores in stack affter visiting removes from the stack if it is already visited
    public static void dfs(ArrayList<Edge>[] graph1, int curr,boolean vis[]){
        // initial vertex : startiing point
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0; i<graph1[curr].size();i++){
            // finds value of edge
            Edge e= graph1[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph1, e.dest, vis);
            }
        }
    }

    // bipartite graph: when there are two graph (U and V)and we need to make sure that their edges connect to each other where either U belongs to V or V belongs to U and there is no edge which will connect vertices of same set
// here graph coloring is used where -1 is no color; 0- yellow, 1-blue (differently coloured neighbour means there are no same vertex in same set i.e. partite ; if same colour of neghbours non- partite; if no color then assign color)
        static void createGraph1(ArrayList<Edge> graph2[]){
        for( int i=0; i<graph2.length;i++){      
            graph2[i]= new ArrayList<>();
        }
        graph2[0].add(new Edge(0, 1,1));
        graph2[0].add(new Edge(0, 2,1));

        graph2[1].add(new Edge(1, 0,1));
        graph2[1].add(new Edge(1, 3,1));

        graph2[2].add(new Edge(2, 0,1));
        graph2[2].add(new Edge(2, 4,1));

        graph2[3].add(new Edge(3, 1,1));
        // graph2[3].add(new Edge(3, 4,1));

        graph2[4].add(new Edge(4, 2,1));
        // graph2[4].add(new Edge(4, 3,1));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph2){
        // to assign colors
        int col[]= new int[graph2.length];
        for(int i=0;i<col.length;i++){
            // no color
          col[i]=-1;  
        }
        Queue<Integer>q= new LinkedList<>();
        for(int i=0; i<graph2.length;i++){
            if(col[i]==-1){
            // BFS
            q.add(i);
            // yellow
            col[i]=0;
            while(!q.isEmpty()){
                int curr= q.remove();
                for(int j=0; j<graph2[curr].size();j++){
                    // e.dest
                    Edge e= graph2[curr].get(j);
                    if(col[e.dest]==-1){
                        int nextCol= col[curr]==0?1:0;
                        col[e.dest]= nextCol;
                    q.add(e.dest);                   
                 }else if(col[e.dest]==col[curr]){
                    return false;
                    // not bipartite
                }
            }
        }
    }
}
        return true;
}
         


  // DIJKSTRA'S ALGORITHM: CALCULATE THE SHORTEST PATH (BY CALCULATING DISTANCE THROUGH WEIGHT) FROM SOURCE TO DESTINATION
//   T.C= V+E log V using PRiorityQueue due to internally sorting is done already but without PQ it is O(V^2)
  // Initially consider each dist. to be infinity, FORMULA DIST[V]= DIST[U]+ WT[U,V] IF DIST[u]+wt(u,v)<dist[v] i.e. dist[v]<initial dist. ,then UPDATE DIST. TO THE SMALLER DISTANCE 
     static void createGraph2(ArrayList<Edge> graph3[]){
        for( int i=0; i<graph3.length;i++){      
            graph3[i]= new ArrayList<>();
        }
        graph3[0].add(new Edge(0, 1,2));
        graph3[0].add(new Edge(0, 2,4));

        graph3[1].add(new Edge(1, 3,7));
        graph3[1].add(new Edge(1, 2,1));

        graph3[2].add(new Edge(2, 4,3));

        graph3[3].add(new Edge(3, 5,1));

        graph3[4].add(new Edge(4, 3,2));
        graph3[4].add(new Edge(4, 5,5));
    }
    static class  Pair implements Comparable<Pair> {
    //    Node n 
        int n;
        int path;
        public Pair(int n, int path){
            this.n=n;
            this.path= path;
        }

        @Override 
        public int compareTo(Pair p2){
            // path based sorting for pairs
            return this.path-p2.path;
        }
        
    }
    public static void dijkstra(ArrayList<Edge> graph3[], int src){
    //    dist[i]->src to i
        int dist[]= new int[graph3.length];
        for(int i=0; i<graph3.length;i++){
            if(i!= src){
                // infinity
                dist[i]= Integer.MAX_VALUE;
            }
        }
        boolean vis[]= new boolean[graph3.length];
        
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(src,0));
        // loop
        while(!pq.isEmpty()){
            Pair curr= pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]= true;
                // neighbours
                for(int i=0; i<graph3[curr.n].size();i++){
                    Edge e= graph3[curr.n].get(i);
                    int u= e.src;
                    int v= e.dest;
                    int wt= e.wt;
                if(dist[u]+wt<dist[v]){
                    dist[v]= dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }

                }
            }
        }
        // print all source to vertices shortest dist.
        for(int i=0; i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }

    // BELLMAN FORD ALGORITHM: shortest path from source to all vertices for negative and +ve edges(wt) both unlike Dijkstra's who only work with +ve edges (wt)
    // Bellman is  a DP( dyna,ic programming based and takes more time) while dijkistra's is greedy based and akes less time but for +ve edges
//  performs operation V-1 times becoz there are chances we get the smaller dist. for all vertex in the last op. (V-1)and not initially { for all edges (u,v) then follow relaxation step i.e. if DIST[u]+wt(u,v)<DIST[v] then upate DIST[v]= DIST[u]+wt(u,v)}
// initially each dist from src is infinity and dist. from src to src=0 then calc. dist from eaxh vertices and check smaller possible dist to each vertices and small dist is preferred
// bellman doesn't work for negative weighted cycle sincethere are chances that we will travel again in same node b/w path for more shorter dist (eg. 0->1= 1, 0->1->2->3->4->1 = -7) which is not acceptable 
    static void createGraph3(ArrayList<Edge> graph4[]){
        for(int i=0; i<graph4.length;i++){
            graph4[i]= new ArrayList<>();
        }
        graph4[0].add(new Edge(0, 1,2));
        graph4[0].add(new Edge(0, 2,4));

        graph4[1].add(new Edge(1, 2,-4));

        graph4[2].add(new Edge(2, 3,2));

        graph4[3].add(new Edge(3, 4,4));

        graph4[4].add(new Edge(4, 1,-1));    
    }
    public static void bellmanFord(ArrayList<Edge> graph4[] , int src){
        int dist[]= new int[graph4.length];
        for(int i=0; i<dist.length;i++){
            if(i!=src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        int V= graph4.length;
        // T.C: O(V*E)
        // algorithm v= O(V)
        for(int i=0; i<V-1;i++){
            // edges O(E)
            for(int j=0; j<graph4.length;j++){
                for(int k=0;k<graph4[j].size();k++){
                    Edge e= graph4[j].get(k);
                // u,v,wtu= e.src;
                    int u= e.src;
                    int v= e.dest;
                    int wt = e.wt;
                    // relaxation i.e. formula
                    if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt <dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        // print
        for(int i=0; i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    

    // other simple method for bellmam
    static void createGraphOther(ArrayList<Edge> graphOth){
        graphOth.add(new Edge(0, 1,2));
        graphOth.add(new Edge(0, 2,4));

        graphOth.add(new Edge(1, 2,-4));

        graphOth.add(new Edge(2, 3,2));

        graphOth.add(new Edge(3, 4,4));

        graphOth.add(new Edge(4, 1,-1));    
    }
    public static void bellmanFordOther(ArrayList<Edge> graphOth , int src, int V){
        int dist[]= new int[V];
        for(int i=0; i<dist.length;i++){
            if(i!=src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        // T.C: O(V*E)
        // algorithm v= O(V)
        for(int i=0; i<V-1;i++){
            // edges O(E)
            for(int j=0; j<graphOth.size();j++){
                    Edge e= graphOth.get(j);
                // u,v,wtu= e.src;
                    int u= e.src;
                    int v= e.dest;
                    int wt = e.wt;
                    // relaxation i.e. formula
                    if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt <dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        // print
        for(int i=0; i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String args[]) {
          // BFS
    //     1----3        
    //     /    |\
    //    0     | 5--6
    //    \     | /
    //     2----4
        // int V2=7;
       
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph1[] = (ArrayList<Edge>[]) new ArrayList[V2];
        // createGraph(graph1);
        // bfs(graph1);
        // dfs(graph1, 0, new boolean[V2]);


// is bipartite
    //      0------2
    //      /     /
    //     /     /
    //    1     4
    //    \    /
    //     \  /
    //       3

        // int V3= 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph2[] = (ArrayList<Edge>[]) new ArrayList[V3];
        // createGraph1(graph2);
        // false output
        // System.out.println(isBipartite(graph2));

        // DJKISTRA'S ALGORITHM
        // @SuppressWarnings("unchecked")
        // int V4=6;
        // ArrayList<Edge> graph3[]= (ArrayList<Edge>[]) new ArrayList[V4];
        // createGraph2(graph3);
        // int src=0;
        // dijkstra(graph3, src);


        // bellman
        @SuppressWarnings("unchecked")
        int V5=5;
        ArrayList<Edge> graph4[]= (ArrayList<Edge>[]) new ArrayList[V5];
        // createGraph3(graph4);
        // bellmanFord(graph4, 0);

        // other simple bellman method
          @SuppressWarnings("unchecked")
        int Voth=5;
        ArrayList<Edge> graphOth= new ArrayList<>();
        createGraphOther(graphOth);
    bellmanFordOther(graphOth,0,Voth);

}
}
