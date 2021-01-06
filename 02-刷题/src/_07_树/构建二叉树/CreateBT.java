package _07_树.构建二叉树;

import java.util.Arrays;
import java.util.LinkedList;

public class CreateBT {
    LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
    TreeNode treeNode = createBinaryTree(inputList);

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
