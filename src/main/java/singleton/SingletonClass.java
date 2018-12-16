package singleton;

public class SingletonClass {
    private final SingletonClass INSTANCE = new SingletonClass();

    private SingletonClass(){}

    public SingletonClass getINSTANCE() {
        return INSTANCE;
    }

    public void show(){
        System.out.println("this is the singleton");
    }
}
