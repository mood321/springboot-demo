package com.mood.springbootrabbitmq;

import com.mood.springbootrabbitmq.model.Users;
import com.mood.springbootrabbitmq.product.RabbitMQProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

    @Autowired
    private RabbitMQProduct rabbitMQProduct;

    @Test
    public void fanoutExchangeTest() {
        rabbitMQProduct.sendFanoutMsg(new Users("张三"));
    }

    @Test
    public void directExchangeTest() {
        rabbitMQProduct.sendDirectMsg(new Users("李四"),"bbb");
    }

    @Test
    public void topicExchangeTest() {
        rabbitMQProduct.sendTopicMsg(new Users("王五"),"aaa.bbb");
        rabbitMQProduct.sendTopicMsg(new Users("赵六"),"aaa.bbb.ccc");
    }

    @Test
    public void alternateExchangeTest() {
        rabbitMQProduct.sendAlternateMsg(new Users("田七"),"aaa");
        rabbitMQProduct.sendAlternateMsg(new Users("庞八"),"bbb");
    }

    @Test
    public void delayTTLDLXExchangeTest() throws InterruptedException {
        rabbitMQProduct.sendTTLDLXDelayMsg(new Users("陈九"));
        TimeUnit.SECONDS.sleep(15);
    }

    @Test
    public void delayExchangeTest() throws InterruptedException {
        rabbitMQProduct.sendDelayMsg(new Users("周十"),"aaa",10000);
        rabbitMQProduct.sendDelayMsg(new Users("吴十一"),"aaa",5000);
        TimeUnit.SECONDS.sleep(15);
    }

}
