import java.util.*;
public class LexicographicalSmallestEquivalentString{
    public static String find(String s1,String s2,String sub){
        int[] parent = new int[26];
        for(int i = 0;i<26;i++){
            parent[i] = i;
        }
        for(int i = 0;i<s1.length();i++){
            int x = s1.charAt(i)-'a';
            int y = s2.charAt(i)-'a';
            int f1 = find(x, parent);
            int f2 = find(y, parent);
            if(f1<f2){
                parent[f2] = f1;
            }
            else{
                parent[f1] = f2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:sub.toCharArray()){
            int root = find(c-'a', parent);
            sb.append((char)(root + 'a'));
        }
        return sb.toString();
    }
    public static int find(int x,int[] parent){
            if(parent[x]!=x){
                parent[x] = find(parent[x], parent);
            }
            return parent[x];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        String sub = s.next();
        System.out.println(find(s1,s2,sub));
        s.close();
    }
}