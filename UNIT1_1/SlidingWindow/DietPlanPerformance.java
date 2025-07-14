package UNIT1_1.SlidingWindow;

import java.util.*;

public class DietPlanPerformance {
    public static int find(int[] a ,int n,int k,int l,int u){
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum+=a[i];
        }
        int p = 0;
        if(sum<l) p--;
        if(sum>u) p++;
        for(int i = k;i<n;i++){
            sum+=a[i]-a[i-k];
            if(sum<l) p--;
            if(sum>u) p++;
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = s.nextInt();
        }
        int k = s.nextInt();
        int l = s.nextInt();
        int u = s.nextInt();
        System.out.println(find(a,n,k,l,u));
        s.close();
    }
}
