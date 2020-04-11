package com.xingyun.tree.question;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author qing-feng.zhao
 */
@Slf4j
public class 验证二叉搜索树_迭代解法 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode treeNode= initTreeNodeData();

        Boolean result= isValidBST(treeNode);

        log.info("{}",result);

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
    private static TreeNode initTreeNodeData() {
        //根结点-左孩子-右孩子遍历顺序
        //根结点是3
        TreeNode treeNode = new TreeNode(2);
        //左孩子是9
        treeNode.left = new TreeNode(1);
        //右边孩子是20
        treeNode.right = new TreeNode(3);
        return treeNode;
    }

    ////////////////////解法/////////////////////////////////
    private static LinkedList<TreeNode> stack = new LinkedList();
    private static LinkedList<Integer> uppers = new LinkedList(),
            lowers = new LinkedList();
    private static void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    /**
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }
}
