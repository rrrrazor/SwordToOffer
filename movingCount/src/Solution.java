public class Solution {
    public static int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        int flag[] = new int[rows * cols];
        for(int i = 0; i < rows * cols; i++){
            flag[i] = 1;//false 表示这个格子没有走过？
        }
        int count = movingCountCore(threshold, rows, cols, 0, 0 ,flag);
        return count;
    }

    public static int movingCountCore(int threshold, int rows, int cols, int i, int j, int[] flag){
        int count = 0;
        if(check(threshold, rows, cols, i, j, flag)){
            flag[i * cols + j] = 0;//表示true
            count = 1 + movingCountCore(threshold, rows, cols, i - 1, j, flag)
                    + movingCountCore(threshold, rows, cols, i + 1, j, flag)
                    + movingCountCore(threshold, rows, cols, i, j - 1, flag)
                    + movingCountCore(threshold, rows, cols, i, j + 1, flag);
        }
        return count;
    }

    /*
    用check函数来判断机器人能否进入坐标为(row, col)的方格
     */
    public static  boolean check(int threshold, int rows, int cols, int i, int j, int[] flag){
        if(i >= 0 && i < rows && j >= 0 && j < cols && getDigitSum(i) + getDigitSum(j) <= threshold && flag[i * cols + j] == 1 ){
            return true;
        }
        return false;
    }
    /*
    用来得到一个数字的数位之和
     */
    public static int getDigitSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
