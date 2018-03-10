/**
 * 
 */
package com.gatecm.tip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gatecm.tip.dto.vo.WebStatusVo;
import com.gatecm.tip.mapper.MemberBasicDao;
import com.gatecm.tip.service.MonitorService;
import com.gatecm.tip.service.Rrs;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2018年1月9日 下午3:16:55
 *
 */
@Service("monitorService")
public class MonitorServiceImpl implements MonitorService {

	@Autowired
	private MemberBasicDao memberBasicDao;

	@Override
	public Rrs<WebStatusVo> indexStatus() {
		WebStatusVo webStatusVo = new WebStatusVo();
		Integer actMemberNum = memberBasicDao.selectAllCount();
		webStatusVo.setActMemberNum(actMemberNum);
		return new Rrs<>(true, webStatusVo);
	}

}
