package xingyun.tree.question;

import lombok.extern.slf4j.Slf4j;
import xingyun.tree.common.TreeNode;

/**
 * 对称二叉树 递归解法
 *
 * 链接：https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/49/
 * 来源：力扣（LeetCode）
 * @author qing-feng.zhao
 */
@Slf4j
public class 对称二叉树 {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 进阶：
     *
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return true;
    }

}
