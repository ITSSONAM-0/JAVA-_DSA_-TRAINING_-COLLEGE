import java.util.*;

class Graph {
    int V;
    java.util.LinkedList<Integer>[] adj; // ✅ yaha specify kar diya

    public Graph(int v) {
        V = v;
        adj = new java.util.LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new java.util.LinkedList<>(); // ✅ ab error nahi aayega
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void dfs(int vertex, boolean nodes[]) {
        nodes[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < adj[vertex].size(); i++) {
            int a = adj[vertex].get(i);
            if (!nodes[a]) {
                dfs(a, nodes);
            }
        }
    }

    void dfsStart(int p) {
        boolean[] visited = new boolean[V];
        dfs(p, visited);
    }

    public static void main(String[] args) {
        Graph obj = new Graph(6);

        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 0);
        obj.addEdge(1, 3);
        obj.addEdge(2, 0);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);
        obj.addEdge(3, 5);
        obj.addEdge(4, 3);
        obj.addEdge(5, 3);

        System.out.println("DFS starting from node 0:");
        obj.dfsStart(0);
    }
}
