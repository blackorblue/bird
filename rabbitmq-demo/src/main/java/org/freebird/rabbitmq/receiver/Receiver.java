package org.freebird.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhouziyan
 * @date 2019/6/25 15:16
 */
@Component
@RabbitListener(queues = "my-queue")
public class Receiver {

    /**
     * 如何解决消费幂等问题?
     * 每次消费的时候有一个消费时间,如果消费的时间和当前的时间一样就表示消费过了
     *
     * @param msg
     */
    @RabbitHandler
    public void receive(String msg) {
        // 乐观锁
        Date updDateTime = new Date();
        String updSql = "update set num = num + ?,modify_time = ? where id = ?";
        System.out.println(msg);
    }
}
