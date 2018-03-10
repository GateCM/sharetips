/**
 * 
 */
package com.gatecm.tip.service;

import com.gatecm.tip.dto.vo.WebStatusVo;

/**
 * @Description: TODO(网站监控)
 * @author chenxiaohui
 * @date 2018年1月9日 下午3:13:05
 *
 */
public interface MonitorService {

	/**
	 * 获取首页显示状态数据
	 * 
	 * @return
	 */
	Rrs<WebStatusVo> indexStatus();

}
