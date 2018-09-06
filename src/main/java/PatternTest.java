public class PatternTest {

    //'.' Matches any single character.
    //'*' Matches zero or more of the preceding element.

    public boolean isMatch(String s, String p) {
        String allString = ".*";
        //验证  .*   有的话直接通过
        if(p.contains(allString))
            return true;
        if(p.length() < 1 || p.charAt(0) == '*')
            return false;

        StringBuilder str = new StringBuilder();

        String[] list = p.split("/*");
        int up= 0;
        int down = 0;
        //运用递归，查找每次截取出的字符串的个数，然后循环
        for (int i = 0,j=0; i < list.length && j<p.length(); i++) {
            p = p.substring(j,p.length()-1);
            if (p.length()<1)
                return false;
            up = p.indexOf(list[i]);
            if (up<0)
                return false;
            j = up;

        }

        return false;
    }
}
