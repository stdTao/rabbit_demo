package com.example.rabbit_demo;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringCloudMqApplicationTests {
    @Resource
    RabbitTemplate template;

    @Test
    void publisher() {
        //使用convertAndSend方法一步到位，参数基本和之前是一样的
        //最后一个消息本体可以是Object类型，真是大大的方便
        template.convertAndSend("amq.direct", "my-yyds", "Hello World!");

        //会等待消费者消费然后返回响应结果
        Object res = template.convertSendAndReceive("amq.direct", "my-yyds", "Hello World!");
        System.out.println("收到消费者响应："+res);

    }


}
