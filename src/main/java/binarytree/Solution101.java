package binarytree;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 对称条件：
 * 它们的两个根结点具有相同的值
 * 每个树的右子树都与另一个树的左子树镜像对称
 * 实现：
 * 我们可以实现这样一个递归函数，通过[同步移动，两个指针的方法来遍历这棵树，p 指针和
 * 指针开始都指向这棵树的根，随后p 右移时，g 左移，p 左移时，9 右移。每次检查当前p和g 节点的值是否相等，
 * 如果相等再判断左右子树是否对称。
 */
public class Solution101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q){
        if(p ==null && q==null){
            return true;
        }
        if(p ==null || q==null){
            return false;
        }
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}
