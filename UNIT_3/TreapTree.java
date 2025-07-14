import java.util.*;
class TreapNode{
    int data;
    int priority;
    TreapNode left,right;
    public TreapNode(int data){
        this.data = data;
        this.priority = (int)(Math.random()*100);
        this.left = null;
        this.right = null;
    }
}
class Treap{
    static int k;
    TreapNode root = null;
    TreapNode rotateright(TreapNode y){
        TreapNode x = y.left;
        TreapNode t = x.right;
        x.right = y;
        y.left = t;
        return x;
    }
    TreapNode rotateleft(TreapNode y){
        TreapNode x = y.right;
        TreapNode t = x.left;
        x.left = y;
        y.right = t;
        return x;
    }
    TreapNode insert(TreapNode root,int data){
        if(root==null) root = new TreapNode(data);
        if(data<root.data){
            root.left = insert(root.left, data);
            if(root.left.priority>root.priority){
                root = rotateright(root);
            }
        }
        else if(data>root.data){
            root.right = insert(root.right, data);
            if(root.right.priority>root.priority){
                root = rotateleft(root);
            }
        }
        return root;
    }
    void insert(int data){
        root = insert(root, data);
    }
    void inorder(int val){
        k =val;
        inorder(root);
    }
    void inorder(TreapNode root){
        if(root==null || k<=0) return;
        inorder(root.left);
        k--;
        if(k==0){
            System.out.println(root.data);
            return;
        }
        inorder(root.right);
    }


}
public class TreapTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int k = s.nextInt();
        for(int i = 0;i<n;i++){
            a[i] = s.nextInt();
        }
        Treap t = new Treap();
        for(int i = 0;i<n;i++){
            t.insert(a[i]);
        }
        t.inorder(k);
        s.close();
    }
}
