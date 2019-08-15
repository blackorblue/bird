package free.bird.cpt1;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.Charset;

public class ScheduleProducer {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        // 创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("myProducerGroup");
        // 设置nameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动生产者
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message("myTopic", "tagA || tagB", "what the fuck".getBytes());
            // 发送的结果
            SendResult result = producer.send(message);
        }
        producer.shutdown();
    }
}
