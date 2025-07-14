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
    TrieNode root = new TrieNode();
    
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

    public List<int[]> find(String line, String[] words){
        for(String word : words){
            insert(word);
        }
        List<int[]> l = new ArrayList<>();
        for(int i = 0; i < line.length(); i++){
            TrieNode node = root;
            int j = i;
            while(j < line.length()){
                int index = line.charAt(j) - 'a';
                if(node.children[index] == null) break;
                node = node.children[index];
                if(node.end){
                    l.add(new int[]{i, j});
                }
                j++;
            }
        }
        return l;
    }
}

public class Indexpairs {
    public static List<int[]> find(String line,String[] words){
        Trie t = new Trie();
        return t.find(line, words);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        String[] words = s.nextLine().split(" ");
        List<int[]> res = find(line, words);
        for(int[] p : res){
            System.out.println(Arrays.toString(p));
        }
        s.close();
    }
}
