package com.gatecm.obsession.TEMP;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 禾木 dizhikang@cai-inc.com
 * @create: 2019-01-23 10:20
 **/
@Data
public class AdDistrictInfo implements Serializable{

    private static final long serialVersionUID = 6388166552893433115L;
    /**
     * 区划id
     */
    private String id;
    /**
     * 区划编码
     */
    private String code;
    /**
     * 是否叶子节点
     */
    private Boolean isLeaf;
    /**
     * 区划名称
     */
    private String name;
    /**
     * 子节点
     */
    private List<AdDistrictInfo> children;
}
