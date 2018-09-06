package KMP;

import org.junit.Test;

import java.util.Arrays;

/**
 * KMP算法
 */

public class KMPTest {

    public static int[] kmpNext(String desc){

        int[] next = new int[desc.length()];
        next[0] = -1;
        for (int i = 1,j=0; i < desc.length(); i++) {
            while (j>0 && desc.charAt(i) != desc.charAt(j)){
                j = next[j];
            }

            if (desc.charAt(i) == desc.charAt(j)){
                j++;
            }
            next[i] = j;

        }
        return next;
    }

    public static Integer kmpFind(String str,String desc,int[] next){
        for (int i = 0,j=0; i < str.length(); i++) {
            while (j>0 && str.charAt(i) != desc.charAt(j)){
                j = next[j];
            }

            if (str.charAt(i) == desc.charAt(j)){
                j++;
            }
            if (j == desc.length()){
                return i-j+1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        String str = "sadfwoeiabasdffa";
        String desc = "abcabc";

        int[] next = kmpNext(desc);

        for (int i = 0; i <next.length ; i++) {
            System.out.print(next[i]+"  ");
        }

        System.out.println(kmpFind(str,desc,next));
    }
}
