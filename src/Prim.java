

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {

    /**
     * 使用Prim算法得到无向图的最小生成树
     *
     * @param n      顶点数
     * @param weight 边的权值
     * @return 结果集
     */
    public List<Edge> PrimMST(int n, int[][] weight) {
        Node[] nodes = new Node[n];
        List<Edge> edges = new ArrayList<Edge>();
        List<Edge> res = new ArrayList<Edge>(); // 结果集
        boolean[] visited = new boolean[n]; //访问标记数组
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
        }
        for (int[] e : weight) {
            Node a = nodes[e[0]];
            Node b = nodes[e[1]];
            Edge edge = new Edge();
            edge.a = a;
            edge.b = b;
            edge.weight = e[2];
            edges.add(edge);
            a.adj.add(edge);
            b.adj.add(edge);
        }

        int start = 0;
        visited[start] = true;
        // 小顶堆维护边
        PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (Edge e : nodes[start].adj) {
            queue.offer(e);
        }
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            Node a = edge.a;
            Node b = edge.b;
            if (visited[a.id] && visited[b.id]) {
                continue;
            }
            res.add(edge);
            // 如果有n-1条边，那么就表明已经生成MST了
            if (res.size() == n - 1) {
                break;
            }
            if (!visited[a.id]) {
                visited[a.id] = true;
                for (Edge e : a.adj) {
                    queue.offer(e);
                }
            }
            if (!visited[b.id]) {
                visited[b.id] = true;
                for (Edge e : b.adj) {
                    queue.offer(e);
                }
            }
        }
        return res;
    }
}

