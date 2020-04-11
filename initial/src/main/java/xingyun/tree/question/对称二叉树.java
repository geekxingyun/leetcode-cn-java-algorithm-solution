package xingyun.tree.question;

import lombok.extern.slf4j.Slf4j;
import xingyun.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
public class 对称二叉树 {
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
     * 除了递归的方法外，我们也可以利用队列进行迭代。队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是 root 以及 root。
     *
     * 该算法的工作原理类似于 BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。
     *
     * 然后，将两个结点的左右子结点按相反的顺序插入队列中。
     *
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)O(n)，其中 nn 是树中结点的总数。
     * 空间复杂度：搜索队列需要额外的空间。在最糟糕情况下，我们不得不向队列中插入 O(n)O(n) 个结点。因此，空间复杂度为 O(n)O(n)。
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
