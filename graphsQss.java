import java.util.*;
public class graphsQss {
    
    // Topological sorting: used for DAGs(Directed acyclic graph). In topological sorting sequence is followed i.e. those steps that are required first will come first followed by next possible step and followed by th enext possible step and so on. eg. if 1, 2 ,3 4 are 4 vertex and 1 is the first step then 2 then 3 and last 4, then 1->2->3->4 will be correct only.     
    // Topological Sort is dependency graph: i.e. when one work is done only then the other will start otherwise there will be no furtur process running on 
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;            
        }
     }
   
    static void createGraph(ArrayList<Edge> graph[]){
    for(int i=0; i<graph.length;i++){
        graph[i]= new ArrayList<>();
        }
        // 2 vertex
        graph[2].add(new Edge(2,3));
        // 3 vertex
        graph[3].add(new Edge(3,1));
        // 4 vertex
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
  // 5 vertex
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));     
    }

    // DFS
// T.C: O(V+E) ; S.C:O(n) for using extra space for stack
    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();
        for(int i=0; i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack s){
        vis[ curr]=true;
        for(int i=0; i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    // USING BFS : Kahn's algorithm DEPENDS ON in-degree(incoming edges) out-degree( outgoing edges through the vertex)
    // FACT: A DAG has at leat one vertex with in-degree=0 and one vertex with out-degree=0, will use this concept in BFS for topological sort 
    // here we will calculate indegree of each vertex and add vertex with 0 in-degree in queue and check the neighbours of those vertex and -1 the indegree of neighbour(N) and if their N=0 then print them

     static void createGraphBFS(ArrayList<Edge> graph1[]){
    for(int i=0; i<graph1.length;i++){
        graph1[i]= new ArrayList<>();
        }
        // 2 vertex
        graph1[2].add(new Edge(2,3));
        // 3 vertex
        graph1[3].add(new Edge(3,1));
        // 4 vertex
        graph1[4].add(new Edge(4,0));
        graph1[4].add(new Edge(4,1));
  // 5 vertex
        graph1[5].add(new Edge(5,0));
        graph1[5].add(new Edge(5,2));     
    }

    public static void calcIndegree(ArrayList<Edge> graph1[], int indegree[]){
        for(int i=0; i<graph1.length;i++){
            // vertex= index i particular vertex
            int v=i;
            for(int j=0;j<graph1[v].size();j++){
                Edge e= graph1[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topSortBFS(ArrayList<Edge> graph1[]){
        int indegree[]= new int [graph1.length];
        calcIndegree(graph1, indegree);
        Queue<Integer>q= new LinkedList<>();
        for(int i=0; i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        // BFS
        while(!q.isEmpty()){
            int curr= q.remove();
            System.out.print(curr+" ");
            // to check neighbour indegree
            for(int i=0; i<graph1[curr].size();i++){
                Edge e= graph1[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // to calculate all  path from source to destination
     static void createGraph1(ArrayList<Edge> graph2[]){
    for(int i=0; i<graph2.length;i++){
        graph2[i]= new ArrayList<>();
        }
        // 0 vertex
        graph2[0].add(new Edge(0,3));
        // 2 vertex
        graph2[2].add(new Edge(2,3));
        // 3 vertex
        graph2[3].add(new Edge(3,1));
        // 4 vertex
        graph2[4].add(new Edge(4,0));
        graph2[4].add(new Edge(4,1));
  // 5 vertex
        graph2[5].add(new Edge(5,0));
        graph2[5].add(new Edge(5,2));     
    }

    public static void printAllPath(ArrayList<Edge> graph2[], int src, int dest, String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0; i<graph2[src].size();i++){
            Edge e= graph2[src].get(i);
            printAllPath(graph2, e.dest, dest, path+src);
        }
    }

    public static void main(String[] args) {
        int V= 6;
        // ArrayList<Edge> graph[]= (ArrayList<Edge>[]) new ArrayList[V];
        // createGraph(graph);
        // topSort(graph);

        // ArrayList<Edge> graph1[]= (ArrayList<Edge>[]) new ArrayList[V];
        // createGraphBFS(graph1);
        // topSortBFS(graph1);

        // calcuate path
        int V1=7;
        ArrayList<Edge> graph2[]= (ArrayList<Edge>[]) new ArrayList[V1];
        createGraph1(graph2);
        int src= 5, dest=1;
        printAllPath(graph2, src, dest, "");
    
    }
       
}
