package materiel.materiel;

import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * Created by yaoguang on 2019/4/24 15:01.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public abstract class MaterielBuilder {
    private Set<String> domainSet;

    public void checkDomain(String domain) {
        if (StringUtils.isEmpty(domain)) {
            throw new RuntimeException("domain 不能为空");
        }
        if(!domainSet.contains(domain)){
            throw new RuntimeException("domain 不存在");
        }
    }
}
