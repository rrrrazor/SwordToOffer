import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static List<TreeNode> list = new ArrayList<TreeNode>();
    /*public static TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k == 0){
            return null;
        }
        inOrder(pRoot);
        if(k > list.size()){
            return null;
        }
        return list.get(k - 1);
    }
    public static List<TreeNode> inOrder(TreeNode pRoot){
        if(pRoot != null){
            if(pRoot.left != null){
               inOrder(pRoot.left);
            }
            list.add(pRoot);
            if (pRoot.right != null){
                inOrder(pRoot.right);
            }
        }
        return list;
    }*/
    static public List<TreeNode> inorderTraversal(TreeNode root) {

        if(root != null){
            if(root.left != null){
                inorderTraversal(root.left);
            }
            list.add(root);
            if(root.right != null){
                inorderTraversal(root.right);
            }
        }
        return list;
    }
    static TreeNode KthNode(TreeNode pRoot, int k){
        list = inorderTraversal(pRoot);
        int len = list.size();
        if(k == 0 || k > len){
            return null;
        }
        return list.get(k - 1);
    }

    static public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length != in.length || pre.length == 0){
            return null;
        }
        TreeNode tree = new TreeNode(pre[0]);
        int root_index;
        for(root_index = 0; root_index < in.length; root_index++){
            if(in[root_index] == pre[0]){
                tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + root_index), Arrays.copyOfRange(in, 0, root_index));
                tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, root_index + 1, in.length), Arrays.copyOfRange(in, root_index + 1, in.length));
                break;
            }
        }
        return tree;
    }
    public static void main(String[] args) {
        int[] pre = {8,6,5,7,10,9,11};
        int[] in = {5,6,7,8,9,10,11};
        System.out.println(KthNode(reConstructBinaryTree(pre,in), 8).val);

    }

}
