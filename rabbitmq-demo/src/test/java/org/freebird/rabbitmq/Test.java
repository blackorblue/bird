package org.freebird.rabbitmq;

import org.freebird.rabbitmq.producer.Producer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhouziyan
 * @date 2019/6/25 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {


    @Autowired
    private Producer producer;

    @org.junit.Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            producer.send("消费"+i+"条消息");
            Thread.sleep(100L);
        }
    }
}
