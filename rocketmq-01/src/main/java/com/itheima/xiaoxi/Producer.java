package com.itheima.xiaoxi;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

public class Producer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.137.130:9876");
        producer.start();
        for (int i = 0; i < 5; i++) {
            //同步消息
            //Message msg = new Message("topic1", ("hello" + i).getBytes());
            //SendResult result = producer.send(msg);

            //异步消息
            Message msg = new Message("topic1", ("hello--" + i).getBytes("UTF-8"));
            producer.send(msg, new SendCallback() {
                //返回成功
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                //返回失败
                public void onException(Throwable t) {
                    System.out.println(t);
                }
            });

            //单项消息
            // System.out.println("返回结果" + result);
        }
        TimeUnit.SECONDS.sleep(10);
        producer.shutdown();
    }
}
