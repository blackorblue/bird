package org.freebird.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhouziyan
 * @date 2019/6/25 14:19
 */
@Configuration
public class RabbitmqConfig {
    /**
     * 先创建队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return QueueBuilder.durable("my-queue").build();
    }

    /**
     * 再创建交换机
     * 交换机主要是4种模式
     * fanhout:
     * direct:
     * topic: 主要是1vn 即一个消息可以被多个队列以不同的逻辑方式进行消费
     *
     * @return
     */
    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange("my-exchange").build();
    }

    /**
     * 再将队列和交换机绑定在一起
     *
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("my-route-key").noargs();
    }

}
