import java.util.*;
public class NumberOfConnectedComponents {
    public static int[] parent;
    public static int[] size;
    public static int find(int i){
        while(parent[i]>=0){
            i = parent[i];
        }
        return i;
    }
    public static int numberofcomponents(int[][] a,int e,int n){
        int c = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0;i<n;i++){
            parent[i]=-1;
            size[i] = 1;
        }
        for(int[] edges:a){
            int x = find(edges[0]);
            int y = find(edges[1]);
            if(x!=y){
                if(size[x]<size[y]){
                    size[y]+=size[x];
                    parent[x] = y;
                }
                else{
                    size[x]+=size[y];
                    parent[y] = x;
                }
                c--;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] a = new int[e][2];
        for(int i = 0;i<e;i++){
            for(int j = 0;j<2;j++){
                a[i][j] = s.nextInt();
            }
        }
        System.out.println(numberofcomponents(a,n,e));
        s.close();
    }
}
