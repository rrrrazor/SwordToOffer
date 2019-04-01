import java.util.Arrays;

public class Solution {
    public static boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if(len <= 0){
            return false;
        }
        Arrays.sort(numbers);
        int cntZero = 0;
        int cntGap = 0;

        //统计数组中0的个数
        for(int i = 0; i < len && numbers[i] == 0; i++){
            cntZero++;
        }

        //统计数组中的间隔数目
        int small = cntZero;
        int big = small + 1;
        while (big < len){
            //有对子，一定不是顺子
            if(numbers[small] == numbers[big]){
                return false;
            }
            cntGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return cntZero >= cntGap ? true:false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4, 5};
        System.out.println(isContinuous(arr));
    }
}