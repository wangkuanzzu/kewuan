package com.wink.learn.jianzhioffer;

/**
 * description: TreeNode <br>
 * date: 2021/3/22 上午11:52 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TreeNode{

    public int key; //序号
    public String value; //值
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int key,String data){
        this.key=key;
        this.value=data;
        this.left=null;
        this.right=null;
    }

    public TreeNode(int key, String value, TreeNode left, TreeNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
