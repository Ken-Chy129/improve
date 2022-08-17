package com.example.rabbitmq.service.impl;

import com.example.rabbitmq.config.RabbitConfig;
import com.example.rabbitmq.service.RabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Ken-Chy129
 * @date 2022/7/23 20:24
 */
@Service
public class RabbitMQServiceImpl implements RabbitMQService {
    
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Override
    public String sendMsg(String msg) {
        try {
            String msgId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            String sendTime = simpleDateFormat.format(new Date());
            Map<String, Object> map = new HashMap<>();
            map.put("msgId", msgId);
            map.put("sendTime", sendTime);
            map.put("msg", msg);
            rabbitTemplate.convertAndSend(RabbitConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, RabbitConfig.RABBITMQ_DEMO_DIRECT_ROUTING, map);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
