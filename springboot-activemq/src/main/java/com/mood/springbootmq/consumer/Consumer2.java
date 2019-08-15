package com.mood.springbootmq.consumer;

import com.mood.springbootmq.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Created by mood321
 * @Date 2019/8/14 0014
 * @Description TODO
 */
@Slf4j
@Component
public class Consumer2 {

    @JmsListener(destination = "queue_string_test",containerFactory = "queueListenerFactory")
    public void receiveQueue(String text) {
        log.info("consumer2收到queue_string信息:{}",text);
    }

    @JmsListener(destination = "queue_user_test",containerFactory = "queueListenerFactory")
    public void receiveQueue(Users user) {
        log.info("consumer2收到queue_user信息:{}",user.toString());
    }

    @JmsListener(destination = "topic_string_test",containerFactory = "topicListenerFactory")
    public void receiveTopic(String text) {
        log.info("consumer2收到topic_string信息:{}",text);
    }

    @JmsListener(destination = "topic_user_test",containerFactory = "topicListenerFactory")
    public void receiveTopic(Users user) {
        log.info("consumer2收到topic_user信息:{}",user.toString());
    }

    @JmsListener(destination = "topic_delay_string_test",containerFactory = "topicListenerFactory")
    public void receiveDelayTopic(String text) {
        log.info("consumer2收到topic_delay_string延时信息:{},接收时间:{}",text, LocalDateTime.now());
    }
}
