import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class leetCodeTest {
    enum Level{

        _1000("M",1000),
        _900("CM",900),
        _500("D",500),
        _400("CD",400),
        _100("C",100),
        _90("XC",90),
        _50("L",50),
        _40("XL",40),
        _10("X",10),
        _9("IX",9),
        _5("V",5),
        _4("IV",4),
        _1("I",1);


        public String name;
        public Integer value;

        Level(String name,Integer value){
            this.name = name;
            this.value = value;
        }

        static Integer getValue(String s){
            for(Level l:Level.values()){
                if(s.equals(l.name)){
                    return l.value;
                }
            }
            return null;
        }

    }

    public int romanToInt(String s) {

        int add = 0;
        int i = s.length();

        while(i>=1){
            if(i-2>=0){
                Integer num = Level.getValue(s.substring(i-2,i));
                if(num == null){
                    num = Level.getValue(s.substring(i-1,i));
                    i--;
                }
                else
                    i -= 2;
                add += num;
            }else{
                Integer num = Level.getValue(s.substring(i-1,i));
                add += num;
                i--;
            }
        }
        return add;
    }

    @Test
    public void romanTest(){
        System.out.println(romanToInt("III"));
    }


    @Test
    public void sortList(){
//        String[] strs = new String[10];
//
//        for (int i = 0; i < 10; i++) {
//            strs[i] = "a" + ("a"+1);
//            for (int j = 0; j <= 10-i; j++) {
//                strs[i] += "a";
//            }
//        }
        String[] str = {"flower","flow","flight"};
        List<String> strs = Arrays.stream(str).sorted((a, b) ->{
            if (a.length()>b.length())
                return -1;
            if (a.length()==b.length())
                return 0;
            if (a.length()<b.length())
                return 1;
            return 1;
        }).collect(Collectors.toList());
        String prefix = new String(strs.get(strs.size()-1));

        for(int i=strs.size()-1;i>=0;i--){
            if("".equals(prefix)){
                break;
            }
            if(strs.get(i).indexOf(prefix) != 0 ){
                System.out.println(prefix);
                prefix = prefix.substring(prefix.length(),prefix.length()-1);
            }

        }
        System.out.println(prefix);
    }

    @Test
    public void aaTest(){
        int[] s = {1,3,2};
        Arrays.sort(s);
        System.out.println(s);
        List<Integer> list = Arrays.asList();
    }
}
