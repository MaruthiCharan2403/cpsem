import java.util.*;
public class ArticulationPoint {
    public static int time = 0;
    public static ArrayList<Integer> find(int[][] edges,int n,int e){
        int[] low = new int[n];
        int[] disc = new int[n];
        boolean[] vis = new boolean[n];
        boolean[] ap = new boolean[n];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for(int i = 0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] ed:edges){
            g.get(ed[0]).add(ed[1]);
            g.get(ed[1]).add(ed[0]);
        }
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,-1,low,disc,vis,ap,g);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(ap[i]) al.add(i);
        }
        return al;
    }
    public static void dfs(int u,int p,int[] low,int[] disc,boolean[] vis,boolean[] ap,ArrayList<ArrayList<Integer>> g){
        vis[u] = true;
        disc[u] = low[u] = ++time;
        int c = 0;
        for(int v:g.get(u)){
            if(!vis[v]){
                c++;
                dfs(v, u, low, disc, vis, ap, g);
                low[u] = Math.min(low[u], low[v]);
                if(p!=-1 && low[v]>=disc[u]) ap[u] = true;
            }
            else if(v!=p){
                low[u] = Math.min(low[u],disc[v]);
            }
        }
        if(p==-1 && c>1) ap[u] = true;
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
        System.out.println(find(edges,n,e));
        s.close();
    }
}
