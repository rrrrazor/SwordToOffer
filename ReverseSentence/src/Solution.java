import java.util.Arrays;

public class Solution {
    public static String ReverseSentence(String str) {
        if(str == ""){
            return "";
        }
        char[] str_arr = str.toCharArray();
        int begin = 0;
        int end =str_arr.length -1;

        Reverse(str_arr, begin, end);//翻转整个句子

        //翻转句子中的每个单词
        begin = end = 0;
        for(int i = 0; i < str_arr.length; i++){
            if(str_arr[i] == ' ' && i < str_arr.length - 1){
                end = i - 1;
                Reverse(str_arr, begin, end);
                begin = i + 1;
            }
            if(i == str_arr.length - 1){
                end = i;
                Reverse(str_arr, begin, end);
            }

        }

        String result = "";
        for(int i = 0; i < str_arr.length; i++){
            result += str_arr[i];
        }
        return result;

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
            end --;
        }

    }

    public static void main(String[] args) {
       String str = "I am a student.";
       //String str = "Wonderful";

        System.out.println(ReverseSentence(str));
    }
}