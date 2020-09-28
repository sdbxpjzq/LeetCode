package _09_前缀树._212_单词搜索II_困难;

import _09_前缀树._208_实现前缀树_中等.TrieV2;

import java.util.LinkedList;
import java.util.List;

/**
 * 212. 单词搜索II 困难
 *给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？
 * 散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，
 * 请先查看这个问题： 实现Trie（前缀树）。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    // public List<String> findWords(char[][] board, String[] words) {
    //     //构建字典树
    //     TrieV2 myTrie = new TrieV2();
    //     TrieV2.TrieNode root = myTrie.root;
    //     //插入数据
    //     for (String word : words){
    //         myTrie.insert(word);
    //     }
    //
    //     //构建结果集容器
    //     List<String> result = new LinkedList<>();
    //     //矩阵行数
    //     int m = board.length;
    //     //矩阵列数
    //     int n = board[0].length;
    //     //存储该节点是否访问
    //     boolean[][] visited = new boolean[n][m];
    //     //遍历整个二维数组
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             find(board, visited, i, j, m, n, result, root);
    //         }
    //     }
    //     return result;
    //
    // }

}
