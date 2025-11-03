import java.util.*;

class Graph {
    private int V; // number of vertices
    private List<List<Integer>> adj; // adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge (undirected)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // remove this line if directed graph
    }

    // Print adjacency list
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int node : adj.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    // BFS Traversal
    void BFS(int start) {
        boolean[] visited = new boolean[V];
        // Queue<Integer> q = new LinkedList<Integer>(); pehle ye likhe tha but isme
        // error aa raha tha kyuki folder me abhi bhi
        // LinkedList.java ya Queue.java naam ka file hoga jo Java ke built-in classes
        // ke saath conflict kar raha hai
        // Agar aapko sure karna hai ki Java ka hi Queue aur LinkedList use ho, to aise
        // likho:

        // java.util.Queue<Integer> q = new java.util.LinkedList<Integer>();
        java.util.Queue<Integer> q = new java.util.LinkedList<Integer>();
        visited[start] = true;
        q.add(start);

        System.out.print("BFS: ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
        System.out.println();
    }

    // DFS Traversal
    void DFS(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                dfsHelper(neigh, visited);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        // Add edges
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // Print graph
        g.printGraph();

        // Traversals
        g.BFS(0);
        g.DFS(0);
    }
}
