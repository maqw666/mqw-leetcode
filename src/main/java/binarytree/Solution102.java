package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class Solution102 {
    public static void main(String[] args) {

    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root){
        if(root ==null) return levels;
        helper(root,0);
        return levels;
    }

    public void helper(TreeNode node, int level){
        if(levels.size() ==level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);

        if(node.left !=null)
            helper(node.left,level + 1);
        if(node.right !=null)
            helper(node.right,level + 1);

    }
}
