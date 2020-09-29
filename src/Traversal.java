import java.util.*;

public class Traversal {
    // 二叉树的前中后序遍历，迭代写法
    // 前序遍历，中左右
    // 尽可能往左下走
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                ans.add(root.val);
                root = root.left;
            }
            // 走到头了
            // 查看右子树
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    // 中序遍历，左中右
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 走到头了
            // 查看右子树
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    // 后序遍历，左右中，反过来就是中右左，与前序遍历交换下顺序
    // 尽可能往右下走
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.right;
            }
            // 走到头了
            // 查看右子树
            root = stack.pop();
            root = root.left;
        }
        // 因为是反过来遍历的，所以还需要翻转回来
        Collections.reverse(ans);
        return ans;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
