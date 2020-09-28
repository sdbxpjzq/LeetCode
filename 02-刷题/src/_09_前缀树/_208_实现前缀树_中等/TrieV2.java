package _09_前缀树._208_实现前缀树_中等;

public class TrieV2 {
    public static class TrieNode {
        /**
         *  表示该节点是否为某个字符串的结尾
         */
        boolean isEnd = false;
        /**
         * 存储最后节点的字符串
         */
        char val;

        /**
         * 根据字符排序，[a,b,c,……,z]
         */
        TrieNode[] children = new TrieNode[26];

        TrieNode(char x) {
            val = x;
        }

        boolean hasNode(char node) {
            return children[node - 'a'] != null;
        }

        TrieNode findNode(char node) {
            return children[node - 'a'];
        }


        TrieNode createNode(char node) {
            children[node - 'a'] = new TrieNode(node);
            return children[node - 'a'];
        }
    }

    public TrieNode root = new TrieNode('-');

    /**
     * Initialize your data structure here.
     */
    public TrieV2() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode index = root;
        for (char c : word.toCharArray()) {
            if (index.hasNode(c)) {
                index = index.findNode(c);
            } else {
                index = index.createNode(c);
            }
        }
        index.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode index = root;
        for (char c : word.toCharArray()) {
            if (index.hasNode(c)) {
                index = index.findNode(c);
            } else {
                return false;
            }
        }
        return index.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode index = root;
        for (char c : prefix.toCharArray()) {
            if (index.hasNode(c)) {
                index = index.findNode(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
