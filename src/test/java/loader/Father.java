package loader;

public class Father {

    static int x = 1;
    static {
        System.out.println("Father is one of "+ x);
    }

    static {
        x++;
        System.out.println("Father is two of " +x);
    }

    public Father(){
        System.out.println("the father is 构造");
    }

    public void display(){
        x++;
        System.out.println("the father is display");
    }
}

class Son extends Father{
    static int x = 1;
    static {
        System.out.println("Son is one of "+ x);
    }

    static {
        x++;
        System.out.println("Son is two of " +x);
    }

    public Son(){
        System.out.println("the son is 构造");
    }

    public void display(){
        x++;
        System.out.println("the son is display");
    }

    public static void main(String[] args) {
        Son man = new Son();
        man.display();
    }
}
