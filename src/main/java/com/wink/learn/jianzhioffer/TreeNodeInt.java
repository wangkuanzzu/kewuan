package com.wink.learn.jianzhioffer;

/**
 * description: TreeNode <br>
 * date: 2021/3/22 上午11:52 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TreeNodeInt {

    public int value; //值
    public TreeNodeInt left;
    public TreeNodeInt right;

    public TreeNodeInt() {
    }

    public TreeNodeInt(int data){
        this.value=data;
        this.left=null;
        this.right=null;
    }

    public TreeNodeInt(int value, TreeNodeInt left, TreeNodeInt right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNodeInt getLeft() {
        return left;
    }

    public void setLeft(TreeNodeInt left) {
        this.left = left;
    }

    public TreeNodeInt getRight() {
        return right;
    }

    public void setRight(TreeNodeInt right) {
        this.right = right;
    }
}
