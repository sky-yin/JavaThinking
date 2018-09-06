import Util.LRU;
import Util.TailInvoke;
import org.junit.Test;

import java.util.*;

public class ListTest {

    public static final String CITY = "北京 上海 深圳 广州 开封";

    @Test
    public void test(){
        /**
        List<Map<String,Long>> list = new ArrayList<>();
        HashMap<String,Long> map;
        for (int i = 0; i < 50000; i++) {
            map = new HashMap<>();
            map.put("total",10l);
            map.put("money",100l);
            list.add(map);
        }

        list.stream().reduce((a,b) ->{
            Set<String> keySet = a.keySet();
            keySet.stream().forEach(s ->a.put(s,a.get(s)+b.get(s)));
            return a;
        });


        ThreadLocal<Long> startTime = new ThreadLocal<Long>();
        startTime.set(System.currentTimeMillis());
        Long money = list.stream().map(a -> a.get("money")).reduce(Long::sum).get();
        System.out.println("请求耗时:" + (System.currentTimeMillis() - startTime.get()));
        **/
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        System.out.println(list2.toString());
    }

    @Test
    public void LRUTest(){

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        char s = 'a';
        char[] a = new char[3];

        for (int i = 0; i < 100; i++) {
            a[0] = s;
            a[1] = s;
            a[2] = s;
            map.put(String.valueOf(a),String.valueOf(a));
            s = (char) (s + 1);
        }
        s = 'z';
        for (int i=0;i<10;i++){
            a[0] = s;
            a[1] = s;
            a[2] = s;
            System.out.println(map.get(String.valueOf(a)));
            s = (char) (s-1);
        }

        for (Map.Entry<String, String > entry:map.entrySet()){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

    }

    @Test
    public void LRU2Test(){

        LRU<String, String> map = new LRU<>(10);
        char s = 'a';
        char[] a = new char[3];

        for (int i = 0; i < 10; i++) {
            a[0] = s;
            a[1] = s;
            a[2] = s;
            map.put(String.valueOf(a),String.valueOf(a));
            s = (char) (s + 1);
        }
        s = 'j';
        for (int i=0;i<10;i++){
            a[0] = s;
            a[1] = s;
            a[2] = s;
            System.out.println(map.get(String.valueOf(a)));
            s = (char) (s-1);
        }
        System.out.println("-----");
        map.put("kkk","kkk");
        System.out.println("-----");
        for (Map.Entry<String, String > entry:map.getAll()){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }

    }

    @Test
    public void testYin(){
        System.out.println(TailInvoke.factorialTailRecursion(1,20).invoke());
    }

}
