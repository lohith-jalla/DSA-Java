import java.util.*;

public class knapsack_dp {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter no.of items");
        int n=sc.nextInt();
        System.out.println("max wt:");
        int w=sc.nextInt();
        int[] profit=new int[n];
        int[] wt=new int[n];
        System.out.println("Enter profits:");
        for(int i=0;i<n;i++){
            profit[i]=sc.nextInt();
        }
        System.out.println("Enter items wt:");
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        int[][] v=new int[n+1][w+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i==0 || j==0) v[i][j]=0;
                else if(wt[i-1]<=j){
                    v[i][j]=Math.max(v[i][j],profit[i-1]+v[i][j-wt[i-1]]); // important formula for 0/1 knapsack
                }
                else v[i][j]=v[i-1][j];
            }
        }

        System.out.print("Max profit is: "+v[n][w]);
        sc.close();
    }
}
