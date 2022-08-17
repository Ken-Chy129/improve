package com.example.rabbitmq.config;

/**
 * @author Ken-Chy129
 * @date 2022/7/23 19:57
 */
public class RabbitConfig {

    /**
     * RabbitMQ的队列主体名称
     */
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";

    /**
     * RabbitMQ交换机名称
     */
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";

    /**
     * RabbitMQ交换机和队列绑定的匹配键 directRouting
     */
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";
}
