package Thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConditionTest {

    @Test
    public void main() throws Exception {
        final ReentrantLock mLock = new ReentrantLock();
        final Condition condition = mLock.newCondition();

        Thread thread1 = new Thread((Runnable)() ->{
            try {
                mLock.lock();
                System.out.println("我要等一个信号:"+this);
                condition.await();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("拿到一个信号:"+this);
            mLock.unlock();
        },"waitedThread1");

        thread1.start();

        Thread thread2 =  new Thread((Runnable)()->{
            mLock.lock();

            System.out.println("我发出一个信号");

            condition.signalAll();
            try {

                Thread.sleep(3000);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("我释放了锁");
            mLock.unlock();
        });

        thread2.start();
    }

}
