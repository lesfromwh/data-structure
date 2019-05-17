package com.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liushuang 2019/5/16
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }


    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15  7
     * <p>广度搜索法.一层一层的来.</>
     * 时间复杂度是O(n)= n^2 ??
     * <p>
     * 广度优先搜索的时间复杂度分析:
     * <p>
     * 由于每个节点仅被发现一次，好像是O(n)?
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 用这个队列来存储这一层的所有节点.
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> innerResultList = new ArrayList<>();
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                //移除当前层
                TreeNode currNode = queue.remove();
                innerResultList.add(currNode.val);

                //将下一层的节点取出来,放到队列中循环.
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            result.add(innerResultList);
        }

        return result;
    }
}


