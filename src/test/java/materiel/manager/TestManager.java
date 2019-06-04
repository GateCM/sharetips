package materiel.manager;

import materiel.domain.AdMaterielAttr;
import materiel.floor.*;
import materiel.materiel.MaterielFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yaoguang on 2019/4/22 11:51.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class TestManager {

    public static void main(String[] args) {


        MaterielSection bannerFloor = MaterielFactory.buildBrandMateriel().buildBannerFloor("#FFFFFF","http://www.baidu.com","http://www.baidu.com/image/23042342");
        MaterielSection logoFloor = MaterielFactory.buildBrandMateriel().buildLogoFloor("#FFFFFF","http://www.baidu.com");



        for (SimpleSectionAttr sectionAttr : bannerFloor.getAttrList()) {
            System.out.println(sectionAttr.getKey()+" = "+sectionAttr.getValue());
        }

        System.out.println(bannerFloor.attrToJson());

        Long materielId =10L;
        List<AdMaterielAttr> adMaterielAttrs  = bannerFloor.attrToModel(materielId);
        for (AdMaterielAttr attr : adMaterielAttrs){
            System.out.println(attr.toString());
        }

        Set<String> strings = new HashSet<>();
       MaterielFactory.buildBrandMateriel().checkDomain("base");

    }
}
