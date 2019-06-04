package materiel.floor;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: dinghaijun(宿草)
 * @Description: description
 * @Date: Created in 11:34 AM 2019/2/26
 * @Modified By: Copyright(c) cai-inc.com
 */
@AllArgsConstructor
public enum AdMaterielAttrDomainEnums {
    BASE("base","基础信息"),BANNER("banner","banner"),FLOOR("floor","楼层"),BOTTOM("bottom","底部"),LOGO("banner","banner"),;
    @Getter
    private String code;
    @Getter
    private String desc;

    public static AdMaterielAttrDomainEnums of(String code){
        for(AdMaterielAttrDomainEnums adMaterielAttrDomainEnums : AdMaterielAttrDomainEnums.values()){
            if(adMaterielAttrDomainEnums.getCode().equals(code)){
                return adMaterielAttrDomainEnums;
            }
        }
        return null;
    }
}
