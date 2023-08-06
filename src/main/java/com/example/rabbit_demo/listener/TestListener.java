package com.example.rabbit_demo.listener;

import com.example.rabbit_demo.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  //注册为Bean
public class TestListener {

    //定义此方法为队列yyds的监听器，一旦监听到新的消息，就会接受并处理
    @RabbitListener(queues = "yyds")
    public void test(Message message){
        System.out.println(new String(message.getBody()));
    }

    @RabbitListener(queues = "yyds")
    public String receiver(String data){
        System.out.println("一号消息队列监听器 "+data);
        return "收到!";
    }

    @RabbitListener(queues = "yyds", messageConverter = "jacksonConverter")
    public void receiver(User user){  //直接接收User类型
        System.out.println(user);
    }
}
