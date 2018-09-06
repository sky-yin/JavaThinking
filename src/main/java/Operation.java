import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {

    public static final String characterSet = "aeiou";
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        //设置上周榜单派奖状态
        int s = 0;
        cal.add(Calendar.DAY_OF_MONTH,-1);
        if (s == 1){
            // 当前日期所在周周一日期
            cal.set(cal.DAY_OF_WEEK, cal.MONDAY);

            // 将时分秒,毫秒域清零
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date beginDate = cal.getTime();
            System.out.println(format.format(beginDate));
            // 当前日期所在周周日日期
            cal.set(Calendar.DATE, cal.get(cal.DATE) + 7);
            Date endDate = cal.getTime();
            System.out.println(format.format(endDate));
        } else {
            //上周数据信息
            cal.add(Calendar.WEEK_OF_MONTH, -1);
            cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
            // 将时分秒,毫秒域清零
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date beginDate = cal.getTime();
            System.out.println(format.format(beginDate));
            cal.set(Calendar.DATE, cal.get(cal.DATE) + 7);
            Date endDate = cal.getTime();
            System.out.println(format.format(endDate));
        }
//        System.out.println(reverse1("abcdefgh"));
//        System.out.println("asda".toUpperCase());
//        System.out.println(symbol("d+=3=+s+"));
//        char[] s = "asdfa".toCharArray();
//        int num = 110;
//        int[] nums = {num/100,num/10-num/100,num%10};
//        Arrays.sort("sdfa".toCharArray());
//        con(0,2111);

//        cal(30,80);

    }

    //x只，y条腿。
    public static void cal(int x,int y){
        System.out.println("鸡"+(y/2-x)+"只");
        System.out.println("兔子"+(2*x-y/2)+"只");
    }

    public static int con(int index,int num){

            int[] nums = {num/1000,num/100-(num/1000)*10,num/10-(num/100)*10,num%10};

            Arrays.sort(nums);
            int max = nums[3]*1000+nums[2]*100+nums[1]*10+nums[0];
            int min = nums[0]*1000+nums[1]*100+nums[2]*10+nums[3];
            num = max-min;
               System.out.println("--->"+max+"--"+min+"--"+num);

            if (num == 6174) {
                return index;
            }


            return con(++index,num);

    }

    public static String reverse1(String str) {

        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */
        if (str == null) {
            return "the words is error";
        }

        StringBuilder newString = new StringBuilder("");

        for (char s : str.toCharArray()) {
            if (Character.isLetter(s)) {
                s = (char) (s + 1);
                if (characterSet.indexOf(s) > -1) {
                    s = (char) (s + 32);
                }

            }
            newString.append(s);
        }
        return newString.toString();
    }

    public static boolean symbols(String str){
        if (str == null) return false;
        String regex=".*[a-zA-Z]+.*";
        Matcher m= Pattern.compile(regex).matcher(str);
        String[] stringList = str.split("\\+[a-zA-Z]{1}\\+");
        for (String s:stringList){
            System.out.println("--->"+s);
        }
        return !Arrays.stream(str.split("\\+[a-zA-Z]{1}\\+")).anyMatch(s -> Pattern.matches(regex,s));

    }

    /**
     * 正则验证+a+这种的字符串，进行分割
     * @param str
     * @return
     */
    public static boolean symbol(String str){
        if (str == null) return false;
        String regex=".*[a-zA-Z]+.*";
        System.out.println(str.replaceAll("\\+[a-zA-Z]{1}\\+",""));
//        return !Arrays.stream(str.split("/+.*[a-zA-Z]+.*/+")).anyMatch(s -> Pattern.matches(regex,s));
        return !Pattern.matches(regex,str.replaceAll("\\+[a-zA-Z]{1}\\+",""));
    }

}
