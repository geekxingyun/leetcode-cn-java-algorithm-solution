package com.xingyun.tree.question;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 验证二叉搜索树 递归解法
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/circle/solution/5kEAJm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author qing-feng.zhao
 */
@Slf4j
public class 验证二叉搜索树_递归解法 {
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
    /**
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }
}
