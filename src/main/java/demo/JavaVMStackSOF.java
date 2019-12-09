package demo;

/**
 * Created by yaoguang on 2018/12/12 16:04.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() throws InterruptedException {
        stackLength++;
        Thread.sleep(1000L);
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {

            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + javaVMStackSOF.stackLength);
            e.printStackTrace();
        }

    }
}

