package other.printInOrder1114;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Easy
 * 信号量的办法也可以或者CountDownLatch 计数，但这种方式就只征对测例了
 * @author lin  2022/4/13 11:28
 */
public class Foo {

    private final ReentrantLock lock ;
    private final Condition firCon ;
    private final Condition secCon ;
    private final Condition thirdCon ;

    int num = 1;
    public Foo() {
        //必须共用一把锁，开始想法有问题
        lock = new ReentrantLock();

        firCon = lock.newCondition();
        secCon = lock.newCondition();
        thirdCon = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException{

        lock.lock();
        try {
            while (num != 1){
                firCon.await();
            }
            printFirst.run();
            num = 2;
            secCon.signal();
        }finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException{

        lock.lock();
        try {
            while (num != 2){
                secCon.await();
            }
            printSecond.run();
            thirdCon.signal();
        }finally {
            lock.unlock();
        }

    }


    public void third(Runnable printThird) throws InterruptedException {

        lock.lock();
        try {
            while (num != 2){
                thirdCon.await();
            }
            printThird.run();
            firCon.signal();
        }finally {
            lock.unlock();
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }

}
