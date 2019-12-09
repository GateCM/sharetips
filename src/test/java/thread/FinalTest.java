/**
 * 
 */
package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
* @ClassName: FinalTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chenxiaohui
* @date 2018年3月5日 下午1:20:26
*
*/
public class FinalTest {
	

	/**
	 *@param args
	 */
	public static void main(String[] args) {
		 BlockingQueue<Integer> num = new LinkedBlockingQueue<>();
		 
		 Producer producer = new Producer(num);
		 
		 Consumer consumer = new Consumer(num);
		 
		 
		 Thread thread = new Thread(producer);
		 thread.start();
		 
		 Thread thread2 = new Thread(consumer);
		 thread2.start();
		 
		
		
		
	}

}
