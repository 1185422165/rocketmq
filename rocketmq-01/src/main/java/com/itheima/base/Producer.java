package com.itheima.base;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

//生产者
public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group1");

        producer.setNamesrvAddr("192.168.137.130:9876");
        producer.start();

        for (int i = 0; i < 10; i++) {

            Message message = new Message("topic1", ("生产者2:hello--" + i).getBytes("utf-8"));

            SendResult result = producer.send(message);

            System.out.println("返回值" + result);
        }
        producer.shutdown();
    }
}
