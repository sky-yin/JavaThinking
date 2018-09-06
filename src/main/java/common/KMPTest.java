package common;

/**
 * KMP算法
 */

public class KMPTest {
    public static int kmp(String str, String dest,int[] next){//str文本串  dest 模式串
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                //模式匹配，当后置位置与所对比不相同时，使用前置位置减一进行匹配,可以这样用的原因在于
                //dest在当前位置取得的数据是和next[j-1]的位置是一样的，并且数据是回文数据，所以可以直接
                // j的位置置于与当前回文串等同位置的前方，然后继续匹配，
                //不减一是因为需要包含0的情况
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                //+1是因为这时候j已经自增，但是i还未自增
                return i-j+1;
            }
        }
        return 0;
    }
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                //回文追溯，设定对应的j的值，如果一直不相等，那么就一直变小，直至j变成0
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            //做出最后的回文数列(每个位置对应的最大回文值)
            //next数组的含义就是一个固定字符串的最长前缀和最长后缀相同的长度。
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args){
        String a = "abcabc";
        String b = "abcabdabcadc";
        int[] next = kmpnext(a);

        System.out.println("--------");
        int res = kmp(b, a,next);
        System.out.println(res);
        for(int i = 0; i < next.length; i++){
            System.out.print(next[i]);
        }
        System.out.println();
        System.out.println(next.length);
    }

}
