package binarytree;

/**
 * 104.二叉树的最大深度 -简单
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Solution104 {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(height)
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
