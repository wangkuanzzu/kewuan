package com.wink.learn.leetcode;

import com.wink.learn.jianzhioffer.TreeNode;

/**
 * description: LeetCode572 <br>
 * date: 2021/6/30 下午5:48 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode572 {

    public static void main(String[] args) {

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //树的子树
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return true;
        }
        if (doesTree1HasTree2(root,subRoot)) {
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean doesTree1HasTree2(TreeNode root, TreeNode subRoot){

        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if(!root.value.equals(subRoot.value)){
            return false;
        }
        return doesTree1HasTree2(root.left,subRoot.left) && doesTree1HasTree2(root.right,subRoot.right);
    }


}
