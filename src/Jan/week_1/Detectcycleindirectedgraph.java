package Jan.week_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Detectcycleindirectedgraph {
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
        }
        boolean[] pathVis = new boolean[n+1];
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i <=n; i++) {
            if(!vis[i] && dfsDetectcycleindirectedgraph(adjList, pathVis, vis, i)) {
                for (int j = 0; j <=n; j++) {
                    System.out.print(pathVis[j]+" ");
                }
                System.out.println(" cycle");
                return;
            }
        }
        for (int i = 0; i <=n; i++) {
            System.out.print(pathVis[i]+" ");
        }
        System.out.println("No cycle");
    }

    public static boolean dfsDetectcycleindirectedgraph(ArrayList<ArrayList<Integer>> adjList, boolean[] pathVis, boolean[] vis, int node){
        vis[node] = true;
        pathVis[node] = true;
        for(int val : adjList.get(node)){
            if(!vis[val]){
                if(dfsDetectcycleindirectedgraph(adjList, pathVis, vis, val)) return true;
            }else if(pathVis[val]) return true;
        }
        pathVis[node] = false;
        return false;
    }
}
