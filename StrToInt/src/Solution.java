public class Solution {
    public static boolean isValid = true;
    public static int StrToInt(String str) {
        //全局变量设置是否合法
        //+-正负
        //空字符串""
        if(str.equals("")){
            isValid = false;
            return 0;
        }
        int num = 0;
        char[] str_arr = str.toCharArray();
        isValid(str_arr);
        if(isValid){
            if(str_arr[0] == '+'){
                int carry = 1;
                for (int i = str_arr.length -1; i > 0; i--){
                    num += (str_arr[i] - '0') * carry;
                    carry *= 10;
                }
            }else if(str_arr[0] == '-'){
                int carry = 1;
                for (int i = str_arr.length -1; i > 0; i--){
                    num += (str_arr[i] - '0') * carry;
                    carry *= 10;
                }
                num = 0- num;
            }else {
                int carry = 1;
                for (int i = str_arr.length -1; i >= 0; i--){
                    num += (str_arr[i] - '0') * carry;
                    carry *= 10;
                }
            }
            //return ;
        }
        return num;

    }

    public static void isValid(char[] str_arr) {
        if(str_arr[0] == '+' || str_arr[0] == '-'){
            for(int i = 1; i < str_arr.length; i++){
                if(!(str_arr[i] >= '0' && str_arr[i] <= '9' )){
                    isValid = false;
                }
            }
        }else {
            for(int i = 0; i < str_arr.length; i++){
                if(!(str_arr[i] >= '0' && str_arr[i] <= '9' )){
                    isValid = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        //String str = "+2147483647";
        //String str = "1a33";
        String str = "123";

        System.out.println(StrToInt(str));
    }
}