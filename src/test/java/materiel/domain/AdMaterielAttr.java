package materiel.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created By caobenxi on 2019/2/20.
 *
 * 物料属性信息副本
 */
@Data
public class AdMaterielAttr {
    /**
     *   主键Id
     */
    private Long id;

    /**
     *   物料ID
     */
    private Long materielId;

    /**
     *   base 基础信息 banner floor楼层 bottom底部
     */
    private String domain;

    /**
     *   属性key
     */
    private String attrKey;

    /**
     *   属性值
     */
    private String attrVal;

    /**
     *   用于版本控制
     */
    private Long version;

    /**
     *   创建时间
     */
    private Date gmtCreate;

    /**
     *   修改时间
     */
    private Date gmtModified;
}
