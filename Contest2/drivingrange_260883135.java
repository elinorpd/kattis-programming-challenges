import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class drivingrange_260883135 {
    static class Graph {
        // A class to represent a graph edge
        class Edge implements Comparable<Edge> {
            int src, dest, weight;
            // Comparator function used for sorting edgesbased on their weight
            public int compareTo(Edge compareEdge) {
                return this.weight - compareEdge.weight;
            }
        };
     
        // A class to represent a subset for union-find
        class subset {
            int parent, rank;
        };
     
        int V, E; // V-> num of vertices & E-> num  edges
        Edge edge[]; // all edges
     
        // Creates a graph with V vertices and E edges
        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }
     
        // function to find set of an element i (uses path compression)
        int find(subset subsets[], int i) {
            if (subsets[i].parent != i)
                subsets[i].parent
                    = find(subsets, subsets[i].parent);
     
            return subsets[i].parent;
        }
     
        // union of two sets of x and y
        void Union(subset subsets[], int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);
     
            // Attach smaller rank tree under root of high rank tree (Union by Rank)
            if (subsets[xroot].rank 
                < subsets[yroot].rank)
                subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank 
                     > subsets[yroot].rank)
                subsets[yroot].parent = xroot;
     
            // If ranks are same, then make one as root and increment its rank by one
            else {
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }
     
        // construct MST using Kruskal's algorithm
        void KruskalMST() {
            Edge result[] = new Edge[V]; 
            int e = 0; //sorted edges index
            int i = 0; // sorted result index
            for (i = 0; i < V; ++i) {
                result[i] = new Edge();
            }

            Arrays.sort(edge);
            
            // Create V subsets with single elements
            subset subsets[] = new subset[V];
            for (i = 0; i < V; ++i)
                subsets[i] = new subset();
            for (int v = 0; v < V; ++v) 
            {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
     
            i = 0; // index used to pick next edge
     
            // num of edges to be taken is V-1
            while (e < V - 1)  {
                // increment smallest edge
                Edge next_edge = new Edge();
                next_edge = edge[i++];
     
                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);
     
                // check for cycles, if adding makes a cycle, get rid of it
                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }
     
            int max = 0;
            for (int j = 0; j < e; ++j) {
                if (max<result[j].weight) {
                    max=result[j].weight;
                }
            }
            if (max==0) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(max);
            }

        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);  // num cities (vertices)
        int m = Integer.parseInt(line[1]);  // num roads (edges)
        
        Graph graph = new drivingrange_260883135.Graph(n, m); 
        for(int i=0;i<m;i++) {
            line = br.readLine().split(" ");
            graph.edge[i].src = Integer.parseInt(line[0]);
            graph.edge[i].dest = Integer.parseInt(line[1]); 
            graph.edge[i].weight = Integer.parseInt(line[2]); 
        }
        if (n > m) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            graph.KruskalMST(); 
        }
    }

    }
