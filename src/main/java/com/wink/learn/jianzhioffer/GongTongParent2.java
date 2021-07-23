package com.wink.learn.jianzhioffer;


/**
 * description: GongTongParent <br>
 * date: 2021/7/13 下午1:14 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class GongTongParent2 {

    private static int i = 1;
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1,"7");
        TreeNode left1= new TreeNode(2,"5");
        TreeNode right1= new TreeNode(3,"3");
        TreeNode left21= new TreeNode(4,"2");
        TreeNode right21= new TreeNode(5,"1");
        TreeNode left22= new TreeNode(6,"8");
        TreeNode right22= new TreeNode(7,"9");
        TreeNode p= new TreeNode(8,"6");
        TreeNode q= new TreeNode(9,"4");
        root.left=left1;
        root.right=right1;
        left1.left = left21;
        left1.right = right21;
        right1.left = right22;
        right1.right = left22;
        left22.left= p;
        right22.right= q;
        System.out.println(parents(root,p,q).value);
    }

    private static TreeNode parents(TreeNode root, TreeNode p, TreeNode q){

        if (root == null) {
            return null;
        }
        //
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = parents(root.left, p, q);
        TreeNode right = parents(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }

}
