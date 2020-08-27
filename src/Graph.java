import java.util.*;

public class Graph {
    // 图存储的方法
    // 1.有向图, 例如[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    public void graph1(List<List<String>> edges) {
        // 邻接表按字典序排序
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for (List<String> ticket : edges) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }

    }
}
