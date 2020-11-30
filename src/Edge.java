public class Edge {
    Node a;
    Node b;
    int weight;

    public Node other(Node x) {
        return a == x ? b : a;
    }
}
