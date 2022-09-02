/* 
    ######################向下的路径节点值之和######################
    二叉树中某一路径求子路径和 可以看成是求数组中子数组和等于k  可以用前缀和来解决


*/



package Offer.ChapterEightTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PathSum50 {


    // 1.start 构建二叉树
    List<Integer> ss = new ArrayList<>();
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    // 1.end
    

/*********************************************************************************/
    // 2.start 求和计算
    // 方法一：前缀和求子路径和为k
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

    // 2.end


/*********************************************************************************/
    // 3.start 求和计算
    // 方法二：深度优先搜索（暴力求全解）
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum2(root.left, targetSum);
        ret += pathSum2(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        } 

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
    // end



    
    public static void main(String[] args) {
        int[] preorder = {5,2,1,6,4,3,7};
        int[] inorder = {1,2,6,5,3,4,7};
        PathSum50 ps = new PathSum50();
        TreeNode node = ps.buildTree(preorder, inorder);
        int res = ps.pathSum(node, 8);
        System.out.println(res);



    }


}
