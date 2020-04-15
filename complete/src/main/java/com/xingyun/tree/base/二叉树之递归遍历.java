package com.xingyun.tree.base;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 如果想研究二叉树的遍历算法,那么需要首先知道树的基础知识
 * 1. 构造二叉树
 * 2. 遍历二叉树
 *    2.1 递归遍历二叉树
 *    2.2 非递归借助栈实现遍历
 * @author qing-feng.zhao
 */
@Slf4j
public class 二叉树之递归遍历 {

    public static void main(String[] args) {
        TreeNode treeNode=initTreeNodeData();
        printTreeNode(treeNode);
    }
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
    /**
     * 如何遍历二叉树
     */
    private static void printTreeNode(TreeNode treeNode){
        if(null==treeNode){
            return ;
        }
        int currentTreeNodeVal=treeNode.val;
        log.info("{}",currentTreeNodeVal);
        if(null==treeNode.left){
            printTreeNode(treeNode.left);
        }
        if(null==treeNode.right){
            printTreeNode(treeNode.right);
        }
    }
}
