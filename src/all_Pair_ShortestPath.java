import java.util.*;

public class all_Pair_ShortestPath {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the size of matrix:");
        int n=sc.nextInt();
        System.out.println("Enter the matrix:");
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
                if(a[i][j]<0) a[i][j]=Integer.MAX_VALUE;
            }
        }

        for (int k=0;k<n;k++) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (a[i][k]!=Integer.MAX_VALUE && a[k][j]!=Integer.MAX_VALUE) {
                        a[i][j]= Math.min(a[i][j],a[i][k]+a[k][j]);
                    }
                }
            }
        }

        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
