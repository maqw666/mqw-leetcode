package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 先遍历左节点 后遍历根节点，最后遍历右节点
 */
public class Solution94 {
    public static void main(String[] args) {
        System.out.println(123);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if(root ==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);

    }

}
