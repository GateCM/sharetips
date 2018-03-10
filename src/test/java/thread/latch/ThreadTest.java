/**
 * 
 */
package thread.latch;

import java.util.concurrent.CountDownLatch;

import com.sun.tools.javah.resources.l10n;

/**
 * @ClassName: ThreadTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2018年3月9日 下午1:45:43
 *
 */
public class ThreadTest implements Runnable {
	private final CountDownLatch startGate;
	private final CountDownLatch endGate;

	public ThreadTest(CountDownLatch startGate, CountDownLatch endGate) {
		this.startGate = startGate;
		this.endGate = endGate;
	}

	@Override
	public void run() {
		try {
			startGate.await();
			Thread.sleep(3000);
			System.err.println(Thread.currentThread().getName() + " 开始执行...");
			Thread.sleep(3000);
			for (int i = 0; i < 10; i++) {
				System.err.println(Thread.currentThread().getName() + " 执行第" + i + " 次");
			}
			System.err.println(Thread.currentThread().getName() + " 执行结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			endGate.countDown();
		}

	}

}
