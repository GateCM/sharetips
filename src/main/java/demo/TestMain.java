package demo;


import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Auther: mengmei
 * @Date: 2018/12/17 0017
 */
public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final User user = new User();
        user.setId(1);
        user.setName("zs");
        user.setAge(2);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User();
                user.setId(1);
                user.setName("zs");
                user.setAge(2);
                user.getName();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.setName("wu");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.setName("ls");
            }
        });

        Thread t4 = new Thread(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.getName();
            }
        });

        Thread t5 = new Thread(new Runnable() {
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.getName();
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");
        t5.setName("t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        countDownLatch.countDown();

    }
}
