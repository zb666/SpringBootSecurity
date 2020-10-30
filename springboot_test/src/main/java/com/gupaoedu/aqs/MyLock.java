package com.gupaoedu.aqs;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyLock {

    private Sync sync = new Sync();

    public void lock(){
        sync.acquire(1);
    }

    public void unlock(){
        sync.release(1);
    }

    static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0,1);//尝试去获取锁 这里的 0,1代表的是state的状态
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0); //0代表无锁 withStatus有5种
            return true;
        }
    }

}
