package Jan.week_1;

import java.util.*;

public class TopologicalSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        int[] inDgr = new int[n];
        for (int i = 0; i <n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            inDgr[v]++;
            adjList.get(u).add(v);
        }
        System.out.println(Arrays.toString(inDgr));
        boolean[] vis = new boolean[n];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i <n; i++) {
//            if(!vis[i]) dfsTopologicalSorting(stack, adjList, i, vis);
//        }
//        while (!stack.isEmpty()) System.out.print(stack.pop()+" ");
          ArrayList<Integer> topo = new ArrayList<>(n);
          bfsTopologicalSorting(adjList, topo, inDgr);
          System.out.println(topo);

    }


    public static void dfsTopologicalSorting(Stack<Integer> stack, ArrayList<ArrayList<Integer>> adjList, int node, boolean[] vis){
        vis[node] = true;
        for(int val : adjList.get(node)){
            if(!vis[val]) dfsTopologicalSorting(stack, adjList, val, vis);
        }
        stack.add(node);
    }

    public static void bfsTopologicalSorting(ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> topoSort, int[] inDgr){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDgr.length; i++) {
            if (inDgr[i] == 0) {
                q.add(i);
                topoSort.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            for(int val : adjList.get(node)){
                inDgr[val]--;
                if(inDgr[val]==0){
                    topoSort.add(val);
                    q.add(val);
                }
            }
        }

    }
}
