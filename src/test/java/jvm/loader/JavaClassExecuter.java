package jvm.loader;

import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by yaoguang on 2019/6/6 11:29.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class JavaClassExecuter {

    public static String execute(byte[] classByte) throws IllegalAccessException, InstantiationException {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "jvm/loader/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();

        Class clazz = loader.loadByte(modiBytes);
        Object o  = clazz.newInstance();
        try {
            Method method = clazz.getMethod("aaaa");
            method.invoke(o);
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
