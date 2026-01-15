package Jan.week_1;

import java.awt.dnd.DropTargetContext;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class  Pairs{
    int row;
    int col;

    public Pairs(int row, int col) {
        this.col = col;
        this.row = row;
    }
}

public class G_DistanceOfNearestCellHaving1inaBinaryMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        int[][] op = new int[n][m];
        Queue<Pairs> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
                if(mat[i][j]==1){
                    op[i][j] = 0;
                    q.add(new Pairs(i, j));
                }else {
                    op[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(op[i][j]+" ");
            }
            System.out.println();
        }
        Queue<Pairs> copy = new LinkedList<>(q);
//        while (!copy.isEmpty()) System.out.println(q.peek().row +" "+ q.poll().col);
        bfsDistanceOfNearestCellHaving1inaBinaryMatrix(op, q, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(op[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfsDistanceOfNearestCellHaving1inaBinaryMatrix(int[][] op, Queue<Pairs> q, int n , int m){
        int[] x = {1, 0, -1, 0};
        int[] y = {0, -1, 0, 1};
        while (!q.isEmpty()){
            int col = q.peek().col;
            int row = q.poll().row;
            for (int i = 0; i < 4; i++) {
                int nrow = row + x[i];
                int ncol = col + y[i];
                if(ncol>=0 && ncol<m && nrow>=0 && nrow<n && (op[nrow][ncol]==-1 || op[nrow][ncol]>op[row][col]+1)){
                    op[nrow][ncol] = op[row][col]+1;
                    q.add(new Pairs(nrow, ncol));
                }
            }
        }
    }
}
