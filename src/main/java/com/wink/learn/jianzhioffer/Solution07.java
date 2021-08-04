package com.wink.learn.jianzhioffer;


import org.apache.commons.collections4.map.LinkedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * description: Solution07 <br>
 * date: 2021/7/23 下午4:06 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Solution07 {

    public static void main(String[] args) {

    }

    int[] preOrder;
    Map<Integer, Integer> inMap = new HashMap<>();
    /**
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNodeInt buildTree(int[] preOrder, int[] inOrder) {
        this.preOrder = preOrder;
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i],i);
        }
        return solute(0,0,inOrder.length-1);
    }

    /**
     *
     * @param root 根结点下标
     * @param left 左子树开始边界
     * @param right 右子树截止边界
     * @return
     */
    TreeNodeInt solute(int root, int left, int right){
        //递归终止条件
        if (left > right) {
            return null;
        }

        //创建当下根结点
        TreeNodeInt curRoot = new TreeNodeInt(preOrder[root]);

        //找出当下根结点在中序遍历的下标
        Integer rootIndex = inMap.get(preOrder[root]);

        //当前节点的左子树 通过递归返回
        //root+1 ： 当前节点左孩子 在前序遍历结果中紧跟当前节点
        curRoot.left = solute( root + 1, left, rootIndex-1);
        //rootIndex - left + root + 1 ： 当前节点的右孩子 在前序遍历中需要通过计算获取
        //获取规则为：当前节点在在中序遍历中的位置减去左子树开始边界 得出这一区间中左子树的节点的数量
        //下一步：在前序遍历中 当前节点的右孩子处于 当前节点的位置 + 左子树节点数量 再 + 1
        curRoot.right = solute( rootIndex - left + root + 1 ,rootIndex+1,right);

        return curRoot;
    }
}
