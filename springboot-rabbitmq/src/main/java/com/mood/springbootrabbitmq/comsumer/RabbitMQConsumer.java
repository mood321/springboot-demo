package com.mood.springbootrabbitmq.comsumer;

import com.mood.springbootrabbitmq.model.Users;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * basicNack(deliveryTag,multiple,requeue)
 * multiple:是否批量操作，true是，false否，true的时候deliveryTag以下的消息都会重回或者丢弃
 * requeue:是否回队，true是，false是丢弃，true的时候回到队列可能被其他消费者消费
 * basicReject(deliveryTag,requeue):也可以丢弃消息或者重回队列，区别是他不支持批量操作
 * basicRecover(requeue):是重发消息的意思，参数设置为true意味着消息回到队列里可能会被分配给其他消费者，设置为false意味着还分配给该消费者
 * 因为出现问题多半是处理业务出现异常，重发没意义，自己补偿即可
 * nack和reject丢弃消息时，如果交换器绑定了死信队列，还可以触发死信队列
 * @Created by mood321
 * @Date 2019/8/15 0015
 * @Description TODO
 */
@Component
@Slf4j
public class RabbitMQConsumer {

    /**
     * fanout
     */
    @RabbitListener(queues="queue_fanout_1")
    public void receiveQueue1SendFanoutMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_fanout_1收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_fanout_1:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_fanout_1收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * fanout
     */
    @RabbitListener(queues="queue_fanout_2")
    public void receiveQueue2SendFanoutMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_fanout_2收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_fanout_2:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
           channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_fanout_2收到信息:{},降级补偿机制",Users.getName());
        }
    }


    /**
     * direct
     * bindingkey:aaa
     */
    @RabbitListener(queues="queue_direct_1")
    public void receiveQueue1SendDirectMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_direct_1收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_direct_1:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
           channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_direct_1收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * direct
     * bindingkey:bbb
     */
    @RabbitListener(queues="queue_direct_2")
    public void receiveQueue2SendDirectMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_direct_2收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_direct_2:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
          channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_fanout_2收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * topic
     * bindingkey:aaa.*
     */
    @RabbitListener(queues="queue_topic_1")
    public void receiveQueue1SendTopicMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_topic_1收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_topic_1:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
          channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_topic_1收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * topic
     * bindingkey:aaa.#
     */
    @RabbitListener(queues="queue_topic_2")
    public void receiveQueue2SendTopicMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_topic_2收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_topic_2:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
           channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_topic_2收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * topic
     * alternate的正常队列
     * bindingkey:aaa
     */
    @RabbitListener(queues="queue_alt_direct")
    public void receiveQueueSendAltTopicMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_alt_direct收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_alt_direct:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_alt_direct收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * fanout
     * alternate的正常队列的备份队列
     */
    @RabbitListener(queues="queue_alt_fanout")
    public void receiveQueueSendAltFanoutMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_alt_fanout收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_alt_fanout:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
           channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_alt_fanout收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * ttl+dlx
     * 实现延时队列
     * 队列延时10s
     */
    @RabbitListener(queues="queue_dlx_fanout")
    public void receiveQueueSendDlxFanoutMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_dlx_fanout收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_dlx_fanout:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
          channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_dlx_fanout收到信息:{},降级补偿机制",Users.getName());
        }
    }

    /**
     * 默认情况下,如果没有配置手动ACK, 那么Spring Data AMQP 会在消息消费完毕后自动帮我们去ACK
     * 存在问题：如果报错了,消息不会丢失,但是会无限循环消费,一直报错,如果开启了错误日志很容易就吧磁盘空间耗完
     * 解决方案：手动ACK,或者try-catch 然后在 catch 里面将错误的消息转移到其它的系列中去
     * spring.rabbitmq.listener.simple.acknowledge-mode = manual
     * @param list 监听的内容
     */

    /**
     * rabbitmq_delayed_message_exchange
     * 实现延时队列
     */
    @RabbitListener(queues="queue_delay")
    public void receiveQueueSendDelayDirectMsg(Users Users, Message message, Channel channel) throws IOException {
        try {
            log.info("queue_delay收到信息:{}",Users.getName());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            log.error("queue_delay:接收消息出现异常");
            log.error(e.getMessage(),e);
            //通知队列删除
           channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            //补偿机制
            log.info("queue_delay收到信息:{},降级补偿机制",Users.getName());
        }
    }
}
