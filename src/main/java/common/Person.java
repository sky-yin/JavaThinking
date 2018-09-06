package common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class Person {
    private int age;
    private String name;
    public Person(int age, String name){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void add(){
        System.out.println(2);
    }

    public static void main(String[] args) throws Exception {
        Object p = new Person(1,"yin");
//        BeanInfo beanInfo = Introspector.getBeanInfo(p,Person.class);

    }
}
