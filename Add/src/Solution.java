public class Solution {
    /**
     * 不用加减乘除做加法
     * “三步走”1：各位相加不计进位；2：记下进位（位于运算，然后向左移一位）；3：将前两步的结果相加。
     * @param num1
     * @param num2
     * @return
     */
    public  static int Add(int num1,int num2) {
        int sum = 0;
        do{
            sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return sum;
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        System.out.println(Add(i,j));
    }
}