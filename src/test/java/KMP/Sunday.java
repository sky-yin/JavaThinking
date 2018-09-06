package KMP;

public class Sunday {

    public static void main(String[] args) {

        String desc = "the google searching the kmp";

        String pattern = "search";

        sunday(desc,pattern);

    }

    /**
     *
     只不过Sunday算法是从前往后匹配，在匹配失败时关注的是文本串中参加匹配的最末位字符的下一位字符。
     如果该字符没有在模式串中出现则直接跳过，即移动位数 = 匹配串长度 + 1；
     否则，其移动位数 = 模式串中最右端的该字符到末尾的距离+1。
     * @param desc
     * @param pattern
     * @return
     */

    public static void sunday(String desc,String pattern){
        char[] descChar = desc.toCharArray();
        char[] patternChar = pattern.toCharArray();
        int i=0,j=0,los=0;
        while (i <= (desc.length() - pattern.length() + j ) ){
            if (descChar[i] != patternChar[j]){
                if (i <= (desc.length() - pattern.length() + j ) ){
                    //i是追随j的，所以使用当前判断
                    break;
                }

                los = cont(patternChar,descChar[i+patternChar.length-j]);
                //如果该字符没有在模式串中出现则直接跳过，即移动位数 = 匹配串长度 + 1；
                //     否则，其移动位数 = 模式串中最右端的该字符到末尾的距离+1。
                if (los == -1){
                    //i-j回退，然后跳到匹配串长度+1
                    i = i-j+patternChar.length+1;
                    j = 0;
                }else {
                    //i-j回退i位置，patternChar.length-los-1取得当前跳动长度,+1，定义加1
                    i = i-j+patternChar.length-los+1-1;
                    j = 0;
                }

            }else {
                    //判断是否退出
                if (j == (pattern.length() - 1)) {
                    System.out.println("the start pos is " + (i - j) + " the end pos is " + i);
                    i = i - j + 1;
                    j = 0;
                } else {
                    i++;
                    j++;
                }
            }
        }

    }

    /**
     * 判断当前字符在最后匹配串中最后出现的位置
     * @param patternChar
     * @param p
     * @return
     */
    public static int cont(char[] patternChar,char p){
        for (int j = patternChar.length-1; j >=0; j--) {
            if (p == patternChar[j])
                return j;
        }
        return -1;
    }

}
