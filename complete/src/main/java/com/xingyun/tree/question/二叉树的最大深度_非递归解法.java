package com.xingyun.tree.question;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * 获取树的深度
 * @author qing-feng.zhao
 */
@Slf4j
public class 二叉树的最大深度_非递归解法 {
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     * @param args
     */
    public static void main(String[] args) {
        //由于都是实例方法需要创建一个实例对象
        二叉树的最大深度_非递归解法 二叉树的最大深度非递归解法 =new 二叉树的最大深度_非递归解法();
        //获取初始化好的二叉树
        TreeNode treeNode= 二叉树的最大深度非递归解法.initTreeNodeData();

        //我们需要编写的核心算法
        int depth= 二叉树的最大深度非递归解法.maxDepth(treeNode);

        //打印结果
        log.info("返回它的最大深度 {}",depth);
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //BFS的层次遍历思想，记录二叉树的层数，
        //遍历完，层数即为最大深度
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return maxDepth;
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
    private TreeNode initTreeNodeData(){
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
