import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class LCA {
    public static Node find(Node root,Node p,Node q){
        if(root==null){
            return null;
        }
        if(p.data==root.data || q.data==root.data) return root;
        Node left = find(root.left,p,q);
        Node right = find(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = s.nextInt();
        }
        Node root = new Node(a[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i<n) {
            Node temp = q.poll();
            if(a[i]!=-1){
                temp.left = new Node(a[i]);
                q.add(temp.left);
            }
            i++;
            if(i<n && a[i]!=-1){
                temp.right = new Node(a[i]);
                q.add(temp.right);
            }
            i++;
        }
        Node p = new Node(s.nextInt());
        Node x = new Node(s.nextInt());
        Node z = find(root,p,x);
        System.out.println(z.data);
        s.close();

    }
}
