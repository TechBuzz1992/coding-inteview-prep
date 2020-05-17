package amazon;

import java.util.*;

public class TopologicalSort {
    static class Graph {
        private int V;
        private ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int x, int y) {
            adj.get(x).add(y);
        }

        public void topologicalSorting() {
            int[] inDegree = new int[V];

            // code for calculating the indegree of all the vertices
            for (int i = 0; i < V; i++) {
                ArrayList<Integer> neigh = adj.get(i);
                for (int j : neigh) {
                    inDegree[j]++;
                }
            }

            // Queue for storing all the vertices with indegree 0
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // init counter of visited vertices
            int cnt = 0;

            // Creating vector to store the topological result
            Vector<Integer> topo = new Vector<>();

            while (!queue.isEmpty()) {
                int u = queue.poll();
                topo.add(u);

                for (int node : adj.get(u)) {
                    if (--inDegree[node] == 0) {
                        queue.add(node);
                    }

                }

                cnt++;

            }

            if (cnt != V) {
                System.out.println("The graph is having the cycle");
            }

            System.out.println("The topological ordering is:");
            for (int i : topo) {
                System.out.print(i + " ");
            }

        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        System.out.println("Following is a Topological Sort"); 
        g.topologicalSorting(); 

    }

    

}