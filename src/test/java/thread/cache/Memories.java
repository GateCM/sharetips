/**
 * 
 */
package thread.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;



/**
 * @ClassName: Memories
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenxiaohui
 * @param <V>
 * @param <T>
 * @date 2018年3月9日 下午2:48:57
 *
 */
public class Memories {

	private final ConcurrentHashMap<String, Future<Integer>> cache = new ConcurrentHashMap<>();

	public Integer getV(final String t) throws InterruptedException, ExecutionException {
		Integer num = null;
		Future<Integer> future = cache.get(t);

		if (future == null) {
			Callable<Integer> eval = new Callable<Integer>() {
				public Integer call() {
					System.err.println("长时间的计算...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return 23;
				}
			};
			
			FutureTask<Integer> futureTask = new FutureTask<>(eval);
			
			
			cache.put(t, (Future<Integer>) futureTask);
			future = futureTask;
			futureTask.run();	
		}

		try {
			return future.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;

	}

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Memories Memories = new Memories();
		
		System.err.println(Memories.getV("13"));
		System.err.println(Memories.getV("12"));
		System.err.println(Memories.getV("13"));
		System.err.println(Memories.getV("12"));
		
		

	}

}
