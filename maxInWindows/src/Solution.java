import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(size <= 0){
            return list;
        }
        for (int i = 0; i < num.length - size + 1; i++){
            list.add(findMax(num, i, i + size - 1));
        }
        return list;
    }
    public static int findMax(int[] num, int start, int end){
        //int result = - Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++){
            if(result < num[i]){
                result = num[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num, 0));
    }
}
