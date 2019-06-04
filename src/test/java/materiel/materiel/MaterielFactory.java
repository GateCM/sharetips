package materiel.materiel;


/**
 * Created by yaoguang on 2019/4/23 13:57.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class MaterielFactory {

    public static BrandMateriel buildBrandMateriel() {
        return new BrandMateriel();
    }
}
