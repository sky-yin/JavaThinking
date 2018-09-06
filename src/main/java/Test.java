import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //guava  google的库
        List<Use> list = new ArrayList<>();
        list.add(new Use("yin",10));
        list.add(new Use("zhi",11));
        list.add(new Use("hui",8));

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        if(integerList.stream().anyMatch(s -> s != 2)){
            integerList.forEach(a -> System.out.println(a));
        }

        List<String> s = new ArrayList<>();
        System.out.println(s.isEmpty()?"1":"2");
        list.stream().map(Use::getName).filter(x -> !"yi".equals(x)).collect(Collectors.toList()).forEach(e -> System.out.println(e));

    /**
        //map应用到每一个元素上   映射
//        Function<<Integer,Integer>  输入和输出
        list.stream().map(x -> x+1).collect(Collectors.toList());
        //归约
//        Function<Integer,Integer,Integer>
        list.stream().reduce((acc,item) ->acc+item);
        //过滤
//        Function<Integer,Boolean>
        list.stream().filter();

        list.stream().sorted().collect(Collectors.joining(this,","));

        //Lazy
        Stream<User> users = list.stream().map(UserDao::getById);
        List<User> 亅= users.limit(10).collect(Collectors.toList());
    **/
    }

    @org.junit.Test
    public void test(){

    }

    public boolean testing(String s,String p){
        String allString = ".*";
        //验证  .*   有的话直接通过
        if(p.indexOf(allString) > 0)
            return true;
        if(p.length() < 1 || p.charAt(0) == '*')
            return false;

        StringBuilder str = new StringBuilder();

        String[] strList = p.split("\\*");

        System.out.println(Pattern.matches(s,p));

        for (int i = 0; i < strList.length; i++) {

        }

        return false;
    }

    public int maxArea(int[] height) {
        int max = 0;
        int maxLength=0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                if (height[i]<height[j]){
                    if (j-i>maxLength)
                        max = Math.min(height[i],height[j])*(j-i);
                }
            }
        }
        return max;
    }


}

class Use{
    String name;
    Integer age;

    public Use(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}