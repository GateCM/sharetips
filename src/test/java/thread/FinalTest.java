/**
 * 
 */
package thread;

import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.mockito.MockitoFramework;

import com.gatecm.tip.entity.MemberBasic;

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
