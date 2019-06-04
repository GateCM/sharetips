package test;

/**
 * Created by yaoguang on 2019/3/25 20:21.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class SlowQuery {


    public Long query(Long seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
//        System.err.println(Thread.currentThread().getName()+"end");
        return seconds+10;
    }
}
