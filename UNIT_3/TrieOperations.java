import java.util.*;
class TrieNode{
    TrieNode[] children;
    boolean end;
    public TrieNode(){
        children = new TrieNode[26];
        end = false;
    }
}
class Trie{
    TrieNode root = null;
    public void insert(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int index = ch-'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.end = true;
    }
    public boolean search(String word){
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int index = ch-'a';
            if(node.children[index]==null) return false;
            node = node.children[index];
        }
        return node.end;
    }
    public boolean delete(String word){
        return deletehelper(root,word,0);
    }
    public boolean deletehelper(TrieNode node,String word,int index){
        if(node==null) return false;
        if(index==word.length()){
            if(!node.end) return false;
            node.end = false;
            return isempty(node);
        }
        char ch = word.charAt(index);
        int i = ch-'a';
        TrieNode child  = node.children[i];
        boolean shouldelete = deletehelper(child, word, index+1);
        if(shouldelete){
            node.children[i] = null;
            return !node.end && isempty(node);
        }
        return false;
        
    }
    public boolean isempty(TrieNode node){
        for(TrieNode child:node.children){
            if(child!=null) return false;
        }
        return true;
    }
}
public class TrieOperations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.close();
        
    }
}
