import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] multiply(int[] A) {
        int len = A.length;
        if(len <= 1){
            return A;
        }
        int[] c = new int[len];
        int[] d = new int[len];
        int[] B = new int[len];
        c[0] = 1;
        d[len - 1] = 1;
        for(int i = 1; i < len; i++){
            c[i] = c[i - 1] * A[i - 1];

        }
        for(int i = len - 2; i >= 0; i--){
            d[i] = d[i + 1] * A[i + 1];
        }
        for(int i = 0; i < len; i++){
            B[i] = c[i] * d[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {0};
        int[] B = multiply(A);
//        for(int i = 0; i < B.length; i++){
//            System.out.println(B[i]);
//        }
        System.out.println(Arrays.toString(B));
    }
}