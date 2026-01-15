package Jan.week_1;

import javax.print.DocFlavor;
import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] clr = new int[n+1];
        Arrays.fill(clr, -1);
        System.out.println(dfsBipartiteGraph(adjList, clr, 0));

    }

    public static boolean bfsBipartiteGraph(ArrayList<ArrayList<Integer>> adjList, int[] clr){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int node = q.poll();
            for(int val : adjList.get(node)){
                if(clr[val]==-1){
                    clr[val] = 1 - clr[node];
                    q.add(val);
                } else if (clr[node]==clr[val]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfsBipartiteGraph(ArrayList<ArrayList<Integer>> adjList, int[] clr, int node){
        for(int val : adjList.get(node)){
            if(clr[val]==-1){
                clr[val] = 1 - clr[node];
                dfsBipartiteGraph(adjList, clr, val);
            } else if (clr[val]==clr[node]) return false;
        }
        return true;
    }
}
