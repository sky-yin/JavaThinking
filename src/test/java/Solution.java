import org.junit.Test;

public class Solution {
    /**
     I             1
     IV            4
     V             5
     IX            9
     X             10
     L             50
     LC            90
     C             100
     D             500
     CM            900
     M             1000
     **/


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
        int i = s.length()-1;

        while(i>=0){
            if(i-2>=0){
                Integer num = Level.getValue(s.substring(i,i-1));
                add += num;
                i--;
            }else{
                Integer num = Level.getValue(s.substring(i,i-2));
                if(num == null)
                    num = Level.getValue(s.substring(i,i-1));
                else
                    i -= 2;
                add += num;
            }
        }
        return i;
    }

    @Test
    public void test(){
        int m  =3;
        int n = m;
        n = 4;
        System.out.println(m);
    }
}
