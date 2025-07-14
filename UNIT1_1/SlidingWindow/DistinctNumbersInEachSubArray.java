package UNIT1_1.SlidingWindow;

import java.util.*;

public class DistinctNumbersInEachSubArray {
    public static ArrayList<Integer> find(int[] a,int n,int k){
        HashMap<Integer,Integer> h = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<k;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
        }
        al.add(h.size());
        for(int i = k;i<n;i++){
            h.put(a[i],h.getOrDefault(a[i],0)+1);
            h.put(a[i-k],h.get(a[i-k])-1);
            if(h.get(a[i-k])==0){
                h.remove(a[i-k]);
            }
            al.add(h.size());
        }
        return al;
    }
    public static void main(String[] args) {
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
