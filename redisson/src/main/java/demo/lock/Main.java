package demo.lock;

import demo.RedissonDemo;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhouxuan on 2019-07-08
 *
 * @Author: zhouxuan
 * @Date: 2019-07-08
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RedissonClient redissonClient1 = RedissonDemo.init();
        RedissonClient redissonClient2 = RedissonDemo.init();
//        reentrantLockDemo(redissonClient1, redissonClient2);
//        readWriteLockDemo(redissonClient1, redissonClient2);
        semaphoreDemo(redissonClient1, redissonClient2);

    }

    private static void reentrantLockDemo(RedissonClient redissonClient1, RedissonClient redissonClient2) throws InterruptedException {
        //hint: 底层的redis存储方式使用的是hash
        RLock lock1 = redissonClient1.getLock("reentrant_lock_demo_key");
        RLock lock2 = redissonClient2.getLock("reentrant_lock_demo_key");
        System.out.println("thread 1 try lock: " + lock1.tryLock());
        System.out.println("thread 2 try lock: " + lock2.tryLock());
        System.out.println("thread 1 try lock again: " + lock1.tryLock());
        lock1.unlock();
        System.out.println("thread 2 try unlock after 1 time unlock: " + lock2.tryLock());
        lock1.unlock();
        System.out.println("thread 2 try unlock after 2 times unlock: " + lock2.tryLock());
        lock2.unlock();
        System.out.println("thread 1 try lock with timeout: " + lock1.tryLock(10, 5, TimeUnit.SECONDS));
        System.out.println("thread 2 try lock before timeout: " + lock2.tryLock());
        System.out.println("thread 2 try lock after timeout: " + lock2.tryLock(5, 1, TimeUnit.SECONDS));
    }

    private static void readWriteLockDemo(RedissonClient redissonClient1, RedissonClient redissonClient2) {
        RReadWriteLock rReadWriteLock1 = redissonClient1.getReadWriteLock("read_write_lock_demo_key");
        RReadWriteLock rReadWriteLock2 = redissonClient2.getReadWriteLock("read_write_lock_demo_key");
        System.out.println("thread 1 try read lock: " + rReadWriteLock1.readLock().tryLock());
        System.out.println("thread 2 try read lock: " + rReadWriteLock2.readLock().tryLock());
//        System.out.println("thread 1 try write lock: " + rReadWriteLock1.writeLock().tryLock());
//        rReadWriteLock2.readLock().unlock();
//        System.out.println("thread 1 try write lock after thread 2 unlocked: " + rReadWriteLock1.writeLock().tryLock());
//        rReadWriteLock1.readLock().unlock();
//        System.out.println("thread 1 try write lock after thread 1&2 unlocked: " + rReadWriteLock1.writeLock().tryLock());
//        rReadWriteLock1.writeLock().unlock();
//        System.out.println("thread 2 try write lock after thread 1 unlocked write lock: " + rReadWriteLock2.writeLock().tryLock());
    }

    private static void semaphoreDemo(RedissonClient redissonClient1, RedissonClient redissonClient2) {
        RSemaphore semaphore1 = redissonClient1.getSemaphore("semaphore_demo_key1");
        RSemaphore semaphore2 = redissonClient2.getSemaphore("semaphore_demo_key1");
        semaphore1.trySetPermits(3);
//        System.out.println("thread 1 try acquire: " + semaphore1.tryAcquire());
//        System.out.println("thread 1 try acquire: " + semaphore1.tryAcquire());
//        System.out.println("thread 2 try acquire: " + semaphore2.tryAcquire());
//        System.out.println("thread 2 try acquire: " + semaphore2.tryAcquire());
//        semaphore1.release();
//        semaphore1.release();
//        semaphore2.release();
    }
}
