package org.freebird.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhouziyan
 * @date 2019/6/25 15:16
 */
@Component
@RabbitListener(queues = "my-queue")
public class Receiver {

    /**
     * 如何解决消费幂等问题?
     *
     * @param msg
     */
    @RabbitHandler
    public void receive(String msg) {
        System.out.println(msg);
    }
}
