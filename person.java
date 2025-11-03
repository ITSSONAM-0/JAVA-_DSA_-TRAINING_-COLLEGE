import java.util.*;
import java.util.LinkedList;

class person {
    public static void bfs(int[][] graph, int start) {
        boolean[] visit = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);
        System.out.println("bfs travesal ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v + " ");
            for (int i = 0; i < graph[v].length; i++) {
                if (graph[v][i] == 1 && !visit[i]) {
                    visit[i] = true;

                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertex");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("enter th eadjancey matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the starting vertex");
        int start = sc.nextInt();
        bfs(graph, start);
    }
}
