package com.wink.learn.jianzhioffer;

/**
 * description: QianXu <br>
 * date: 2021/3/22 下午2:46 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Bianli {

    public static void main(String[] args) {
        TreeNode root = createTree();
        qianXu(root);
        System.out.println("==================");
        zhongXu(root);
        System.out.println("==================");
        houXu(root);

    }

    //前序：根左右
    public static void qianXu(TreeNode node){
        if(node != null){
            visited(node);
            qianXu(node.left);
            qianXu(node.right);
        }
    }

    //中序：左根右
    public static void zhongXu(TreeNode node){
        if(node != null){
            zhongXu(node.left);
            visited(node);
            zhongXu(node.right);
        }
    }

    //后序：左右根
    public static void houXu(TreeNode node){
        if(node != null){
            houXu(node.left);
            houXu(node.right);
            visited(node);
        }
    }
    // 输出当前节点
    public static void visited(TreeNode subTree){
        System.out.println("key:"+subTree.key+"--name:"+subTree.value);;
    }

    //创建二叉树
    /**
     *          A
     *       B     C
     *     D   E     F
     * @param root
     */
     private static TreeNode createTree(){
        TreeNode root = new TreeNode(1,"1");
        TreeNode left1= new TreeNode(2,"2");
        TreeNode right1= new TreeNode(3,"3");
        TreeNode left21= new TreeNode(4,"4");
        TreeNode right21= new TreeNode(5,"5");
        TreeNode left22= new TreeNode(6,"6");
        TreeNode right22= new TreeNode(7,"7");
        root.left=left1;
        root.right=right1;
        left1.left = left21;
        left1.right = right21;
        right1.left = left22;
        right1.right = right22;
        return root;
    }


}
