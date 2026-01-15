package Jan.week_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Matrix_of_O_and_X_ifsurroundedby_X {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pairs> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
                if(mat[i][j]==1){
                    vis[i][j] = 0;
                    q.add(new Pairs(i, j));
                }else {
                    vis[i][j] = -1;
                }
            }
        }
    }
}
