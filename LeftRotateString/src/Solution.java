public class Solution {
    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        char[] str_arr = str.toCharArray();
        if(str != null){

            if(len > 0 && n > 0 && n < len){
                int firstStart = 0;
                int firstEnd = n -1;
                int secStart = n;
                int secEnd = len - 1;
                Reverse(str_arr, firstStart, firstEnd);
                Reverse(str_arr, secStart, secEnd);
                Reverse(str_arr, firstStart, secEnd);
            }
        }
        String rst = "";
        for(int i = 0; i < len; i++){
            rst += str_arr[i];
        }
        return rst;
    }
    public static void Reverse(char[] str_arr, int begin, int end){
        if(str_arr.length <= 0 || begin < 0 || end < 0){
            return;
        }
        while (begin < end){
            char temp = str_arr[begin];
            str_arr[begin] = str_arr[end];
            str_arr[end] = temp;
            begin ++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        String s = LeftRotateString(str, 2);
        System.out.println(s);
    }
}