package com.juzi.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ZhiWei.Yang2 on 2016/10/20.
 */
public class RecevierMsg {
    private static final Logger logger = LoggerFactory.getLogger(RecevierMsg.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = {"test","helloworld.t"} )
    public void recevierMsg(String message) {
        logger.info("receiver message = {}" , message);
        System.out.println("============"+message+"==================");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
