import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Kruskal {

    /**
     * 用Kruskal算法求最小生成树，使用并查集维护，只适用于无向图
     *
     * @param n      顶点数
     * @param weight 边权值, 例如[0,1,2]，点0和点1的权值为2
     * @return 组成最小生成树的结果边集
     */
    public List<Edge> KruskalMST(int n, int[][] weight) {
        List<Edge> res = new ArrayList<>(); // 结果边集
        Node[] nodes = new Node[n]; //点集
        List<Edge> edges = new ArrayList<Edge>(); //边集
        DSU dsu = new DSU(n);
        // 初始化
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
        // 将边从小到大排序
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for (Edge e : edges) {
            Node a = e.a;
            Node b = e.b;
            if (dsu.find(a.id) != dsu.find(b.id)) {
                res.add(e);
                dsu.merge(a.id, b.id);
            } else {
                continue;
            }
        }
        return res;
    }
}

class Edge {
    Node a;
    Node b;
    int weight;

    public Node other(Node x) {
        return a == x ? b : a;
    }
}

class Node {
    int id;
    List<Edge> adj = new ArrayList<Edge>();
}

class DSU {
    int[] p;
    int[] rank;

    public DSU(int n) {
        p = new int[n];
        rank = new int[n];
        reset();
    }

    public void reset() {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int a) {
        if (p[p[a]] == p[a]) {
            return p[a];
        }
        return p[a] = find(p[a]);
    }

    public void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (rank[a] == rank[b]) {
            rank[a]++;
        }
        if (rank[a] < rank[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        p[b] = a;
    }
}