package com.xingyun.tree.question;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 二叉树的最大深度
 * @author qing-feng.zhao
 */
@Slf4j
public class 二叉树的最大深度_递归解法 {

    /**
     * 如何用Java对象构造这个二叉树
     * 示例如下:
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @return
     */
    public static void main(String[] args) {

        //初始化二叉树
        TreeNode treeNode= initTreeNodeData();

        //递归解法求树的深度
        int depth= maxDepth(treeNode);

        log.info("size={}",depth);
    }

    /**
     * 递归解法求二叉树最大深度
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static int maxDepth(TreeNode root) {
        //如果根结点为空
        if (null == root) {
            //即二叉树的最大深度为0
            return 0;
        } else {
            //递归调用
            //获取左孩子的深度
            int left_height = maxDepth(root.left);
            //获取右孩子的深度
            int right_height = maxDepth(root.right);
            //java.lang.Math.max(参数1，参数2)是一个静态的工具方法，主要用来比较两个相同类型参数的大小，
            // 支持的类型有double，float，int，long四种类型

            // 只要左边孩子或者右边孩子不为空则深度+1
            // 返回两个数字中最大的那一个
            return Math.max(left_height, right_height) + 1;
        }
    }

    private static TreeNode initTreeNodeData(){
        //根结点-左孩子-右孩子遍历顺序
        //根结点是3
        TreeNode treeNode=new TreeNode(3);
        //左孩子是9
        treeNode.left=new TreeNode(9);
        //右边孩子是20
        treeNode.right=new TreeNode(20);
        //右边孩子的左边是15
        treeNode.right.left=new TreeNode(15);
        //右边孩子的右边是7
        treeNode.right.right=new TreeNode(7);
        return treeNode;
    }
}
