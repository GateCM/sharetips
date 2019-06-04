package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoguang on 2018/12/12 14:49.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class HeapOOM {

    static class OOMObject{}


    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
