package com.wink.learn.jianzhioffer;


/**
 * description: GongTongParent <br>
 * date: 2021/7/13 下午1:14 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class GongTongParent {

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1,"6");
        TreeNode left1= new TreeNode(2,"2");
        TreeNode right1= new TreeNode(3,"8");
        TreeNode left21= new TreeNode(4,"0");
        TreeNode right21= new TreeNode(5,"4");
        TreeNode left22= new TreeNode(6,"7");
        TreeNode right22= new TreeNode(7,"9");
        TreeNode p= new TreeNode(8,"3");
        TreeNode q= new TreeNode(9,"5");
        root.left=left1;
        root.right=right1;
        left1.left = left21;
        left1.right = right21;
        right1.left = right22;
        right1.right = left22;
        right21.right= p;
        right21.right= q;
        System.out.println(parents(root,left21,q).value);
    }

    private static TreeNode parents(TreeNode root, TreeNode p, TreeNode q){

        int rootv = Integer.parseInt(root.value);
        int pv = Integer.parseInt(p.value);
        int qv = Integer.parseInt(q.value);
        if (rootv > pv && rootv > qv) {
            return parents(root.left, p, q);
        }
        if (rootv < pv&& rootv < qv) {
            return parents(root.right, p, q);
        }
        return root;
    }

}
