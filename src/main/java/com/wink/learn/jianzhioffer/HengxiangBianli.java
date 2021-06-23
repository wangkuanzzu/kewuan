package com.wink.learn.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: HengxiangBianli <br>
 * date: 2021/5/20 下午1:08 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class HengxiangBianli {

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1,"1");
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
        right1.left = right22;
        right1.right = left22;
        System.out.println(hxbl(root));
    }

    /**
     * 横向便利二叉树
     * @param root
     * @return
     */
    public static List<String> hxbl(TreeNode root){
        List<String> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.value);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return ans;
    }

}
