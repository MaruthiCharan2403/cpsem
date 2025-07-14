package UNIT1_1.SlidingWindow;
// Java Program for Maximum subarray sum with k size using Slidng windowApproach
import java.util.*;
public class MaximumSubArraySum{
    public static int find(int[] a,int n,int k){
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum+=a[i];
        }
        int val = sum;
        for(int i = k;i<n;i++){
            sum+=a[i]-a[i-k];
            val = Math.max(val, sum);
        }
        return val;
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = s.nextInt();
        }
        int k = s.nextInt();
        System.out.println(find(a,n,k));
        s.close();
    }
}