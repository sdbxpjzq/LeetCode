package 树.n2_二叉树.前中后序遍历;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        //测试
		System.out.println("前序遍历"); // 1,2,3,5,4
		binaryTree.preOrder();

        //测试
//		System.out.println("中序遍历");
//		binaryTree.infixOrder(); // 2,1,5,3,4
//
//		System.out.println("后序遍历");
//		binaryTree.postOrder(); // 2,5,4,3,1

        //前序遍历
        //前序遍历的次数 ：4
//		System.out.println("前序遍历方式~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //中序遍历查找
        //中序遍历3次
//		System.out.println("中序遍历方式~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //后序遍历查找
        //后序遍历查找的次数  2次
//		System.out.println("后序遍历方式~~~");
//		HeroNode resNode = binaryTree.postOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//		} else {
//			System.out.printf("没有找到 no = %d 的英雄", 5);
//		}

        //测试一把删除结点

        System.out.println("删除前,前序遍历");
        binaryTree.preOrder(); //  1,2,3,5,4
        binaryTree.delNode(5);
        //binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); // 1,2,3,4



    }

}

//定义BinaryTree 二叉树
class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //删除结点
    public void delNode(int no) {
        if(root != null) {
            //如果只有一个root结点, 这里立即判断root是不是就是要删除结点
            if(root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除~");
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if(this.root != null) {
            this.root.前序遍历();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if(this.root != null) {
            this.root.中序遍历();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if(this.root != null) {
            this.root.后序遍历();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序遍历
    public Node preOrderSearch(int no) {
        if(root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }
    //中序遍历
    public Node infixOrderSearch(int no) {
        if(root != null) {
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //后序遍历
    public Node postOrderSearch(int no) {
        if(root != null) {
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

