import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 */
public class Solution {
    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Queue<TreeNode> queue = new LinkedList();
        if(pRoot != null){
            queue.offer(pRoot);
        }

        int nextLevel = 0; //下一层的节点数。
        int toBePrinted =  1; //表示当前层中还没有打印的节点数。

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left != null){
                queue.offer(temp.left);
                ++nextLevel;
            }
            if(temp.right != null){
                queue.offer(temp.right);
                ++nextLevel;
            }
           // list.add(((LinkedList<TreeNode>) queue).pop().val);
            --toBePrinted;
            if(toBePrinted == 0){
                result.add(list);
                list = new ArrayList<Integer>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
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
        System.out.println(Print(reConstructBinaryTree(pre,in)));

    }
}
