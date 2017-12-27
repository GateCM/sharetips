///**
// * 
// */
//package com.gatecm.tip.jms;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @Description: TODO()
// * @author chenxiaohui
// * @date 2017年12月26日 上午10:10:34
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JmsTest {
//
//	@Autowired
//	private Producer producer;
//
////	@Test
////	public void contextLoads() throws InterruptedException {
////		Destination destination = new ActiveMQQueue("mytest.queue");
////		MemberBasic memberBasic;
////		for (int i = 0; i < 1; i++) {
////			memberBasic = new MemberBasic();
////			memberBasic.setPassword("pwd"+i);
////			producer.sendMessage(destination, memberBasic);
////		}
////		Thread.sleep(100000);
////	}
//
//	// @Test
//	// public void contextLoads() throws InterruptedException {
//	// Destination destination = new ActiveMQQueue("mytest.queue");
//	//
//	// for(int i=0; i<100; i++){
//	// producer.sendMessage(destination, "myname is chhliu!!!");
//	// }
//	// }
//
//}
