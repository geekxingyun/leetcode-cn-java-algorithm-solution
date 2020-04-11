package com.xingyun.tree.common;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * @author qing-feng.zhao
 */
public class TreeNode {
    /**
     * tree node val
     */
    public int val;
    /**
     * tree left node
     */
    public TreeNode left;
    /**
     * tree right node
     */
    public TreeNode right;
    /**
     *
     * @param x
     */
    public TreeNode(int x){
        this.val=x;
    }
}
