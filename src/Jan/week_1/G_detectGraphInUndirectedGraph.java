package Jan.week_1;

import java.util.*;

class Pair{
    int node;
    int parentNode;

    public Pair(int node, int parentNode) {
        this.node = node;
        this.parentNode = parentNode;
    }
}
public class G_detectGraphInUndirectedGraph {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] vis = new boolean[n + 1];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i] && dfsDetectGraphInUndirectedGraph(adjList, i, -1, vis)) {
                System.out.println("Graph has a Cycle in it");
                return;
            }
        }
        System.out.println("Graph do not contain cycle in it");
    }

    public static boolean BFSdetectGraphInUndirectedGraph(ArrayList<ArrayList<Integer>> adjLis, int srcNode, boolean[] vis) {
        vis[srcNode] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(srcNode, -1));
        while (!q.isEmpty()) {
            int parNode = q.peek().parentNode;
            int node = q.poll().node;
            for (int val : adjLis.get(node)) {
                if (!vis[val]) {
                    q.add(new Pair(val, node));
                    vis[val] = true;
                } else if (parNode != val) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsDetectGraphInUndirectedGraph(ArrayList<ArrayList<Integer>> adjLis, int srcNode, int parentNode, boolean[] vis) {
        vis[srcNode] = true;
        for (int val : adjLis.get(srcNode)) {
            if (!vis[val]) {
                dfsDetectGraphInUndirectedGraph(adjLis, val, srcNode, vis);
            } else if (parentNode != val) return true;
        }
        return false;
    }
}
