package materiel.floor;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import materiel.domain.AdMaterielAttr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoguang on 2019/4/22 11:50.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
@Data
public class MaterielSection {
    private String domain;

    private List<SimpleSectionAttr> attrList = new ArrayList<>();

    public MaterielSection(String domain){
        this.domain = domain;
    }

    public MaterielSection build(SimpleSectionAttr attr){
        attrList.add(attr);
        return this;
    }

    public String attrToJson(){
        JSONObject jsonObject = new JSONObject();
        for (SimpleSectionAttr sectionAttr : attrList) {
            jsonObject.put(sectionAttr.getKey(),sectionAttr.getValue());
        }
       return jsonObject.toString();
    }

    public List<AdMaterielAttr> attrToModel(Long materielId){
        List<AdMaterielAttr> adMaterielAttrs = new ArrayList<>();
        for (SimpleSectionAttr sectionAttr : attrList) {
            AdMaterielAttr adMaterielAttr = new AdMaterielAttr();
            adMaterielAttr.setAttrKey(sectionAttr.getKey());
            adMaterielAttr.setAttrVal(sectionAttr.getValue());
            adMaterielAttr.setDomain(domain);
            adMaterielAttr.setMaterielId(materielId);
            adMaterielAttrs.add(adMaterielAttr);
        }
        return adMaterielAttrs;
    }
}
