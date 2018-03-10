/**
 * 
 */
package thread;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: Producer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @date 2018年3月8日 下午8:48:28
 *
 */
public class Producer implements Runnable {

	private final BlockingQueue<Integer> num;
	private int i  =0;

	public Producer(BlockingQueue<Integer> num) {
		this.num = num;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(2000);
				i++;
				System.err.println("生产者生产第 "+i+" 个产品");
				num.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
