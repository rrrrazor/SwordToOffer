public class Solution {
   static int index = -1;
   static String Serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if(root == null){
            s.append("$,");
            return s.toString();
        }
        s.append(root.val  + ",");
        Serialize(root.left);
        Serialize(root.right);
        return s.toString();
    }
   static TreeNode Deserialize(String str) {
        index ++;
        if(index >= str.length()){
            return null;
        }
        String[] arr = str.split(",");
        TreeNode root = null;

       // while ( arr[index] != "$"){//比较的是对象的地址
        while(!arr[index].equals("$")){//比较的是对象的值
            //root = new TreeNode(Integer.valueOf(arr[index]));
            /**
             *  valueOf和parseInt都可以
             *  Integer.valueOf(i)//返回的是Integer
             *  Integer.parseInt(i)//返回的是int
             *  因为JDK5以后实现了自动拆装箱，因而两者的差别也不是特别大了，但是从效率上考虑，建议首先考虑parseInt方法。
             */
            root = new TreeNode(Integer.parseInt(arr[index]));

            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }

}
