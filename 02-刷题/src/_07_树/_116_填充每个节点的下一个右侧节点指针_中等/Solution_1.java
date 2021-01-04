package _07_树._116_填充每个节点的下一个右侧节点指针_中等;

public class Solution_1 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        m2(root.left, root.right);
        return root;
    }

    public void m2(Node node1, Node node2){
        if (node1 == null || node2 == null) {
            return;
        }
        // 前序遍历模板
        // // 将传入的两个节点连接
        node1.next = node2;
        // 连接相同父节点的两个子节点
        m2(node1.left, node1.right);
        m2(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        m2(node1.right, node2.left);
    }
}
