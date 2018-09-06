package Map;

import com.sun.xml.internal.bind.v2.util.QNameMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class HashMapTest {

    @Test
    public void test(){

        String s = new String("yin");
        System.out.println(s.hashCode());
        String n = "yin";
        System.out.println(n.hashCode());
        System.out.println(s.equals(n));

        HashMap<String,Integer> map = new HashMap<>();
        map.put(s,1);
        map.put(n,2);
        System.out.println(map.size());

        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        if(st==null){
            System.out.println("无堆栈...");
            return;
        }
        StringBuffer sbf =new StringBuffer();
        for(StackTraceElement e:st){
            if(sbf.length()>0){
                sbf.append(" <- ");
                sbf.append(System.getProperty("line.separator"));
            }
            sbf.append(java.text.MessageFormat.format("{0}.{1}() {2}"
                    ,e.getClassName()
                    ,e.getMethodName()
                    ,e.getLineNumber()));
        }
        System.out.println(sbf.toString());
    }


    @Test
    public void StringTest(){
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s5 = "he"+"llo";
        String s3 = "hello";
        System.out.println("s1==>"+s1.hashCode());
        System.out.println("s2==>"+s2.hashCode());
        System.out.println("s3==>"+s3.hashCode());
        System.out.println("s5==>"+s5.hashCode());
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s5);
        System.out.println(s3.equals(s5));
        System.out.println();

        HashMap<String,Integer> map = new HashMap<>();
        map.put(s1,1);
        map.put(s2,2);
        System.out.println(map.size());


        String n1 = "hello";
        String n2 = "world";
        String n3 = "helloworld";
        System.out.println(n3 == (n1+n2));
        System.out.println("hello"+"world" == "hello"+"world");//ture
        System.out.println((n1+n2) == (n1+n2));//false
    }

    @Test
    public void LengthTest() {
        //byte类型所占的字节数求法
        System.out.println("byte的二进制位数为：" + Byte.SIZE);
        System.out.println("byte所占的字节数为：" + Byte.SIZE/8);     //一个字节占8个二进制位
        //short类型所占的字节数求法
        System.out.println("short的二进制位数为：" + Short.SIZE);
        System.out.println("short所占的字节数为：" + Short.SIZE/8);
        //int类型所占的字节数求法
        System.out.println("int的二进制位数为：" + Integer.SIZE);
        System.out.println("int所占的字节数为：" + Integer.SIZE/8);
        //long类型所占的字节数求法
        System.out.println("long的二进制位数为：" + Long.SIZE);
        System.out.println("long所占的字节数为：" + Long.SIZE/8);
        //float类型所占的字节数求法
        System.out.println("float的二进制位数为：" + Float.SIZE);
        System.out.println("float所占的字节数为：" + Float.SIZE/8);
        //double类型所占的字节数求法
        System.out.println("double的二进制位数为：" + Double.SIZE);
        System.out.println("double所占的字节数为：" + Double.SIZE/8);
        //char类型所占的字节数求法
        System.out.println("char的二进制位数为：" + Character.SIZE);
        System.out.println("char所占的字节数为：" + Character.SIZE/8);
    }
}


