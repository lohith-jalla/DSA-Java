import java.util.*;

//Not completed fully
public class OBST {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the size of the array:");
        int n=sc.nextInt();
        System.out.print("Enter the keys:");
        int[] keys=new int[n];
        for(int i=0;i<n;i++){
            keys[i]=sc.nextInt();
        }

        System.out.print("Enter the frequency:");
        int[] freq=new int[n];
        for(int i=0;i<n;i++){
            freq[i]=sc.nextInt();
        }

        int[][] mat=new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            if(i==0){
                mat[i][i]=0;
            }else mat[i][i]=freq[i-1];
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                mat[i][j] = Integer.MAX_VALUE;

                int sumFreq = cost(i, j, freq); // sum of frequencies from i to j

                // Try making each key in interval keys[i..j] as root
                for (int r = i; r <= j; r++) {
                    int c = (r > i ? mat[i][r - 1] : 0) + (r < j ? mat[r + 1][j] : 0) + sumFreq;

                    if (c < mat[i][j]) {
                        mat[i][j] = c;
                    }
                }
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }

    static int cost(int i,int j,int[] freq){
        int sum=0;
        for(int x=i;x<=j;x++){
            sum+=freq[x];
        }
        return sum;
    }
}
