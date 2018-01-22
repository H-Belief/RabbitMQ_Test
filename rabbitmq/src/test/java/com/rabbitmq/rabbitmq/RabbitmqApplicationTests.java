package com.rabbitmq.rabbitmq;

import com.rabbitmq.rabbitmq.test.fanout.FanoutSend;
import com.rabbitmq.rabbitmq.test.manyToMany.ManyToManySender1;
import com.rabbitmq.rabbitmq.test.manyToMany.ManyToManySender2;
import com.rabbitmq.rabbitmq.test.oneToMany.Sender;
import com.rabbitmq.rabbitmq.test.oneToOne.Send;
import com.rabbitmq.rabbitmq.test.topic.TopicSend;
import com.rabbitmq.rabbitmq.test.userQueueTest.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	private Send send;

	@Autowired
	private Sender sender;

	@Autowired
	private ManyToManySender1 manyToManySender1;

	@Autowired
	private ManyToManySender2 manyToManySender2;

	@Autowired
	private UserSender userSender;

	@Autowired
	private TopicSend topicSend;

	@Autowired
	private FanoutSend fanoutSend;

	//测试oneToOne
	@Test
	public void contextLoads() {
		send.send();
	}
	//测试OneToMany
	@Test
	public void oneToMany(){
		sender.send();
	}

	//测试ManyToMany
	@Test
	public void ManyToMany(){
		manyToManySender1.send();
		manyToManySender2.send();
	}

	//测试集体传值
	@Test
	public void userSender(){
		userSender.send();
	}

	//测试exchange  biding
	@Test
	public void topicTest(){
		topicSend.send();
	}

	//测试fanout
	@Test
	public void fanoutTest(){
		fanoutSend.send();
	}

}
