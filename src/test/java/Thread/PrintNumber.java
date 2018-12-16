package Thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PrintNumber {


    private final ReentrantReadWriteLock.WriteLock mLock;
    private final Condition condition1;
    private final Condition condition2;

    public PrintNumber(){

        this.mLock = new ReentrantReadWriteLock().writeLock();
        condition1 = this.mLock.newCondition();
        condition2 = this.mLock.newCondition();
    }

    private AtomicInteger count = new AtomicInteger(0);

    public void print1(){
        while (count.get() < 100){
            try {
                mLock.lock();
                System.out.println(Thread.currentThread().getName() + ": " + 1 + "  "+ count );
                count.set(1+count.get());
                condition2.signalAll();
                condition1.await();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                mLock.unlock();
            }
        }
    }
    public void print2(){
        while (count.get() < 100){
            try {
                mLock.lock();
                System.out.println(Thread.currentThread().getName() + ": " + 1 + "  "+ count );
                count.set(1+count.get());
                condition1.signalAll();
                condition2.await();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                mLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        new Thread(number::print1).start();
        new Thread(number::print2).start();
    }

}
