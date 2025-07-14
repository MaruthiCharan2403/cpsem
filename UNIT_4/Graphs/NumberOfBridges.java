import java.util.*;

public class NumberOfBridges {
    public static ArrayList<ArrayList<Integer>> b;
    public static int time;

    public static ArrayList<ArrayList<Integer>> find(int[][] edges, int e, int n) {
        b = new ArrayList<>();
        time = 0;

        int[] disc = new int[n];
        int[] low = new int[n];
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]); // fix: undirected graph
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, g, disc, low, vis);
            }
        }

        return b;
    }

    public static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> g,
                           int[] disc, int[] low, boolean[] vis) {
        vis[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : g.get(u)) {
            if (v == parent) continue;

            if (!vis[v]) {
                dfs(v, u, g, disc, low, vis);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    b.add(new ArrayList<>(Arrays.asList(u, v)));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]); // back edge update
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] edges = new int[e][2];

        for (int i = 0; i < e; i++) {
            edges[i][0] = s.nextInt();
            edges[i][1] = s.nextInt();
        }

        ArrayList<ArrayList<Integer>> result = find(edges, e, n);
        for (ArrayList<Integer> bridge : result) {
            System.out.println(bridge.get(0) + " - " + bridge.get(1));
        }

        s.close();
    }
}
