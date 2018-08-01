package Graph;

import java.util.HashSet;
import java.util.*;

public class LC133CloneGraph {
    //BFS solution
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode curr;
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode old = queue.poll();
            if (!map.containsKey(old)) map.put(old, new UndirectedGraphNode(old.label));
            curr = map.get(old);
            if (visited.add(curr)){
                for (UndirectedGraphNode child : old.neighbors) {
                    if (!map.containsKey(child)) map.put(child, new UndirectedGraphNode(child.label));
                    curr.neighbors.add(map.get(child));
                    queue.offer(child);
                }
            }
        }
        return map.get(node);
    }

    //DFS solution
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode n : node.neighbors) {
            newNode.neighbors.add(cloneGraph2(n));
        }
        return newNode;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
}
