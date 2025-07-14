import java.util.*;
public class FoidFulkerson {
    public static int n;
    public static int find(int[][] g,int so,int si){
        int[][] res = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                res[i][j] = g[i][j];
            }
        }
        int[] p = new int[n];
        int mf = 0;
        while(bfs(res,so,si,p)){
            int pf = Integer.MAX_VALUE;
            for(int v=si;v!=so;v = p[v]){
                int u = p[v];
                pf = Math.min(pf,res[u][v]);
            }
            for(int v=si;v!=so;v=p[v]){
                int u = p[v];
                res[u][v]-=pf;
                res[v][u]+=pf;
            }
            mf+=pf;
        }
        return mf;
    }
    public static boolean bfs(int[][] res,int so,int si,int[] p){
        boolean[] v = new boolean[n];
        v[so] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(so);
        p[so] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for(int i = 0;i<n;i++){
                if(!v[i] && res[u][i]>0){
                    q.add(i);
                    p[i] = u;
                    v[i] = true;
                }
            }
        }
        return v[si];

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int[][] g = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                g[i][j] = s.nextInt();
            }
        }
        int so = s.nextInt();
        int si = s.nextInt();
        System.out.println(find(g,so,si));
        s.close();
    }
}
