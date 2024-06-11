import java.util.*;

class Sum_of_subsets {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size:");
        int n=sc.nextInt();
        System.out.println("Enter req_sum:");
        int req_sum=sc.nextInt();
        System.out.println("Enter array:");
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> t=new ArrayList<>();
        Pairs(0,req_sum,0,a,res,t);
        Print(res);
        sc.close();
    }

    static void Pairs(int sum,int req_sum,int idx,int []a,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> x ){
        if(sum>req_sum || idx>=a.length) return;
        sum+=a[idx];
        x.add(a[idx]);
        if(sum==req_sum){
            Collections.sort(x);
            res.add(new ArrayList<>(x));
            x.remove(x.size()-1);
            return;
        }
        Pairs(sum,req_sum,idx+1,a,res,new ArrayList<>(x));
        if(x.size()!=0){
            x.remove(x.size()-1);
        }
        Pairs(sum-a[idx],req_sum,idx+1,a,res,new ArrayList<>(x));
    }

    static void Print(ArrayList<ArrayList<Integer>> res){
        Collections.sort(res,Comparator.comparingInt(ArrayList::size));
        for(ArrayList<Integer> x:res){
            for(int i=0;i<x.size();i++){
                if(i==x.size()-1)
                    System.out.print(x.get(i));
                else System.out.print(x.get(i)+" ");
            }
            System.out.println();
        }
    }
}