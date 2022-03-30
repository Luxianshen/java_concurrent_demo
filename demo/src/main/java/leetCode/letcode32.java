package leetCode;

import java.util.*;

/**
 * @author Lujs
 * @desc solution
 * @date 2022/3/29 5:43 PM
 */
public class letcode32 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> treeVal = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            treeVal.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        int[] res = new int[treeVal.size()];
        for (int i = 0; i < treeVal.size(); i++) {
            res[i] = treeVal.get(i);
        }
        return res;
    }

    //   1
    //  2 3
    // 4 5 6
    //7

    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() % 2 == 1) Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;

    }


    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> levelRes = new ArrayList<>(queue.size());
            //倒序 防止多输出
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode node = queue.poll();
                levelRes.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(levelRes);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
