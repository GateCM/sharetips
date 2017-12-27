/**
 * 
 */
package com.gatecm.tip.jms;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.gatecm.tip.entity.MemberBasic;

/**
 * @Description: TODO()
 * @author chenxiaohui
 * @date 2017年12月26日 上午10:04:49
 *
 */
@Service("producer")
public class Producer {
//	@Autowired
//	// 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
//	private JmsMessagingTemplate jmsMessagingTemplate;
//
//	// 发送消息，destination是发送到的队列，message是待发送的消息
//	public void sendMessage(Destination destination, MemberBasic message) {
//		jmsMessagingTemplate.convertAndSend(destination, message);
//	}
//
//	@JmsListener(destination = "out.queue")
//	public void receiveMessage(String text) throws InterruptedException {
//		Thread.sleep(100);
//		System.err.println("返回的报文：" + text);
//	}

}
