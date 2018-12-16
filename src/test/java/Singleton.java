public class Singleton{

    private static Singleton singleton = null;

    private Singleton(){};

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized(Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                System.out.println(singleton.hashCode());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                System.out.println(singleton.hashCode());
            }
        });
        t1.start();
        t2.start();
    }
}



//class Singleton{
//
//    private Singleton singleton ;
//
//    private Singleton(){};
//
//    public Singleton getInstance() {
//        if (singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
//}