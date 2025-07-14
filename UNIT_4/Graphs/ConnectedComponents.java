import java.util.*;
public class ConnectedComponents {
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> find(int[][] edges,int e,int n){
        boolean[] v = new boolean[n];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] ed:edges){
            g.get(ed[0]).add(ed[1]);
            g.get(ed[1]).add(ed[0]);
        }
        for(int i = 0;i<n;i++){
            if(!v[i]){
                ArrayList<Integer> al =  new ArrayList<>();
                dfs(i,g,al,v);
                res.add(new ArrayList<>(al));
            }
        }
        return res;
    }
    public static void dfs(int i,ArrayList<ArrayList<Integer>> g,ArrayList<Integer> al,boolean[] v){
        v[i] = true;
        al.add(i);
        for(int u:g.get(i)){
            if(!v[u]){
                dfs(u, g, al,v);
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] edges = new int[e][2];
        for(int i = 0;i<e;i++){
            for(int j = 0;j<2;j++){
                edges[i][j] = s.nextInt();
            }
        }
        System.out.println(find(edges,e,n));
        s.close();
    }
}