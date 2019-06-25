package org.freebird.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhouziyan
 * @date 2019/6/25 15:14
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg){
        Object o = rabbitTemplate.convertSendAndReceive("my-exchange", "my-route-key", msg);
        //System.out.println(o);
    }
}
