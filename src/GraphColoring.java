import java.util.Scanner;

public class GraphColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of matrix: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of colors: ");
        int m = sc.nextInt();
        System.out.println("Enter the matrix:");
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] colors = new int[n];
        if (graphcolor(0, m, a, colors)) {
            System.out.println("Solution exists: Following are the assigned colors:");
            for (int i = 0; i < n; i++) {
                System.out.print(colors[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("No solution exists.");
        }
    }

    static boolean graphcolor(int v, int m, int[][] graph, int[] colors) {
        int n = graph.length;
        if (v == n) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, colors, c)) {
                colors[v] = c;
                if (graphcolor(v + 1, m, graph, colors)) {
                    return true;
                }
                colors[v] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int v, int[][] graph, int[] colors, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && colors[i] == c) {
                return false;
            }
        }
        return true;
    }
}
