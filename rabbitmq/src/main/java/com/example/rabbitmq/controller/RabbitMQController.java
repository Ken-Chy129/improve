package com.example.rabbitmq.controller;


import com.example.rabbitmq.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ken-Chy129
 * @date 2022/7/23 20:36
 */

@RestController
@RequestMapping("rabbitmq")
public class RabbitMQController {
    
    @Autowired
    private RabbitMQService rabbitMQService;
    
    @PostMapping("send")
    public String send(@RequestParam("msg") String msg) throws Exception {
        return rabbitMQService.sendMsg(msg);
    }
}
