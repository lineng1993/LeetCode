package string.implementTriePrefixTree208;

/**
 * Medium
 * @author lin  2022/3/7 19:16
 */
public class Trie {


    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        System.out.println(trie.startsWith("he"));
        System.out.println(trie.search("he"));
    }

    private final Trie[] children;
    private boolean end;


    public Trie() {
        children = new Trie[26];
        end = false;
    }

    public void insert(String word) {

        Trie node = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.end = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
