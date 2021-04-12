package jianzhioffer;

import org.bouncycastle.util.Strings;

/**
 * description: QianXu <br>
 * date: 2021/3/22 下午2:46 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Bianli {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,"A");
        createTree(root);

        qianXu(root);
        System.out.println("==================");
        zhongXu(root);
        System.out.println("==================");
        houXu(root);

    }

    //前序：根左右
    public static void qianXu(TreeNode node){
        if(node != null){
            visted(node);
            qianXu(node.left);
            qianXu(node.right);
        }
    }

    //中序：左根右
    public static void zhongXu(TreeNode node){
        if(node != null){
            zhongXu(node.left);
            visted(node);
            zhongXu(node.right);
        }
    }

    //后序：左右根
    public static void houXu(TreeNode node){
        if(node != null){
            houXu(node.left);
            houXu(node.right);
            visted(node);
        }
    }
    // 输出当前节点
    public static void visted(TreeNode subTree){
        System.out.println("key:"+subTree.key+"--name:"+subTree.value);;
    }

    //创建二叉树
    /**
     *          A
     *       B     C
     *     D   E     F
     * @param root
     */
    public static void createTree(TreeNode root){
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        TreeNode newNodeF = new TreeNode(6,"F");

        newNodeC.right = newNodeF;//root.rightChild.rightChild=newNodeF;
        newNodeB.left = newNodeD;//root.leftChild.leftChild=newNodeD;
        newNodeB.right = newNodeE;//root.leftChild.rightChild=newNodeE;

        root.left = newNodeB;
        root.right = newNodeC;
    }


}
