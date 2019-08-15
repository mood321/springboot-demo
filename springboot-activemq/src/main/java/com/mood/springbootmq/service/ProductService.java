package com.mood.springbootmq.service;

import com.mood.springbootmq.model.Users;

import javax.jms.JMSException;

/**
 * @Created by mood321
 * @Date 2019/8/14 0014
 * @Description TODO
 */
public interface ProductService {

    void sendQueueMsg(String msg) throws JMSException;

    void sendQueueMsg(Users user) throws JMSException;

    void send2WayQueueMsg(String msg) throws JMSException;

    void sendACKQueueMsg(String msg) throws JMSException;

    void sendTopicMsg(String msg) throws JMSException;

    void sendTopicMsg(Users user) throws JMSException;

    void sendDelayTopicMsg(String msg) throws JMSException;

    void sendDelayTopicMsg(String msg,long time) throws JMSException;
}
