package com.example.rabbit_consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Ken-Chy129
 * @date 2022/7/23 20:49
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("rabbitmqDemoTopic"))
public class Consumer {
    @RabbitHandler
    public void process(Map map) {
        System.out.println(map.toString());
    }
}
