package newcoder;

import Utils.TreeNode;

import java.util.ArrayList;

/**
 * Link: https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Status: AC
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class BinaryTreeBFS2 {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int head = 0;
        int end = queue.size();
        while (head != end) {
            TreeNode cur = queue.get(head++);
            result.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                end++;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                end++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;
        System.out.println(new BinaryTreeBFS2().printFromTopToBottom(t1));
    }
}
