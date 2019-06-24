package jvm.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yaoguang on 2019/6/6 11:37.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class TestStart {


    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

        InputStream in = new FileInputStream("/Users/chenxiaohui/IdeaProjects/sharetips/target/test-classes/jvm/loader/TestJvm.class");
        byte[] b = new byte[in.available()];
        in.read(b);
        in.close();


        System.out.println(JavaClassExecuter.execute(b));


    }
}
