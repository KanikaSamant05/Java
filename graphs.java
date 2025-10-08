import java.util.*;
// GRAPHS: are those data structures that is used to form a network of nodes i.e. connects various vertex (here nodes are known as vertex) to each other and the linking medium (or the line) is known as edges.
// EDGES TYPES: 1. Un-directional or bi deirectional (undirected graph) (where we can travel to and forth i.e. in both directions) 2. uni-directional (Directed graph): we can travel in only one direction (1 way path). If the wdge has some weight i.e. has any value b/w 2 vertex known as weighted graph (csn be -ve and +ve valuea); Unweighted graph: edges who doesn't has any value 
// Storing a graph: Strucute represent- 1. adjacency list, adjacency matrix, edge list, 2D matrix(Implicit graph): list all possible connections of each vertex. It forms list of list(i.e. a list contains sub lists). In code it is formed in ArrayList<ArrayList>,Array<ArrayList>, hashmap<int, list> where vertex is key(int)and list is value.
// Adjacency matrix: in the form of matrix graph is represented , increases T.C; edgelist : paths are determined with the help of edges{source, destination, edge};Implicit graph: here matrix is given and we imagine a graph throgh the matrix (Adjacent  list is most prefeered due to less T.C)
public class graphs {
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

    static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0; i<graph.length;i++){
        graph[i]= new ArrayList<>();
        }
        // 0 vertex
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        // 1 vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        // 2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,4,1));
        // 3 vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        // 4 vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        // 5 vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }
// BFS FOR CONNECTED COMPONENT: for this we use helper funcn BFSutil()
        public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]= new boolean[graph.length];
        for(int i=0; i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
        }
        public static void bfsUtil(ArrayList<Edge> graph[], boolean vis[]){
        // Queue is used to store the value once it is visited in a graph to make sure if are visiting a certain vertex again, it won't print the value again(becoz graph is mostly cyclic, there are chances we might visit the vertex repeatedly.)
        Queue<Integer> q= new LinkedList<>();
    //    from source 0( i.e. 0 vertex) 
        q.add(0);
        while(!q.isEmpty()){
            int curr= q.remove();
            // if not visited then only print 
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0; i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    // Connected components for DFS
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        for(int i=0; i<graph.length;i++){
            dfsUtil(graph, i, vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr,boolean vis[]){
        // initial vertex : startiing point
        // o(V+E) T.C vertex and edge
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0; i<graph[curr].size();i++){
            // finds value of edge
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // Cycle detection in undirected graph(DFS):DFS is more reliable due to less memory consumption as compared to BFS, but BFS can also be used
    static void createGraphs(ArrayList<Edge> graph1[]){
        for(int i=0;i<graph1.length;i++){
            graph1[i]= new ArrayList<>();
        }
        graph1[0].add(new Edge(0, 1,1));
        graph1[0].add(new Edge(0, 2,1));
        graph1[0].add(new Edge(0, 3,1));

        graph1[1].add(new Edge(1, 0,1));
        graph1[1].add(new Edge(1, 2,1));

        graph1[2].add(new Edge(2, 0,1));
        graph1[2].add(new Edge(2, 1,1));

        graph1[3].add(new Edge(3, 0,1));
        graph1[3].add(new Edge(3, 4,1));

        graph1[4].add(new Edge(4, 3,1));
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph1){
        boolean vis[]= new boolean[graph1.length];
        for(int i=0;i<graph1.length;i++){
            if(!vis[i]){
              if(detectCycleUtil(graph1, vis, i,-1)){
                return true;
              }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph1, boolean vis[], int curr, int par){
        vis[curr]= true;
        for(int i=0; i<graph1[curr].size();i++){
            Edge e= graph1[curr].get(i);
            // case3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph1, vis, e.dest, curr)){
                   return true;
                }
            }
            // case2 : if visited and is parent then do nothing -> continue
            // case1: if already true
            else if(vis[e.dest] && e.dest!=par){
                return true;
            }
        }
          return false;
    }

// // CYCLE DETECTEION: DIRECTED graph: DFS T.C: O(V+E)
        static void createGraphsD(ArrayList<Edge> graph2[]){
        for(int i=0;i<graph2.length;i++){
        graph2[i]= new ArrayList<>();
        }
        // TRUE OUTPUT
        // graph2[0].add(new Edge(0, 2,1));

        // graph2[1].add(new Edge(1, 0,1));

        // graph2[2].add(new Edge(2, 3,1));

        // graph2[3].add(new Edge(3, 0,1));

         // FALSE OUTPUT
        graph2[0].add(new Edge(0, 1,1));
        graph2[0].add(new Edge(0, 2,1));

        graph2[1].add(new Edge(1, 3,1));

        graph2[2].add(new Edge(2, 3,1));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph2){
        boolean vis[]= new boolean[graph2.length];
        boolean stack[]= new boolean[graph2.length];
        for (int i=0; i<graph2.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph2, i, vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph2, int curr, boolean vis[], boolean stack[] ){
        vis[curr]= true;
        stack[curr]= true;
        for(int i=0;i<graph2[curr].size();i++){
            Edge e= graph2[curr].get(i);
            if(stack[e.dest]){
                // cycle exist
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph2, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }


    // to find whether there is any possible path from source to dest. here one vertex will check its neighbout , neighbour checks its neighbour and so on if there is any path possible it return true 
    public static boolean hasPath(ArrayList<Edge>[]graph,int src, int dest,boolean visited[] ){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0; i<graph[src].size();i++){
            Edge e= graph[src].get(i);
            if(!visited[e.dest]&& hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    }
      

    // Minimum spanning tree: subset of edges of connected edge weighted graph taht connects all vertices togetther with min. possiblw toatal edge weight. There can be n possible MSTs of single tree.
    // For this the MST should be non cyclic, least possible total weight is considered , subgraph 
    // for this we use Prim's algo. where we make max possible subgraphs acyclic and add all the possible weight and compare and consider least weighted as ouput. For this we make one MST set array where one by on ewe will add vertices  from notMST set and a visited array is created to make sure there is no repeatiton of vertices again 
    static void createGraphsPrims(ArrayList<Edge> graph3[]){
        for(int i=0;i<graph3.length;i++){
        graph3[i]= new ArrayList<>();
        }
        graph3[0].add(new Edge(0, 1,10));
        graph3[0].add(new Edge(0, 2,15));
        graph3[0].add(new Edge(0, 3,30));

        graph3[1].add(new Edge(1, 0,10));
        graph3[1].add(new Edge(1, 3,40));

        graph3[2].add(new Edge(2, 0,15));
        graph3[2].add(new Edge(2, 3,50));

        graph3[3].add(new Edge(3, 1,40));
        graph3[3].add(new Edge(3, 2,50));

        }
        static class Pair implements Comparable<Pair>{
            int v;
            int cost;
            public Pair(int v, int c){
                this.v=v;
                this.cost=c;
            }
            @Override
            public int compareTo(Pair p2){
                // ascending
                return this.cost-p2.cost;
                // if descending: p2.cost-this.cost
            }
        }

        public static void prims(ArrayList<Edge> graph3[]){
            boolean vis[]= new boolean[graph3.length];
            PriorityQueue<Pair>pq= new PriorityQueue<>();
            pq.add(new Pair(0,0));
            int finalCost= 0;
            while(!pq.isEmpty()){
                Pair curr= pq.remove();
                if(!vis[curr.v]){
                    vis[curr.v]=true;
                    finalCost+=curr.cost;
                    for (int i=0; i<graph3[curr.v].size();i++){
                        Edge e= graph3[curr.v].get(i);
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
            System.out.println("final(min)cost of MST= "+ finalCost);
        }

// set and union Qs. initially every node is itself a parent when rank are equal join anyone to the node otherwise smaller parent will come and add to the bigger value of parent parent will be added to parent and also only parent will return when you are finding the value.
    static int n=7;
    static int par[] = new int[n];
    static int rank[]= new int[n];
    public static void  init(){
        for(int i=0; i<n; i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return find(par[x]);
    }
    public static void union(int a, int b){
        int parA= find(a);
        int parB= find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
    
    public static void main(String args[]) {
        //        (5)
        //    0------ 1
        //           / \
        //       (1)/   \(3)
        //         /     \
        //         2------3
        //         |   (1)
        //      (2)|
        //         |
        //         4
        // int V=5;
        // initially null is stroed i.e. ndefinef
        // ArrayList<Edge>[] graph= new ArrayList[V];
        // for(int i=0; i<V;i++){
        //     graph[i]= new ArrayList<>();
        // }
        // // 0 vertex
        // graph[0].add(new Edge(0,1,5));
        // // 1 vertex
        // graph[1].add(new Edge(1,0,5));
        // graph[1].add(new Edge(1,2,1));
        // graph[1].add(new Edge(1,3,3));
        // // 2 vertex
        // graph[2].add(new Edge(2,1,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[2].add(new Edge(2,4,4));
        // // 3 vertex
        // graph[3].add(new Edge(3,1,3));
        // graph[3].add(new Edge(3,2,1));
        // // 4 vertex
        // graph[4].add(new Edge(4,2,2));

        // 2's neighbors
        // for(int i=0; i<graph[2].size();i++){
        //     Edge e= graph[2].get(i);
        //     System.out.println(e.dest);
        // }

        // HAS PATH
        // int V=7;
        // ArrayList<Edge> graph[] = (ArrayList<Edge>[]) new ArrayList[V];

        // createGraph(graph);
        // bfs(graph);
        // dfs(graph);
        // System.out.println(hasPath(graph, 0, 8, new boolean[V]));

        // detect cycle
    //     0------3
    //    /|      |
    //   / |      |
    //  1  |      4
    //   \ |
    //    \|
    //     2        
        // int V1=5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph1[] = (ArrayList<Edge>[]) new ArrayList[V1];
        // createGraphs(graph1);
        // System.out.println(detectCycle(graph1));
        

        // detect cycle for directed graph
// @SuppressWarnings("unchecked")
//         int V3=4;
//         ArrayList<Edge> graph2[]= (ArrayList<Edge>[]) new ArrayList[V3];
//         createGraphsD(graph2);
//         System.out.println(isCycle(graph2));

        // prism algorithm
        // @SuppressWarnings("unchecked")
        // int V4=4;
        // ArrayList<Edge> graph3[]= new ArrayList[V4];
        // createGraphsPrims(graph3);
        // prims(graph3);

        // UNION
        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);

    }
}
