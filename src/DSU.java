public class DSU {
    // 并查集
    protected int[] p;
    protected int[] rank;
    protected int[] size;// 连通分量所包含节点个数
    protected int setCount; //连通分量个数

    public DSU(int n) {
        p = new int[n];
        rank = new int[n];
        setCount = n;
        reset();
    }

    private void reset() {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    // 查找根节点并进行路径压缩
    public final int find(int a) {
        // 如果父节点和爷爷节点相同，说明父节点是根，返回父节点
        if (p[a] == p[p[a]]) {
            return p[a];
        }
        // 否则a的父节点设置成为根节点，即进行路径压缩
        return p[a] = find(p[a]);
    }

    // 按秩合并
    public final void merge(int a, int b) {
        // 先找出a和b的根节点
        a = find(a);
        b = find(b);
        // 同根就结束
        if (a == b) {
            return;
        }
        // 将rank小的根节点合并到rank大的根节点
        if (rank[a] == rank[b]) {
            rank[a]++;
        }
        if (rank[a] < rank[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        p[b] = a;
        size[a] += size[b];
        setCount--;
    }
}
