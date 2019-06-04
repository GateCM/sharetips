package materiel.materiel;

import materiel.floor.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaoguang on 2019/4/23 14:02.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class BrandMateriel extends MaterielBuilder {

    private static final Set<String> DOMAIN = new HashSet<>(Arrays.asList(AdMaterielAttrDomainEnums.BASE.getCode(), AdMaterielAttrDomainEnums.BANNER.getCode()));

    public MaterielSection buildBannerFloor(String backgroundColor, String url, String targetUrl) {
        MaterielSection bannerSection = new MaterielSection(AdMaterielAttrDomainEnums.BANNER.getCode());
        bannerSection.build(new BackgroundColorAttr(backgroundColor));
        bannerSection.build(new UrlAttr(url));
        bannerSection.build(new TargetUrlAttr(targetUrl));
        return bannerSection;
    }

    public MaterielSection buildLogoFloor(String backgroundColor, String url) {
        MaterielSection bannerSection = new MaterielSection(AdMaterielAttrDomainEnums.LOGO.getCode());
        bannerSection.build(new BackgroundColorAttr(backgroundColor));
        bannerSection.build(new UrlAttr(url));
        return bannerSection;
    }

}
