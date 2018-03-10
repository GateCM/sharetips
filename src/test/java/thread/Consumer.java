/**
 * 
 */
package thread;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: Consumer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2018年3月8日 下午8:54:53
 *
 */
public class Consumer implements Runnable {
	private final BlockingQueue<Integer> num;

	public Consumer(BlockingQueue<Integer> num) {
		this.num = num;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				System.out.println("                   消费者消费第 " + num.take() + " 个产品");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
