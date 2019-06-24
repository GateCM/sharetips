package jvm.loader;

/**
 * Created by yaoguang on 2019/6/4 19:12.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class HotSwapClassLoader extends ClassLoader {


    public HotSwapClassLoader (){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
