import org.omg.PortableInterceptor.INACTIVE;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.lang.invoke.MethodHandles.lookup;

public class Test {
    class GrandFather{
        void thinking(){
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather{
        void thinking(){
            System.out.println("i am father");
        }
    }

    class Son extends Father{
        void thinking(){
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());
                mh.invoke(this);
            }catch (Throwable e){
                e.printStackTrace();
            }
        }

    }

    @org.junit.Test
    public void main() {
//        (new Test().new Son()).thinking();

        UUID s = java.util.UUID.randomUUID();
        System.out.println(s.toString());

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println("the time is over!!!");
        System.out.println(this.getClass().getMethods()[0].getDeclaringClass());

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a+b));
        System.out.println(c.equals((a+b)));
        System.out.println(g == (a+b));
        System.out.println(g.equals((a+b)));
        System.out.println(e == Integer.valueOf(100+231));

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,1);
        new String().toCharArray();
        for (Map.Entry<Integer,Integer> m:map.entrySet()){
            System.out.println(m.getClass().getName());
        }
    }

    @org.junit.Test
    public void and(){
        int a = 5;

    }

}

