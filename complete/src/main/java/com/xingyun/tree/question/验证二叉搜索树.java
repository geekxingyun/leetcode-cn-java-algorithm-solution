package com.xingyun.tree.question;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qing-feng.zhao
 */
@Slf4j
public class 验证二叉搜索树 {
    public static void main(String[] args) {

        验证二叉搜索树 验证二叉搜索树=new 验证二叉搜索树();

       TreeNode treeNode= 验证二叉搜索树.initTreeNodeData();

       Boolean result=验证二叉搜索树.isValidBST(treeNode);

       log.info("{}",result);

    }

    /**
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        helper(root,null,null);
        return true;
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        //如果根结点为空
        if (node == null){
            return true;
        }
        //根结点的值
        int val = node.val;
        //左边的值如果为空不是有效的二叉搜索树
        //左边的值如果大于等于根结点也不符合
        if (lower != null && val <= lower){
            return false;
        }
        //右边的值如果大于等于左边的值那么也不符合
        //
        if (upper != null && val >= upper){
            return false;
        }
        //比较左孩子节点
        if (! helper(node.right, val, upper)){
            return false;
        }
        //比较右边孩子节点
        if (! helper(node.left, lower, val)){
            return false;
        }
        return true;
    }

    /**
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     *
     * @return
     */
    private TreeNode initTreeNodeData() {
        //根结点-左孩子-右孩子遍历顺序
        //根结点是3
        TreeNode treeNode = new TreeNode(2);
        //左孩子是9
        treeNode.left = new TreeNode(1);
        //右边孩子是20
        treeNode.right = new TreeNode(3);
        return treeNode;
    }
}
