/**
 * 
 */
package com.gatecm.tip.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.gatecm.tip.entity.MemberBasic;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月26日 上午10:08:04
 *
 */
@Component
public class Consumer {

//	@JmsListener(destination = "mytest.queue")
//	@SendTo("out.queue")
//	public String receiveQueue(MemberBasic text) {
//		System.err.println("Consumer收到的报文为：" + text.getPassword());
//		return "return：" + text.getPassword();
//	}

}
