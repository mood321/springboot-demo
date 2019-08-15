package com.mood.springbootrabbitmq.product;

import com.mood.springbootrabbitmq.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Created by mood321
 * @Date 2019/8/15 0015
 * @Description TODO
 */
@Slf4j
@Component
public class RabbitMQProduct {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFanoutMsg(Users user){
        this.rabbitTemplate.convertAndSend("exchange_fanout",null,user);
    }

    public void sendDirectMsg(Users user,String routingKey) {
        this.rabbitTemplate.convertAndSend("exchange_direct",routingKey,user);
    }

    public void sendTopicMsg(Users user,String routingKey) {
        this.rabbitTemplate.convertAndSend("exchange_topic",routingKey,user);
    }

    public void sendAlternateMsg(Users user, String routingKey) {
        this.rabbitTemplate.convertAndSend("exchange_alt_direct",routingKey,user);
    }

    public void sendTTLDLXDelayMsg(Users user) {
        log.info("============TTLDLX延时队列发送消息=============");
        this.rabbitTemplate.convertAndSend("exchange_ttl_fanout",null,user);
    }

    public void sendDelayMsg(Users user, String routingKey, long expiration) {
        log.info("============delay exchange延时队列发送消息=============");
        this.rabbitTemplate.convertAndSend(
                "exchange_delay",
                routingKey,
                user,
                message -> {
                    message.getMessageProperties().setHeader("x-delay",expiration);
                    return message;
                }
        );
    }
}
