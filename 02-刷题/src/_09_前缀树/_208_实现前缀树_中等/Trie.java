package _09_前缀树._208_实现前缀树_中等;

import java.util.HashMap;

/**
 * 208. 实现Trie (前缀树) 中等
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {
    // zz 思路解释 https://mp.weixin.qq.com/s/XtvIQHzGq66rQp0Wht-FwQ

    /**
     * path：表示当前节点所能链接到其他节点的个数（在删除操作中会用到）
     * end：表示以当前节点为结尾的单词的个数
     * next：HashMap<Character, TrieNode>类型，表示当前节点能链接到的所有节点。
     */
    public static class TrieNode{
        public int path;
        public int isEnd;
        public HashMap<Character, TrieNode> children;

        public TrieNode(){
            path = 0;
            isEnd = 0;
            children = new HashMap<>();
        }
    }

    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    /**
     * 如同链表的生成过程一样，从根节点开始，如果根节点所连接的节点中没有当前字符，则生成一个值为当前字符的新节点，
     * 插入其中；如果有当前字符，则则继续进行匹配，并在过程中对每一个匹配到的节点path进行计数，
     * 重复上述过程，直到插完最后一个字符，并在最后一个字符的节点end进行计数，表示已经该单词的插入操作已经完成。
     */
    public void insert(String word){
        if(word == null || "".equals(word)) {
            return ;
        }
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                node.children.put(ch,new TrieNode());
            }
            node = node.children.get(ch);
            node.path++;
        }
        node.isEnd++;
    }

    /**
     * 同insert操作基本相同，由于我这里使用的是Hashmap进行的节点存储，
     * 故如果在匹配的过程中没能匹配到，则表示搜索失败，匹配到后最后一个字符时，如果当前end值不为零，则表示匹配成功。
     */
    public boolean search(String word){
        if(word == null || "".equals(word)) {
            return false;
        }
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isEnd != 0;
    }

    /**
     * 同search操作基本相同，只是这里判断到最后一个字符的时候，不需要判断end值。因为这里只需要检查前缀是否存在。
     */
    public boolean startsWith(String word){
        if(word == null || "".equals(word)) {
            return false;
        }
        TrieNode node = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return true;
    }

    /**
     * delete操作同上述操作大致相同，这里需要使用到path变量，回忆一下，path：表示当前节点所能链接到其他节点的个数。
     * 还以五个单词为例，
     * 例如删除'the'，当匹配到‘t’时，由于进行path--操作后，此时判断path为0，过可直接将当前节点置空，后面的数据则不用再去遍历即可。
     * java中的垃圾回收机制会处理其他的被断开的节点，如果在C++中，则需要全部匹配，之后调用析构函数去操作。
     */
    public void delete(String word){
        if(word == null || "".equals(word) || !search(word)) {
            return ;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(--node.children.get(ch).path == 0){
                node.children.remove(ch);
                return;
            }
            node = node.children.get(ch);
        }
        node.isEnd--;
    }

}
