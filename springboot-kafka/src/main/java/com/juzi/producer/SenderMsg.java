package com.juzi.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by ZhiWei.Yang2 on 2016/10/20.
 */
public class SenderMsg {
    private static final Logger logger = LoggerFactory.getLogger(SenderMsg.class);

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public void sendMsg(String topic, String msg) {
        //使用异步发送
        ListenableFuture<SendResult<Integer,String>> future = kafkaTemplate.send(topic,msg);


        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("send msg = {}", msg);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {
                logger.info("send msg = {} with offset = {}", msg ,
                        integerStringSendResult.getRecordMetadata().offset());
            }
        });
    }
}
