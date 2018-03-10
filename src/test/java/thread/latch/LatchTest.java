/**
 * 
 */
package thread.latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: LatchTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2018年3月9日 下午1:50:46
 *
 */
public class LatchTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int num = 100;

		CountDownLatch startGate = new CountDownLatch(1);

		Random random = new Random();
		for (int i = 0; i < num; i++) {
			Thread thread = new Thread() {
				public void run() {
					try {
						Thread.sleep(random.nextInt(3000));
						System.err.println("--------");
						startGate.await();
						System.err.println(Thread.currentThread().getName() + " 开始执行...");
						 Thread.sleep(3000);
						for (int i = 0; i < 10; i++) {
//							System.err.println(Thread.currentThread().getName() + " 执行第" + i + " 次");
						}
						System.err.println(Thread.currentThread().getName() + " 执行结束");

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			};
			thread.start();
		}

		long start = System.nanoTime();
		 Thread.sleep(3000);
		System.err.println("===================");
		startGate.countDown();

	}

}
