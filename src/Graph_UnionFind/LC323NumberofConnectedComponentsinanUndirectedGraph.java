package Graph_UnionFind;

import java.util.*;

public class LC323NumberofConnectedComponentsinanUndirectedGraph {
    //BFS solution
    public int countComponents(int n, int[][] edges) {
        if (n <= 1 || edges == null || edges.length == 0) return n;
        List<List<Integer>>nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) nodes.add(new ArrayList<Integer>());
        for (int[] e : edges) {
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            count++;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int edge : nodes.get(cur)) {
                    if (!visited[edge]) {
                        visited[edge] = true;
                        queue.offer(edge);
                    }
                }
            }
        }
        return count;
    }
    //TODO: Union Find solution
}
