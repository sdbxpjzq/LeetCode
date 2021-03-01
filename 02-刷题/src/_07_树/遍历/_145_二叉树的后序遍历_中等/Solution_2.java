package _07_树.遍历._145_二叉树的后序遍历_中等;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 *
 */
public class Solution_2 {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{1,null,2,3}));
        TreeNode treeNode = createBinaryTree(inputList);
        List<Integer> list = postorderTraversal(treeNode);
        System.out.println(list);
    }
    // todo 注意使用 LinkedList
    static LinkedList<Integer> list = new LinkedList<>();

    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                // 头插
                list.addFirst(node.val);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }

        }
        return list;
    }

    // 创建二叉树
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；
        // 如果元素非空，继续递归构建该节点的左右孩子。
        if(data != null){
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }
}
