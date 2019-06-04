package materiel.floor;


import lombok.AllArgsConstructor;

/**
 * Created by yaoguang on 2019/4/22 11:32.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
@AllArgsConstructor
public class SimpleSectionAttr implements SectionAttr{

    private String key;
    private String value;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
