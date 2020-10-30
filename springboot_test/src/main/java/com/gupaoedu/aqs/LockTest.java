package com.gupaoedu.aqs;

public class LockTest {

    static int count = 0;
    static MyLock myLock = new MyLock();

    public static void main(String[] args) throws InterruptedException {
        testLoad();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    myLock.lock();
                    for (int i = 0; i < 1000; i++) {
                        count++;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    myLock.unlock();
                }
            }
        };

        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println(count);

    }

    private static void testLoad() {
        LockTest.class.getDeclaredFields();
        System.out.println(System.getProperty("java.ext.dirs"));
    }

}
