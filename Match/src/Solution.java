public class Solution {
    public static boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }
    public static boolean matchCore(char[] str, char[] pattern, int i, int j){
        int str_len = str.length;
        int pat_len = pattern.length;
        if(i == str_len && j == pat_len){
            return true;
        }
        if(i != str_len && j == pat_len){
            return false;
        }

        if(j + 1 < pat_len && pattern[j + 1] == '*'){
            if((i != str_len && str[i] == pattern[j]) || (pattern[j] == '.' && i != str_len)){
                //move on next state
                return matchCore(str, pattern, i + 1, j + 2)||
                        //stay on the current state
                        matchCore(str, pattern, i + 1, j)||
                        //ignore a '*'
                        matchCore(str, pattern, i, j + 2);
            }else {
                //ignore a '*'
                return matchCore(str, pattern, i, j + 2);
            }
        }
        if((i != str_len && str[i] == pattern[j]) || (pattern[j] == '.' && i != str_len)){
            return matchCore(str, pattern, i + 1, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a'};
        //char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        char[] pattern = {'a', '.', 'a'};
        System.out.println(match(str, pattern));
    }
}
