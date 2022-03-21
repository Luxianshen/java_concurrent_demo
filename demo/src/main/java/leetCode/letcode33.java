package leetCode;

/**
 * @author Lujs
 * @desc TODO
 * @date 2022/3/17 10:13 PM
 */
public class letcode33 {

    static class Tree {
        int val;
        Tree left;
        Tree rigth;

        public Tree(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {


        // 1 3 2 6 5
        //后序

    }

    public boolean verifyPostorder(int[] postorder) {
        Tree tree = new Tree(5);
        tree.left = new Tree(2);
        tree.rigth = new Tree(6);
        tree.left.left = new Tree(1);
        tree.left.rigth = new Tree(3);
        return recur(tree, postorder, 0);
    }


    public boolean recur(Tree tree, int[] a, int index) {
        /*tree.left
        if(a[index])*/

        return true;
    }

}
