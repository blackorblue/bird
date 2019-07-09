package bird.free;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhouziyan
 * @review:
 * @Date: 2019/6/17 17:36
 */
@SpringBootApplication
public class TxApplication {

    public static void main(String[] args) {
        /**
         * 先写入消息表 状态是准备状态
         * 然后进行本地事务
         * 将消息查询出来,发送到消息中间件.消息状态为发送状态
         * 异地事务进行消息的消费,并完成事务.
         */
        SpringApplication.run(TxApplication.class, args);
    }
}
