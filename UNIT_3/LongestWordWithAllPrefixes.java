import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean end;
    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.end = true;
    }

    public boolean allPrefixesExist(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            node = node.children[index];
            if (node == null || !node.end) return false;
        }
        return true;
    }
}

public class LongestWordWithAllPrefixes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        String result = "";
        Arrays.sort(words); 
        for (String word : words) {
            if (trie.allPrefixesExist(word)) {
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
