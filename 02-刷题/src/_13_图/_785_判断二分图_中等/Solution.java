package _13_图._785_判断二分图_中等;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. 判断二分图 中等
 *给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，
 * 并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。
 * 这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 *
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {

    /**
     * 广度优先搜索
     *首先定义 int[] visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
     * 对于每个连通域，任选其中一个顶点作为搜索起点，加入队列，对该连通域进行 BFS 染色，详见注释。
     * 时间复杂度是O(N+M) ，空间复杂度是O(N) ，其中 N 是无向图的顶点数，M是无向图的边数。
     */
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 bfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            // 每出队一个顶点，将其所有邻接点染成相反的颜色并入队。
            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w: graph[v]) {
                    // 如果当前顶点的某个邻接点已经被染过色了，且颜色和当前顶点相同，说明此无向图无法被正确染色，返回 false。
                    if (visited[w] == visited[v]) {
                        return false;
                    }
                    if (visited[w] == 0) {
                        visited[w] = -visited[v];
                        queue.offer(w);
                    }
                }
            }
        }

        return true;
    }


    /**
     *深度优先搜索
     *
     * 首先定义 int[] visited 数组，初始值为 0 表示未被访问，赋值为 1 或者 -1 表示两种不同的颜色。
     * 对于每个连通域，任选其中一个顶点作为搜索起点，对该连通域进行 DFS 染色，
     *
     * 时间复杂度是O(N+M) ，空间复杂度是O(N) ，其中 N 是无向图的顶点数，M是无向图的边数。
     */
    public boolean isBipartiteV2(int[][] graph) {
        int[] visited = new int[graph.length];
        // 因为图中可能含有多个连通域，所以我们需要判断是否存在顶点未被访问，若存在则从它开始再进行一轮 dfs 染色。
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int v, int color, int[] visited) {
        // 如果要对某顶点染色时，发现它已经被染色了，则判断它的颜色是否与本次要染的颜色相同，如果矛盾，说明此无向图无法被正确染色，返回 false。
        if (visited[v] != 0) {
            return visited[v] == color;
        }

        // 对当前顶点进行染色，并将当前顶点的所有邻接点染成相反的颜色。
        visited[v] = color;
        for (int w: graph[v]) {
            if (!dfs(graph, w, -color, visited)) {
                return false;
            }
        }
        return true;
    }


    /**
     *并查集
     * 遍历图中每个顶点：
     *
     * 将当前顶点的所有邻接点进行合并
     * 判断是否存在邻接点与当前顶点已经在一个集合中了，若存在，则说明不是二分图
     *
     * 时间复杂度是O(N+M) ，空间复杂度是O(N) ，其中 N 是无向图的顶点数，M是无向图的边数。
     */
    public boolean isBipartiteV3(int[][] graph) {
        // 初始化并查集
        UnionFind uf = new UnionFind(graph.length);
        // 遍历每个顶点
        for (int i = 0; i < graph.length; i++) {
            int[] adjs = graph[i];
            // 遍历当前顶点的所有邻接点，将其与当前顶点的第一个邻接点合并。
            for (int w: adjs) {
                // 若某个邻接点与当前顶点已经在一个集合中了，说明不是二分图，返回 false。
                if (uf.isConnected(i, w)) {
                    return false;
                }
                uf.union(adjs[0], w);
            }
        }
        return true;
    }
}

// 并查集
class UnionFind {
    int[] roots;

    // 初始化每个点指向自己
    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    // 返回 i 的根
    public int find(int i) {
        if (roots[i] == i) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    // 判断 p 和 q 是否在同一个集合中
    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    // 合并 p 和 q 到一个集合中
    public void union(int p, int q) {
        roots[find(p)] = find(q);
    }
}
