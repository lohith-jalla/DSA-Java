
//Knapsack (You can write 0/1 knapsack(greedy) same code and remove the else if condition.)
import java.util.*;


public class Main {
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
        double[] profit_weight=new double[n];
        for(int i=0;i<n;i++){
            profit_weight[i]=(double)(profit[i]/wt[i]);
        }
        double sum=0;
        int i=0,idx=0;
        while(i<=n-1 && w>=0){
            if(w==0) break;
            idx=max(profit_weight);
            if(wt[idx]<=w){
                sum+=profit[idx];
                w-=wt[idx];
                profit_weight[idx]=-1;
            }
            else if(wt[idx]>w){
                double add=(double) (w/wt[idx]);
                sum+=add*profit[idx];
                w=0;
            }

            i++;
        }
        System.out.printf("max pro: "+sum);
    }

    static int max(double[] pwt){
        int idx=0;
        double max=-100;
        for(int i=0;i<pwt.length;i++){
            if(max < pwt[i]) {
                max=pwt[i];
                idx=i;
            }
        }
        return idx;
    }
}