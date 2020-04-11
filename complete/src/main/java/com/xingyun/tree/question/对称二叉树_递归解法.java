package com.xingyun.tree.question;

import com.xingyun.tree.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 对称二叉树 递归解法
 *
 * 官方题解
 * 作者：力扣 (LeetCode)
 * 链接：@see https://leetcode-cn.com/circle/solution/pMxrQw/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author qing-feng.zhao
 */
@Slf4j
public class 对称二叉树_递归解法 {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * 进阶：
     *
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     * @param args
     */
    public static void main(String[] args) {

        TreeNode treeNode=initData();

        Boolean result=isSymmetric(treeNode);

        log.info("对称二叉树验证结果:{}",result);
    }

    /**
     * 根据题意构造这个树
     * @return
     */
    private static TreeNode initData(){
        //root node
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(2);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.right=new TreeNode(4);
        treeNode.right.left=new TreeNode(4);
        treeNode.right.right=new TreeNode(3);
        return treeNode;
    }

    /**
     * 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
     * 因此，该问题可以转化为：两个树在什么情况下互为镜像？
     *
     * 如果同时满足下面的条件，两个树互为镜像：
     *
     * 它们的两个根结点具有相同的值。
     * 每个树的右子树都与另一个树的左子树镜像对称。
     * 就像人站在镜子前审视自己那样。镜中的反射与现实中的人具有相同的头部，但反射的右臂对应于人的左臂，反之亦然。
     *
     * 上面的解释可以很自然地转换为一个递归函数，如下所示：
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)O(n)，其中 nn 是树中结点的总数。
     * 空间复杂度：递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为 O(n)O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)O(n)。
     *

     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
